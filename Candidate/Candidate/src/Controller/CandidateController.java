package Controller;

import Controller.service.CandidateCreate;
import Controller.service.CandidateSearch;
import java.util.ArrayList;
import java.util.Scanner;
import Model.Candidate;
import View.Menu;

public class CandidateController extends Menu<String> {

    private ArrayList<Candidate> candidates = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public CandidateController() {
        super("CANDIDATE MANAGEMENT SYSTEM", new String[]{
            "Experience",
            "Fresher",
            "Internship",
            "Searching",
            "Exit"
        });
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                System.out.println("Enter details for Experience candidate:");
                CandidateCreate.createCandidate(candidates, 0);
                break;
            case 2:
                System.out.println("Enter details for Fresher candidate:");
                CandidateCreate.createCandidate(candidates, 1);
                break;
            case 3:
                System.out.println("Enter details for Internship candidate:");
                CandidateCreate.createCandidate(candidates, 2);
                break;
            case 4:
                System.out.println("Enter name and type for Searching:");
                CandidateSearch.searchCandidate(candidates);
                break;
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
    }
}
