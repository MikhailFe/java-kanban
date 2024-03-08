// Я, если честно сломался)
// Не понимаю уже, что происходит в коде)
// Мне тяжело дается понимание, как вы ревьюеры, каждый день разбираетесь в таких программах)
// Хочеться сказать, большое спасибо вам за вашу работу))


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        Task task1 = new Task(1, "Переезд", "Описание задачи переезда");
        taskManager.createTask(task1);

        Subtask subtask1 = new Subtask(2, "Упаковать вещи", "Описание задачи упаковки вещей", 1);
        taskManager.createSubtask(subtask1);

        ArrayList<Integer> subTaskId = new ArrayList<>();
        subTaskId.add(subtask1.getId());

        Epic epic1 = new Epic(3, "Большой проект", "Описание большого проекта", subTaskId);
        taskManager.createEpic(epic1);

        System.out.println(taskManager.getTaskById(1).getTitle());
        System.out.println(taskManager.getSubtaskById(2).getTitle());
        System.out.println(taskManager.getEpicById(3).getTitle());

    }
}
