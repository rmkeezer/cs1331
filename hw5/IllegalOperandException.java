/**
 * Exception class for matrix and vector operations
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class IllegalOperandException extends Exception {

    /**
     * Instantiates a new illegal operand exception.
     */
    public IllegalOperandException() {

    }

    /**
     * Instantiates a new illegal operand exception.
     *
     * @param message the message
     */
    public IllegalOperandException(String message) {
        System.out.println(message);
    }

}