package controller;

import common.Algorithm;
import View.Menu;

public class DataProgramming {

    private final String[] MAIN_MENU_ITEMS = {
        " Check Phone Number",
        " Check Email",
        " Check Date",
        " Exit",};

    Algorithm algorithm = new Algorithm();

    Menu mainMenu = new Menu("====== Validate Progaram ======", MAIN_MENU_ITEMS) {
        @Override
        public void execute(int choice) {
            switch (choice) {
                case 1:
                    algorithm.checkPhoneNumber();
                    break;
                case 2:
                    algorithm.checkEmail();
                    break;
                case 3:
                    algorithm.checkDate();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }
    };

    public void run() {
        mainMenu.run();
    }
}
