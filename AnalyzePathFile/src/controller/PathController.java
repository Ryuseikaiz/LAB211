package controller;

import common.Algorithm;
import view.Menu;

public class PathController {

    private final String[] MAIN_MENU_ITEMS = {
        " Please Input Path",
        " Exit",};

    Algorithm algorithm = new Algorithm();

    Menu mainMenu = new Menu("===== Analysis Path Program =====", MAIN_MENU_ITEMS) {
        @Override
        public void execute(int choice) {
            switch (choice) {
                case 1:
                    algorithm.checkInputPath();
                    break;
                case 2:
                    System.exit(0);
                    break;

            }
        }
    };

    public void run() {
        mainMenu.run();
    }
}
