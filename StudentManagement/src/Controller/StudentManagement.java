/*
    * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
    * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import View.Menu;
import Controller.Common.Library;
import Model.Course;
import Model.Student;
import Model.Report;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HELLO
 */
public class StudentManagement extends Menu {

    static String[] menu = {"Create", "Find and Sort", "Update/Delete", "Report", "Exit"};
    Library lb;
    ArrayList<Course> cList;
    ArrayList<Student> stList;
    Student st;
    private static final int U = 1;
    private static final int D = 2;
    private static final int MIN_ID = 1;
    private static final int MAX_ID = 9999;
    private Map<Integer, Student> studentMap;
    private Map<Integer, Course> courseMap;

    public StudentManagement() {
        super("WELCOME TO STUDENT MANAGEMENT", menu);
        lb = new Library();
        cList = new ArrayList<>();
        stList = new ArrayList<>();
        st = new Student();
    }

    public void execute(int n) {
        switch (n) {
            case 1:
                createStudent();
                break;
            case 2:
                findSort();
                break;
            case 3:
                updateDelete();
                break;
            case 4:
                report();
                break;
            case 5:
                System.exit(0);
        }
    }

    public void createStudent() {
        int createdStudents = 0;
//      initializeStudents();
        do {
            String name = lb.getString("Enter Student name: ");
            int id = lb.getInt("Enter Student ID", 1, 9999);
            stList.add(new Student(id, name));

            int semester = lb.getInt("Enter semester", 1, 9);
            String courseName = lb.getString("Enter Course name (Java/.NET/C++): ");
            cList.add(new Course(id, semester, courseName));

            createdStudents++;

            if (createdStudents >= 10) {
                char continueChoice = lb.getString("Do you want to continue (Y/N)? ").toUpperCase().charAt(0);
                if (continueChoice != 'Y') {
                    break;
                } else {
                    createdStudents = 0; 
                }
            }
        } while (true); 
    }

    public boolean checkByID(ArrayList<Student> list, int id) {
        if (list.isEmpty()) {
            return false;
        } else {
            for (Student st : stList) {
                if (st.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public void displayStudent(ArrayList<Student> stList) {
        for (Student st : stList) {
            System.out.println("ID: " + st.getId() + " - Name: " + st.getName());
            for (Course cs : cList) {
                if (st.getId() == cs.getId()) {
                    System.out.println("Semester: " + cs.getSemester() + " - Course name: " + cs.getCourseName());
                }
            }
        }
    }

    public void findSort() {
        if (stList == null) {
            System.err.println("Empty list, please input");
            return;
        }
        ArrayList<Student> sortName = sortByName(stList);
        if (sortName.isEmpty()) {
            System.err.println("The student doesn't exist");
        } else {
            Collections.sort(sortName);
            displayStudent(sortName);
        }
    }

    public ArrayList<Student> sortByName(ArrayList<Student> stList) {
        ArrayList<Student> fList = new ArrayList<Student>();
        String name = lb.getString("Enter name to search: ");
        for (Student st : stList) {
            if (st.getName().contains(name)) {
                fList.add(st);
            }
        }
        return fList;
    }

    public ArrayList<Course> sortByCourseID(ArrayList<Course> stList, int id) {
        ArrayList<Course> fList = new ArrayList<Course>();
        for (Course st : stList) {
            if (st.getId() == id) {
                fList.add(st);
            }
        }
        return fList;
    }

    public ArrayList<Student> sortByStudentID(ArrayList<Student> stList, int id) {
        ArrayList<Student> fList = new ArrayList<Student>();

        for (Student st : stList) {
            if (st.getId() == id) {
                fList.add(st);
            }
        }
        return fList;
    }

    private String getStudentNameById(int id) {
        for (Student st : stList) {
            if (st.getId() == id) {
                return st.getName();
            }
        }
        return "";
    }

    public void updateDelete() {
        if (studentMap.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        int id = lb.getInt("Enter ID to search: ", MIN_ID, MAX_ID);
        Student st = studentMap.get(id);
        Course cs = courseMap.get(id);
        if (st == null || cs == null) {
            System.err.println("The student doesn't exist");
        } else {
            System.out.println("Do you want to Update (U) or delete (D)?");
            System.out.println("1. U");
            System.out.println("2. D");
            int c = lb.getInt("Your choice: ", U, D);
            switch (c) {
                case U:
                    st.setId(id);
                    st.setName(lb.getString("Enter Student name:"));
                    cs.setId(id);
                    cs.setSemester(lb.getInt("Enter Semester:", 1, 9));
                    cs.setCourseName(lb.getString("Enter Course name:"));
                    System.out.println("Updated");
                    break;
                case D:
                    cList.remove(cs);
                    stList.remove(st);
                    System.out.println("Deleted");
                    break;
                default:
                    return;
            }
        }
    }

    public void report() {
        if (stList == null) {
            System.err.println("Empty list, please input");
            return;
        }

        Map<String, Map<String, Integer>> reportMap = new HashMap<>();

        for (Course cs : cList) {
            String studentName = getStudentNameById(cs.getId());
            String courseName = cs.getCourseName();

            reportMap.putIfAbsent(studentName, new HashMap<>());
            reportMap.get(studentName).merge(courseName, 1, Integer::sum);
        }

        System.out.println("Report:");
        for (Map.Entry<String, Map<String, Integer>> entry : reportMap.entrySet()) {
            String studentName = entry.getKey();
            Map<String, Integer> coursesMap = entry.getValue();

            for (Map.Entry<String, Integer> courseEntry : coursesMap.entrySet()) {
                String courseName = courseEntry.getKey();
                int totalCourses = courseEntry.getValue();

                System.out.println(studentName + " | " + courseName + " | " + totalCourses);
            }
        }
    }

    private void initializeStudents() {
        for (int i = 1; i <= 9; i++) {
            String name = "Student" + i;
            stList.add(new Student(i, name));
            cList.add(new Course(i, 1, "Java"));
        }
    }
}
