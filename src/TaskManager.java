import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private final HashMap<Integer, Task> tasks;


    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    public void createTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void createEpic(Epic epic) {
        tasks.put(epic.getId(), epic);
    }

    public void createSubtask(Subtask subtask) {
        tasks.put(subtask.getId(), subtask);
    }


    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public Epic getEpicById(int id) {
        return (Epic) tasks.get(id);
    }

    public Subtask getSubtaskById(int id) {
        return (Subtask) tasks.get(id);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public List<Epic> getAllEpics() {
        List<Epic> epics = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task instanceof Epic) {
                epics.add((Epic) task);
            }
        }
        return epics;
    }

    public List<Subtask> getAllSubtasks() {
        List<Subtask> subtasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task instanceof Subtask) {
                subtasks.add((Subtask) task);
            }
        }
        return subtasks;
    }

    public List<Subtask> getSubtasksByEpicId(int epicId) {
        List<Subtask> subtasks = new ArrayList<>();
        Epic epic = getEpicById(epicId);
        if (epic != null) {
            List<Integer> subtaskIds = epic.getSubTaskIds();
            for (Integer subtaskId : subtaskIds) {
                Subtask subtask = getSubtaskById(subtaskId);
                if (subtask != null) {
                    subtasks.add(subtask);
                }
            }
        }
        return subtasks;
    }

    public void updateTask(Task updatedTask) {
        tasks.put(updatedTask.getId(), updatedTask);
    }

    public void updateEpic(Epic updatedEpic) {
        tasks.put(updatedEpic.getId(), updatedEpic);
    }

    public void updateSubtask(Subtask updatedSubtask) {
        tasks.put(updatedSubtask.getId(), updatedSubtask);
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }

    public void deleteEpic(int id) {
        Epic epicToDelete = (Epic) tasks.get(id);
        if (epicToDelete != null) {
            List<Integer> subtaskIds = epicToDelete.getSubTaskIds();
            for (Integer subtaskId : subtaskIds) {
                tasks.remove(subtaskId);
            }
            tasks.remove(id);
        }
    }

    public void deleteSubtask(int id) {
        tasks.remove(id);
    }

    public void clearAllTasks() {
        tasks.clear();
    }

    public void deleteAllEpics() {
        List<Integer> epicIds = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task instanceof Epic) {
                epicIds.add(task.getId());
            }
        }
        for (Integer id : epicIds) {
            tasks.remove(id);
        }
    }

    public void deleteAllSubtasks() {
        List<Integer> subtaskIds = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task instanceof Subtask) {
                subtaskIds.add(task.getId());
            }
        }
        for (Integer id : subtaskIds) {
            tasks.remove(id);
        }


    }

    public void updateEpicStatus(int epicId) {
        Epic epic = getEpicById(epicId);
        if (epic != null) {
            List<Integer> subtaskIds = epic.getSubTaskIds();
            boolean allDone = true;
            boolean allNew = true;

            for (Integer subtaskId : subtaskIds) {
                Subtask subtask = getSubtaskById(subtaskId);
                if (subtask != null) {
                    if (subtask.getStatus() != TaskStatus.DONE) {
                        allDone = false;
                    }
                    if (subtask.getStatus() != TaskStatus.NEW) {
                        allNew = false;
                    }
                }
            }

            if (allDone) {
                epic.setStatus(TaskStatus.DONE);
            } else if (allNew) {
                epic.setStatus(TaskStatus.NEW);
            } else {
                epic.setStatus(TaskStatus.IN_PROGRESS);
            }

            updateEpic(epic);
        }
    }


}
