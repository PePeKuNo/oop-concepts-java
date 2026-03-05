package introduction.exercises.tasks;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {

    @Test
    void deepCopy_ModifySkillsInCopy_OriginalUnchanged() {
        var original = new TeamCopyTask.Team("Alpha");
        original.addMember(new TeamCopyTask.TeamMember("Anna", "Dev", new ArrayList<>(List.of("Java", "SQL"))));

        var copy = original.deepCopy();
        copy.getMembers().get(0).addSkill("Python");

        assertEquals(List.of("Java", "SQL"), original.getMembers().get(0).getSkills());
        assertEquals(List.of("Java", "SQL", "Python"), copy.getMembers().get(0).getSkills());
    }

    @Test
    void deepCopy_AddMemberToCopy_OriginalUnchanged() {
        var original = new TeamCopyTask.Team("Alpha");
        original.addMember(new TeamCopyTask.TeamMember("Anna", "Dev", new ArrayList<>(List.of("Java"))));

        var copy = original.deepCopy();
        copy.addMember(new TeamCopyTask.TeamMember("Bob", "QA", new ArrayList<>()));

        assertEquals(1, original.size());
        assertEquals(2, copy.size());
    }

    @Test
    void deepCopy_MembersAreNewObjects() {
        var original = new TeamCopyTask.Team("Alpha");
        original.addMember(new TeamCopyTask.TeamMember("Anna", "Dev", new ArrayList<>(List.of("Java"))));

        var copy = original.deepCopy();
        assertNotSame(original.getMembers().get(0), copy.getMembers().get(0));
    }
}
