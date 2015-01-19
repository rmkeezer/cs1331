public class Student extends Person {

    private int intelligence;
    private int motivation;
    private String message;

    public Student(String firstName, String lastName, int intelligence,
        int motivation) {
        super(firstName, lastName);
        this.intelligence = intelligence;
        this.motivation = motivation;
        message = "I'm stressed out.";
    }

    public String toString() {
        return super.toString() + " My intelligence is "
            + intelligence + "/10 and my motivation is " + motivation
            + "/10. " + getMessage();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}