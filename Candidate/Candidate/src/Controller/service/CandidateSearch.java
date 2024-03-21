package Controller.service;

import Model.Candidate;
import static View.View.printCandidates;
import java.util.ArrayList;

public class CandidateSearch {

    public static void searchCandidate(ArrayList<Candidate> candidates) {
        printCandidates(candidates);
        System.out.print("Enter candidate name (First name or Last name): ");
        String nameSearch = Inputter.checkInputString();
        System.out.print("Enter type of candidate (0=Experience Candidate,1=Fresher Candidate,2=Intern Candidate):  ");
        int typeCandidate = Inputter.checkInputIntLimit(0, 2);
        boolean candidateFound = false;
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && (candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch))) {
                System.out.println(candidate.toString());
                candidateFound = true;
            }
        }
        if (!candidateFound) {
            System.out.println("No candidates found");
        }
    }
}
