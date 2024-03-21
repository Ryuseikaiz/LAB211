package Controller;

import Model.Trash;
import View.TrashView;
import View.Menu;

public class TrashController extends Menu {
    private final TrashView view = new TrashView();
    Trash trash;
    static String[] options = {
            "Calculate the cost of collecting trash",
            "Exit"
    };
    public TrashController() {
        super("========= TRASH COLLECTION CALCULATING =========", options);
        this.trash = view.createTrash();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: {
                System.out.println("Total cost estimated: " + view.CollectingTrash(trash) +"VND");
                break;
            }
            case 2: {
                System.exit(0);
            }
        }
    }
}