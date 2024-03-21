package controller;

import common.Algorithm;
import common.Validation;
import model.Person;
import model.PersonWrapper;
import view.Menu;

public class PersonController {

    private final String[] MAIN_MENU_ITEMS = {
        " Input Infomation",
        " Exit",};
    
    Validation validation = new Validation();
    Algorithm algorithm = new Algorithm();

    Menu mainMenu = new Menu("=====Management Person programer=====", MAIN_MENU_ITEMS) {
        @Override
        public void execute(int choice) {
            switch (choice) {
                case 1:
                    int n = validation.checkInputNumberStudent();
                    Person[] persons = new Person[n];
                    for (int i = 0; i < persons.length; i++) {
                        persons[i] = algorithm.inputPersonInfo();
                    }
                    PersonWrapper[] listPersonWrapper = new PersonWrapper[persons.length];
                    algorithm.sortBySalary(persons, listPersonWrapper);
                    for (int i = 0; i < persons.length; i++) {
                        listPersonWrapper[i].p.displayPersonInfo();
                    }
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
