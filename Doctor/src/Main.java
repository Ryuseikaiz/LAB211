import Common.Inputter;
import Controller.DoctorController;

public class Main {
    public static void main(String[] args) {
        Inputter inputter = new Inputter();
        DoctorController doctorController = new DoctorController(inputter);
        doctorController.run();
    }
}