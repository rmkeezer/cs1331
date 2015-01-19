public class Professor extends Person {

    private int rateMyProfessorRating;
    private double averageGPA;

    public Professor(String firstName, String lastName,
        int rateMyProfessorRating, double averageGPA) {
        super(firstName, lastName);
        this.rateMyProfessorRating = rateMyProfessorRating;
        this.averageGPA = averageGPA;
    }

    public String toString() {
        return super.toString() + " My Rate My Professor rating is "
            + rateMyProfessorRating + "/5 and my average GPA is " + averageGPA
            + "/4.00. I really wish students would stop emailling me so much.";
    }

}