package View;

import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Internship;
import java.util.ArrayList;

public class View {
    public static void printCandidates(ArrayList<Candidate> candidates) {
        System.out.println("List of candidates:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("===========FRESHER CANDIDATE===============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }

    public static void printMessage(String message) {
        System.err.println(message);
    }
}
