package View;

import java.util.ArrayList;
import Model.Contact;
import Common.Inputter;
import Common.Validation;

public class ContactView {

    public ContactView() {
    }

    Inputter input = new Inputter();
    
    public void addNewContact(ArrayList<Contact> arr) {
        String contName = input.getString("Enter Name");
        String[] nameParts = contName.split("\\s", 2);

        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[1] : ""; 
        String group = input.getString("Enter Group");
        String address = input.getString("Enter Address");
        System.out.print("Enter Phone: ");
        String phone = input.checkInputPhone();

        Contact newCont = new Contact(contName, group, address, phone, firstName, lastName);
        createContact(newCont, arr);
        System.out.println("Successful");
    }

    private void createContact(Contact contact, ArrayList<Contact> arr) {
        int id = arr.size() + 1;
        contact.setID(id);
        arr.add(contact);
    }
    
    public void printAllContact(ArrayList<Contact> arr) {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        for (Contact contact : arr) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getID(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }
    
    public void deleteContactd(ArrayList<Contact> arr) {        
        int idDelete = input.getInt("Enter id");
        Contact contactDelete = getContactById(arr, idDelete);
        if (contactDelete == null) {
            System.out.println("Not found contact.");
            return;
        } else {
            arr.remove(contactDelete);
        }
        System.out.println("Delete successful.");
    }
    
    private Contact getContactById(ArrayList<Contact> arr, int idDelete) {
        for (Contact contact : arr) {
            if (contact.getID()== idDelete) {
                return contact;
            }
        }
        return null;
    }
}