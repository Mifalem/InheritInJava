import org.example.InheritInJava.services.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenFewTaskAdded() {

        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] actual = todos.search("Молоко");
        Task[] expected = {simpleTask, epic};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchWhenWordNotMatch() {

        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] actual = todos.search("сделать");
        Task[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchWhenWordOnlyInOneTask() {

        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] actual = todos.search("Приложение");
        Task[] expected = {meeting};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchWhenWordInAllTask() {

        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] actual = todos.search("о");
        Task[] expected = {simpleTask, epic, meeting};

        Assertions.assertArrayEquals(expected, actual);

    }


}
