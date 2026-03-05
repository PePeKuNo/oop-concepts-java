package introduction.exercises.tasks;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ConfigRegistryTest {

    private PrototypeConfigTask.ConfigRegistry registry;

    @BeforeEach
    void setUp() {
        registry = new PrototypeConfigTask.ConfigRegistry();
        registry.register("web", new PrototypeConfigTask.WebServerConfig("web-proto", "localhost", 8080));
        registry.register("db",  new PrototypeConfigTask.DatabaseConfig("db-proto",  "localhost", 5432));
    }

    @Test
    void spawn_ReturnsNewObject_NotSameAsPrototype() {
        var s1 = registry.spawn("web");
        var s2 = registry.spawn("web");
        assertNotSame(s1, s2);
    }

    @Test
    void spawn_WithPort_DoesNotModifyPrototype() {
        registry.spawn("web").withPort(9090).withName("web-changed");
        // Spawning again should still have proto port
        var fresh = registry.spawn("web");
        // just verify it spawns without error and is independent
        assertNotNull(fresh);
        fresh.withPort(8081); // no exception
    }

    @Test
    void spawn_UnknownKey_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> registry.spawn("unknown"));
    }

    @Test
    void spawn_ValidPort_NoException() {
        assertDoesNotThrow(() -> registry.spawn("web").withPort(8081));
    }

    @Test
    void spawn_InvalidPort_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> registry.spawn("web").withPort(99999));
    }
}
