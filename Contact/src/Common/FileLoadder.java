package Common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Model.Contact;

public class FileLoadder {

    Validation val = new Validation();        

    public ArrayList<Contact> loadData(String fileName) {
        ArrayList<Contact> contactList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split("\\|");
                    if (arr.length != 7) {
                        System.out.println("Invalid line: " + line);
                        continue;
                    }
                    int id = Integer.parseInt(arr[0]);
                    String fullName = arr[1];
                    String firstName = arr[2];
                    String lastName = arr[3];
                    String group = arr[4];
                    String address = arr[5];
                    String phone = arr[6];

                    if (val.checkInt(String.valueOf(id)) && val.isValidPhone(phone)) {
                        Contact contact = new Contact(id,fullName, group, address, phone, lastName, firstName);
                        contactList.add(contact);
                    } else {
                        System.out.println("Invalid data: " + line);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error parsing: " + line);
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data");
            System.out.println(e.getMessage());
        }

        return contactList;
    }
}