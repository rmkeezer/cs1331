/**
 * Secret Mission
 *
 * you may ADD to this class header, but do not change the
 * visibility or class name
 */
public class SecretMission extends Mission {

    public static final String CLASSIFIED_STRING = "This information "
        + "is Classified.";

    protected SecurityClearance clearance;
    protected boolean locked = true;

    public SecretMission() {
        this(SecurityClearance.NONE);
    }

    public SecretMission(SecurityClearance sc) {
        this(sc, "No title", "No description");
    }

    public SecretMission(String t, String d) {
        this(SecurityClearance.NONE, t, d);
    }

    public SecretMission(SecurityClearance sc, String t, String d) {
        super(t, d);
        clearance = sc;
    }

    /**
     * unlocks the mission's info, given some security clearance
     * should check the given clearance against the mission's clearance and
     * throw an AccessDeniedException if it is insufficient clearance.
     *
     * You may (must) ADD to this method header, but do not change the
     * visibility, return type, or method name.
     */
    public void unlockInfo(SecurityClearance sc)
        throws AccessDeniedException {
        if (sc.ordinal() < clearance.ordinal()) {
            throw new AccessDeniedException(clearance);
        }
        locked = false;
    }

    public void setDescription(String d) {
        if (!locked) {
            description = d;
        }
    }

    public String toString() {
        if (locked) {
            return CLASSIFIED_STRING;
        }
        return super.toString();
    }

    /*
        HINT
        the .ordinal() method on an enum value gives you its position relative
        to the other values.
        For example, you can compare like so:
        someClearance.ordinal() < anotherClearance.ordinal()
        someClearance.ordinal() >= anotherClearance.ordinal()
        someClearance.ordinal() == anotherClearance.ordinal()

        e.g, SecurityClearance.CONFIDENTIAL.ordinal() > SecurityClearance.
            SECRET.ordinal() would return true
    */
}