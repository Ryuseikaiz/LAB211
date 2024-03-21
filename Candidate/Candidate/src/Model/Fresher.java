package Model;

public class Fresher extends Candidate {

    private String graduationYear;
    private String graduationRank;

    public Fresher() {
        super();
    }

    public Fresher(String graduationYear, String graduationRank, String id, String firstName, String lastName, int birthYear, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, birthYear, address, phone, email,
                typeCandidate);
        this.graduationYear = graduationYear;
        this.graduationRank = graduationRank;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

}
