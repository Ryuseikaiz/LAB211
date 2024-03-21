package Controller;

import View.DictionaryView;
import View.Menu;
        
public class DictionaryController extends Menu {
    private DictionaryView view;
    static String[] options = {"Add Word", "Delete Word", "Translate", "Exit"};

    public DictionaryController() {
        super("========= Dictionary program =========", options);
        this.view = new DictionaryView();
    }

    public void execute(int choice) {
        switch (choice) {
            case 1:
                view.addWord();
                break;
            case 2:
                view.removeWord();
                break;
            case 3:
                view.translate();
                break;
            case 4:
                System.out.println("Exit");
        }
    }
}
