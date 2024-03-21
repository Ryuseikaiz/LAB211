package View;

import Common.Inputter;
import Model.Doctor;
import java.util.HashMap;
import java.util.Map;

public class DoctorView {

    private HashMap<String, Doctor> doctorDatabase;
    private Inputter inputter;

    public DoctorView(Inputter inputter) { 
        this.doctorDatabase = new HashMap<>();
        this.inputter = inputter;
    }

    public boolean addDoctor() throws Exception {
        if (doctorDatabase == null) {
            throw new Exception("Database does not exist");
        }
        System.out.println("--------- Add Doctor ----------");
        String doctorCode = inputter.getString("Enter Code");
        String doctorName = inputter.getString("Enter Name");
        String specialization = inputter.getString("Enter Specialization");
        int availability = inputter.getInt("Enter Availability");
        Doctor doctor = new Doctor(doctorCode, doctorName, specialization, availability);
        doctor.setCode(doctorCode);
        doctor.setName(doctorName);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        if (doctorDatabase.containsKey(doctorCode)) {
            throw new Exception("Doctor code " + doctorCode + " is duplicate");
        }
        doctorDatabase.put(doctorCode, doctor);
        return true;
    }

    public boolean updateDoctor() throws Exception {
        if (doctorDatabase == null) {
            throw new Exception("Database does not exist");
        }
        System.out.println("--------- Update Doctor ----------");
        String doctorCode = inputter.getString("Enter Doctor Code");
        if (!doctorDatabase.containsKey(doctorCode)) {
            throw new Exception("Doctor code " + doctorCode + " doesn't exist");
        }
        String updatedName = inputter.getString("Enter Updated Name");
        String updatedSpecialization = inputter.getString("Enter Updated Specialization");
        int updatedAvailability = inputter.getInt("Enter Updated Availability");
        Doctor existingDoctor = doctorDatabase.get(doctorCode);
        existingDoctor.setName(updatedName);
        existingDoctor.setSpecialization(updatedSpecialization);
        existingDoctor.setAvailability(updatedAvailability);
        return true;
    }
    
    public boolean deleteDoctor() throws Exception {
        if (doctorDatabase == null) {
            throw new Exception("Database does not exist");
        }
        System.out.println("--------- Delete Doctor ----------");
        String doctorCode = inputter.getString("Enter Doctor Code:");
        if (!doctorDatabase.containsKey(doctorCode)) {
            throw new Exception("Doctor code " + doctorCode + " doesn't exist");
        }
        String confirmation = inputter.getString("Are you sure you want to delete this doctor? (yes/no):");
        if (confirmation.equalsIgnoreCase("yes")) {
            doctorDatabase.remove(doctorCode);
            System.out.println("Doctor deleted successfully.");
            return true;
        } else {
            System.out.println("Deletion canceled.");
            return false;
        }
    }
    
    public void searchAndDisplayResults() {
        System.out.println("--------- Search Doctor ------------");
        try {
            String searchText = inputter.getString("Enter text");
            HashMap<String, Doctor> searchResults = searchDoctor(searchText);
            displaySearchResults(searchResults);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void displaySearchResults(HashMap<String, Doctor> searchResults) {
        System.out.println("--------- Result ------------");
        System.out.printf("%-10s%-20s%-20s%-15s%n", "Code", "Name", "Specialization", "Availability");

        for (Map.Entry<String, Doctor> entry : searchResults.entrySet()) {
            Doctor doctor = entry.getValue();
            System.out.printf("%-10s%-20s%-20s%-15s%n",
                    doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
        }
    }

    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        if (doctorDatabase == null) {
            throw new Exception("Database does not exist");
        }
        HashMap<String, Doctor> result = new HashMap<>();
        for (Map.Entry<String, Doctor> entry : doctorDatabase.entrySet()) {
            Doctor doctor = entry.getValue();
            String doctorInfo = doctor.toString();
            if (doctorInfo.toLowerCase().contains(input.toLowerCase())) {
                result.put(entry.getKey(), doctor);
            }
        }

        return result;
    }
}
