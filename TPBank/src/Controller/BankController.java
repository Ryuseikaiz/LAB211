package Controller;

import View.Menu;
import java.util.Locale;
import java.util.Scanner;
import View.BankView;

public class BankController extends Menu<String> {

    private final BankView login;

    {
        login = new BankView();
    }

    static String[] options = {
        "Vietnamese",
        "English",
        "Exit"
    };
    Scanner sc = new Scanner(System.in);

    public BankController() {
        super("========= LOGIN PROGRAM  =========", options);
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                login.LoginBank(new Locale("vietnamese"));
                break;

            case 2:
                login.LoginBank(new Locale("english"));
                break;

            case 3:
                System.exit(0);
        }
    }
}
