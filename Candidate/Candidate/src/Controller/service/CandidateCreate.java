package Controller.service;

import java.util.ArrayList;
import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Internship;
import View.View;

public class CandidateCreate {

    public static void createCandidate(ArrayList<Candidate> candidates, int type) {
        while (true) {
            System.out.print("Enter id: ");
            String id = Inputter.checkInputString();
            System.out.print("Enter first name: ");
            String firstName = Inputter.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = Inputter.checkInputString();
            System.out.print("Enter birth year: ");
            int birthYear = Inputter.checkInputBirthYear();
            System.out.print("Enter address: ");
            String address = Inputter.checkInputString();
            System.out.print("Enter phone: ");
            String phone = Inputter.checkInputPhone();
            System.out.print("Enter email: ");
            String email = Inputter.checkInputEmail();
            Candidate candidate = new Candidate(id, firstName, lastName,
                    birthYear, address, phone, email, type);
            if (Inputter.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperienceCandidate(candidates, candidate);
                        break;
                    case 1:
                        createFresherCandidate(candidates, candidate);
                        break;
                    case 2:
                        createInternshipCandidate(candidates, candidate);
                        break;
                }
            } else {
                View.printMessage("Candidate ID already exists.");
                return;
            }
            System.out.print("Do you want to continue?(Y/N): ");
            if (!Inputter.checkInputYN()) {
                return;
            }
        }
    }

    public static void createExperienceCandidate(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = Inputter.checkInputExprience(candidate.getBirthYear());
        System.out.print("Enter professional skill: ");
        String professionalSkill = Inputter.checkInputString();
        candidates.add(new Experience(yearExperience, professionalSkill,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthYear(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Created successfully.");
    }

    public static void createFresherCandidate(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter graduation year: ");
        String graduationYear = Inputter.checkInputString();
        System.out.print("Enter graduation rank (Excellence/Good/Fair/Poor): ");
        String graduationRank = Inputter.checkInputGraduationRank();
        candidates.add(new Fresher(graduationYear, graduationRank, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthYear(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Created successfully.");
    }

    public static void createInternshipCandidate(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter major: ");
        String major = Inputter.checkInputString();
        System.out.print("Enter semester: ");
        String semester = Inputter.checkInputString();
        System.out.print("Enter university: ");
        String university = Inputter.checkInputString();
        candidates.add(new Internship(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthYear(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Created successfully.");
    }
}
