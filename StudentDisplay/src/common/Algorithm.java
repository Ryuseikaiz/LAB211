package common;

import model.Person;
import model.PersonWrapper;

public class Algorithm {

    Validation validation = new Validation();
    
     public  Person inputPersonInfo() {
        System.out.println("Input Information of Person");
        System.out.print("Please input name: ");
        String name = validation.checkInputString();
        System.out.print("Please input address: ");
        String address = validation.checkInputString();
        System.out.print("Please input salary: ");
        double salary = validation.checkInputSalary();
        return new Person(name, address, salary);
    }

    public  void swap(PersonWrapper person1, PersonWrapper person2) {
        Person temp = person1.p;
        person1.p = person2.p;
        person2.p = temp;
    }

    public  void sortBySalary(Person[] persons, PersonWrapper[] listPersonWrapper) {
        int n = persons.length;

        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i] = new PersonWrapper(persons[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listPersonWrapper[i].p.salary > listPersonWrapper[j].p.salary) {
                    swap(listPersonWrapper[i], listPersonWrapper[j]);
                }
            }
        }
        System.err.println("Sort sussess.");
        return;
    }
    
}