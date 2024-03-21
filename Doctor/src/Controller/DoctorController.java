package Controller;

import Common.Inputter;
import View.DoctorView;
import View.Menu;

public class DoctorController extends Menu {

    private DoctorView doctorView;

    public DoctorController(Inputter inputter) {
        super("========= Doctor Management ==========", new String[]{"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"});
        this.doctorView = new DoctorView(inputter);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                try {
                    doctorView.addDoctor();
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                break;
            case 2:
                try {
                    doctorView.updateDoctor();
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                break;
            case 3:
                try {
                    doctorView.deleteDoctor();
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                break;
            case 4:
                try {
                    doctorView.searchAndDisplayResults();
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
                break;
            case 5:
                System.exit(0);
                break;
        }
    }
}
