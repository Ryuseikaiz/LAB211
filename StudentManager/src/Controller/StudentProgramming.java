package controller;

import Common.Algorithm;
import View.Menu;


public class StudentProgramming {

    private final String[] MAIN_MENU_ITEMS = {
        " Input Student",
        " Display Student",
        " Exit",};

    Algorithm algorithm = new Algorithm();

    Menu mainMenu = new Menu("======== Student Program ========", MAIN_MENU_ITEMS) {
        @Override
        public void execute(int choice) {
            switch (choice) {
                case 1:
                    algorithm.display();
                    break;
                case 2:
                    algorithm.print();
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
