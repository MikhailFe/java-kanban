import java.util.HashMap;
public class TaskManager {

final private HashMap<Integer, Task> tasks;
public TaskManager() {
    this.tasks = new HashMap<>();
}

    public void createTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public void updateTask(Task updatedTask) {
        tasks.put(updatedTask.getId(), updatedTask);
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }

    public void clearAllTasks() {
        tasks.clear();
    }

}
