package controller;

import common.Algorithm;
import view.Menu;

public class StringController {

    private final String[] MAIN_MENU_ITEMS = {
        " Input",
        " Result",
        " Exit",};

    Algorithm algorithm = new Algorithm();

    Menu mainMenu = new Menu("===== Analysis String program ====", MAIN_MENU_ITEMS) {
        @Override
        public void execute(int choice) {
            switch (choice) {
                case 1:
                    algorithm.input();
                    break;
                case 2:
                    algorithm.result();
                    break;
                case 3:
                    System.exit(0);
                    break;

            }
        }
    };

    public void run() {
        mainMenu.run();
    }
}
