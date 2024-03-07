public class Main {

    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        Task task1 = new Task(1, "Переезд", "Описание задачи переезда");
        taskManager.createTask(task1);

        Subtask subtask1 = new Subtask(2, "Упаковать вещи", "Описание задачи упаковки вещей", 1);
        taskManager.createTask(subtask1);

        Epic epic1 = new Epic(3, "Большой проект", "Описание большого проекта");
        taskManager.createTask(epic1);

        System.out.println(taskManager.getTaskById(1).getTitle());
        System.out.println(taskManager.getTaskById(2).getTitle());
        System.out.println(taskManager.getTaskById(3).getTitle());

    }
}
