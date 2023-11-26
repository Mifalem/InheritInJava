import org.example.InheritInJava.services.Epic;
import org.example.InheritInJava.services.Meeting;
import org.example.InheritInJava.services.SimpleTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldCheckSimpleTaskWhenMatches() {
        SimpleTask simpleTask = new SimpleTask(1569, "Во вторник");

        boolean actual = simpleTask.matches("вторник");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldCheckSimpleTaskWhenNotMatches() {
        SimpleTask simpleTask = new SimpleTask(1569, "Во вторник");

        boolean actual = simpleTask.matches("Вторник");
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldCheckEpicWhenMatches() {
        String[] subtasks = {"Монитор", "Материнка"};
        Epic epic = new Epic(183, subtasks);

        boolean actual = epic.matches("Материнка");

        Assertions.assertTrue(actual);

    }

    @Test
    public void shouldCheckEpicWhenNotMatches() {
        String[] subtasks = {"Монитор", "Материнка"};
        Epic epic = new Epic(183, subtasks);

        boolean actual = epic.matches("МатеринкА");

        Assertions.assertFalse(actual);

    }


    @Test
    public void shouldCheckMeetingWhenTopicMatches() {
        Meeting meeting = new Meeting(11, "Выбор компьютера", "Обзор материнских плат", "завтра утром");

        boolean actual = meeting.matches("компьютера");
        Assertions.assertTrue(actual);

    }

    @Test
    public void shouldCheckMeetingWhenTopicNotMatches() {
        Meeting meeting = new Meeting(11, "Выбор компьютера", "Обзор материнских плат", "завтра утром");

        boolean actual = meeting.matches("выбор компьютера");
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldCheckMeetingWhenProjectMatches() {
        Meeting meeting = new Meeting(11, "Выбор компьютера", "Обзор материнских плат", "завтра утром");

        boolean actual = meeting.matches("плат");
        Assertions.assertTrue(actual);

    }

    @Test
    public void shouldCheckMeetingWhenProjectNotMatches() {
        Meeting meeting = new Meeting(11, "Выбор компьютера", "Обзор материнских плат", "завтра утром");

        boolean actual = meeting.matches("платы");
        Assertions.assertFalse(actual);


    }

    @Test
    public void shouldCheckMeetingWhenNotMatches() {
        Meeting meeting = new Meeting(11, "", "", "завтра утром");


        boolean actual = meeting.matches("платы");
        Assertions.assertFalse(actual);


    }

    @Test
    public void shouldCheckMeetingWhenMatchesEverywhere() {
        Meeting meeting = new Meeting(11, "Обзор материнской платы", "Выбор материнской платы", "завтра утром");


        boolean actual = meeting.matches("платы");
        Assertions.assertTrue(actual);


    }

    @Test
    public void shouldCheckMeetingWhenMatches() {
        Meeting meeting = new Meeting(11, "", "", "завтра утром");


        boolean actual = meeting.matches("");
        Assertions.assertTrue(actual);


    }

}
