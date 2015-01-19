public class GraduateStudent extends Student {

    public GraduateStudent(String firstName, String lastName, int intelligence,
        int motivation) {
        super(firstName, lastName, intelligence, motivation);
        setMessage("I'm stressed out AND broke.");
    }

    public String toString() {
        return super.toString();
    }

}