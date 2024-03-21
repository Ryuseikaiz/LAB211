package Controller;

import java.util.ArrayList;
import Model.Contact;
import Common.FileLoadder;
import View.ContactView;
import View.Menu;

public class ContactController extends Menu {

    public ContactController() {
        super("======== Contact Program ========", new String[]{"Add a Contact", "Display all Contact", "Delete a Contact", "Exit"});
    }
    private FileLoadder file = new FileLoadder();
    ArrayList<Contact> contactList = file.loadData("input.txt");
    ContactView contView = new ContactView();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                contView.addNewContact(contactList);
                break;
            case 2:
                contView.printAllContact(contactList);
                break;
            case 3:
                contView.deleteContactd(contactList);
                break;
            case 4:
                System.exit(0);
                break;

        }
    }
}
