package introduction.exercises.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * ZADANIE 2: Głęboka kopia klasy TeamMember
 */
public class TeamCopyTask {

    public static class TeamMember {
        private String name;
        private String role;
        private List<String> skills;

        public TeamMember(String name, String role, List<String> skills) {
            this.name = name;
            this.role = role;
            this.skills = new ArrayList<>(skills);
        }

        // Copy constructor — deep copy
        public TeamMember(TeamMember other) {
            this.name = other.name;
            this.role = other.role;
            this.skills = new ArrayList<>(other.skills);
        }

        public void addSkill(String skill) { skills.add(skill); }
        public List<String> getSkills()    { return skills; }
        public String getName()            { return name; }
        public String getRole()            { return role; }

        @Override
        public String toString() {
            return name + " (" + role + ") skills=" + skills;
        }
    }

    public static class Team {
        private String teamName;
        private List<TeamMember> members;

        public Team(String teamName) {
            this.teamName = teamName;
            this.members = new ArrayList<>();
        }

        public void addMember(TeamMember member) {
            members.add(member);
        }

        public Team deepCopy() {
            Team copy = new Team(this.teamName);
            for (TeamMember m : members) {
                copy.members.add(new TeamMember(m));
            }
            return copy;
        }

        public List<TeamMember> getMembers() { return members; }
        public String getTeamName()          { return teamName; }
        public int size()                    { return members.size(); }

        @Override
        public String toString() {
            return "Team[" + teamName + ", members=" + members + "]";
        }
    }

    public static void main(String[] args) {
        Team original = new Team("Alpha");
        original.addMember(new TeamMember("Anna", "Dev", new ArrayList<>(List.of("Java", "SQL"))));
        original.addMember(new TeamMember("Bob",  "QA",  new ArrayList<>(List.of("Selenium"))));

        Team copy = original.deepCopy();
        copy.getMembers().get(0).addSkill("Python");
        copy.addMember(new TeamMember("Charlie", "DevOps", new ArrayList<>(List.of("Docker"))));

        System.out.println("Original: " + original);
        System.out.println("Copy:     " + copy);
        // Anna in original should still have [Java, SQL]
    }
}
