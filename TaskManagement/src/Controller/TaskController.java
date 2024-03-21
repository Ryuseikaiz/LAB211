package Controller;

import java.util.ArrayList;
import Model.TaskModel;
import View.Menu;
import View.TaskView;

public class TaskController extends Menu {

    public TaskController() {
        super("====== Task Program ======", new String[]{"Add Task", "Delete Task", "Display Task", "Exit"});
    }
    TaskView taskView = new TaskView();
    ArrayList<TaskModel> taskList = new ArrayList<>();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                taskView.addTask(taskList);
                break;
            case 2:
                taskView.deleteTask(taskList);
                break;
            case 3:
                taskView.printList(taskList);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
}