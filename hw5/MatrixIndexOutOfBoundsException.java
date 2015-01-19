/**
 * Exception class for matrix
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class MatrixIndexOutOfBoundsException extends IndexOutOfBoundsException {

    /**
     * Instantiates a new matrix index out of bounds exception.
     */
    public MatrixIndexOutOfBoundsException() {

    }

    /**
     * Instantiates a new matrix index out of bounds exception.
     *
     * @param message the message
     */
    public MatrixIndexOutOfBoundsException(String message) {
        System.out.println(message);
    }

}