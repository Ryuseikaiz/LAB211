package Common;

import java.util.ArrayList;
import java.util.Collections;
import Model.Student;

public class Algorithm {

    Validation validation = new Validation();
    ArrayList<Student> lt = new ArrayList<>();
    
    public void addStudent() {
        System.out.println("Please input student information ");
        System.out.print("Name: ");
        String name = validation.checkInputString();
        System.out.print("Classes: ");
        String classes = validation.checkInputString();
        System.out.print("Mark: ");
        float mark = validation.checkInputFloat();
        lt.add(new Student(name, mark, classes));
    }

    public void print() {
        if (lt.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        Collections.sort(lt);
        for (int i = 0; i < lt.size(); i++) {
            System.out.println("--------Student " + (i+1) + "--------");
            System.out.println("Name: " + lt.get(i).getName());
            System.out.println("Classes: " + lt.get(i).getClasses());
            System.out.println("Mark: " + lt.get(i).getMark());
        }
    }

    public void display() {
        addStudent();
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (validation.checkInputYN()) {
                addStudent();
            } else {
                break;
            }
        }
    }
}
