import java.util.ArrayList;
public class Epic extends Task {

    private ArrayList<Integer> subTaskId = new ArrayList<>();

    public Epic(int id, String title, String description, ArrayList<Integer> subTaskId) {
        super(id, title, description);
        this.subTaskId = subTaskId;
    }

    public ArrayList<Integer> getSubTaskIds() {
        return subTaskId;
    }

    public void setSubTaskIds(ArrayList<Integer> subTaskIds) {
        this.subTaskId = subTaskIds;
    }
}
