package introduction.exercises.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * ZADANIE 3: Wzorzec Prototype — konfiguracja serwera
 */
public class PrototypeConfigTask {

    interface ServerConfig {
        ServerConfig copy();
        String getType();
        ServerConfig withPort(int port);
        ServerConfig withHost(String host);
        ServerConfig withName(String name);
        void start();
    }

    static class WebServerConfig implements ServerConfig {
        private String name;
        private String host;
        private int port;
        private int maxConnections;
        private boolean sslEnabled;

        public WebServerConfig(String name, String host, int port) {
            this.name = name;
            this.host = host;
            this.port = port;
            this.maxConnections = 100;
            this.sslEnabled = false;
        }

        // Copy constructor
        private WebServerConfig(WebServerConfig other) {
            this.name = other.name;
            this.host = other.host;
            this.port = other.port;
            this.maxConnections = other.maxConnections;
            this.sslEnabled = other.sslEnabled;
        }

        @Override public ServerConfig copy()           { return new WebServerConfig(this); }
        @Override public String getType()              { return "web"; }
        @Override public ServerConfig withPort(int p)  { validatePort(p); this.port = p; return this; }
        @Override public ServerConfig withHost(String h){ this.host = h; return this; }
        @Override public ServerConfig withName(String n){ this.name = n; return this; }
        public WebServerConfig withMaxConnections(int m){ this.maxConnections = m; return this; }
        public WebServerConfig withSsl(boolean ssl)    { this.sslEnabled = ssl; return this; }

        @Override
        public void start() {
            System.out.println("Starting web server " + name + " at " + host + ":" + port
                + (sslEnabled ? " [SSL]" : ""));
        }

        private void validatePort(int p) {
            if (p < 1 || p > 65535) throw new IllegalArgumentException("Port must be 1-65535");
        }
    }

    static class DatabaseConfig implements ServerConfig {
        private String name;
        private String host;
        private int port;
        private String dbName;
        private int poolSize;

        public DatabaseConfig(String name, String host, int port) {
            this.name = name;
            this.host = host;
            this.port = port;
            this.dbName = "default";
            this.poolSize = 10;
        }

        private DatabaseConfig(DatabaseConfig other) {
            this.name = other.name;
            this.host = other.host;
            this.port = other.port;
            this.dbName = other.dbName;
            this.poolSize = other.poolSize;
        }

        @Override public ServerConfig copy()           { return new DatabaseConfig(this); }
        @Override public String getType()              { return "database"; }
        @Override public ServerConfig withPort(int p)  { this.port = p; return this; }
        @Override public ServerConfig withHost(String h){ this.host = h; return this; }
        @Override public ServerConfig withName(String n){ this.name = n; return this; }
        public DatabaseConfig withDatabase(String db)  { this.dbName = db; return this; }
        public DatabaseConfig withPoolSize(int size)   { this.poolSize = size; return this; }

        @Override
        public void start() {
            System.out.println("Starting database server " + name + " at " + host + ":" + port
                + " db=" + dbName + " pool=" + poolSize);
        }
    }

    static class ConfigRegistry {
        private final Map<String, ServerConfig> prototypes = new HashMap<>();

        public void register(String key, ServerConfig prototype) {
            prototypes.put(key, prototype);
        }

        public ServerConfig spawn(String key) {
            ServerConfig proto = prototypes.get(key);
            if (proto == null) throw new IllegalArgumentException("Unknown config key: " + key);
            return proto.copy();
        }
    }

    public static void main(String[] args) {
        ConfigRegistry reg = new ConfigRegistry();
        reg.register("web", new WebServerConfig("web-proto", "localhost", 8080));
        reg.register("db",  new DatabaseConfig("db-proto",  "localhost", 5432));

        ServerConfig s1 = reg.spawn("web").withPort(8081).withName("web-1");
        ServerConfig s2 = reg.spawn("web").withPort(8082).withName("web-2");
        ServerConfig db = reg.spawn("db").withPort(5433).withName("db-1");

        s1.start(); // Starting web server web-1 at localhost:8081
        s2.start(); // Starting web server web-2 at localhost:8082
        db.start(); // Starting database server db-1 at localhost:5433
    }
}
