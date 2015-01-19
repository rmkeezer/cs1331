public class UndergraduateStudent extends Student {

    public UndergraduateStudent(String firstName, String lastName, int
        intelligence, double motivation) {
        super(firstName, lastName, intelligence, (int) motivation);
        setMessage("I'm going home this weekend to get laundry done;"
            + " talk about clutch.");
    }

    public String toString() {
        return super.toString();
    }

}