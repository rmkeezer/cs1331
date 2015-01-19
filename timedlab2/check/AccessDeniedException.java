/**
 * AccessDeniedException
 *
 * you may ADD to this class header, but do not change the
 * visibility or class name
 */
public class AccessDeniedException extends Exception {
    private SecurityClearance requiredClearance;

    public AccessDeniedException(SecurityClearance sc) {
        requiredClearance = sc;
        System.out.println("This mission requires a clearance of "
            + requiredClearance.toString());
    }

    //HINT: requiredClearance.toString() gives the enumerated type's name.

    /**
     * this is here so we can test your code; no need to change it
     * @return clearance that was needed to access the mission that threw
     *         the exception.
     */
    public SecurityClearance getRequiredClearance() {
        return requiredClearance;
    }
}
