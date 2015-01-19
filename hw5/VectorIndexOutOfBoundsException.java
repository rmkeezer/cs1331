/**
 * Exception class for vector
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class VectorIndexOutOfBoundsException extends IndexOutOfBoundsException {

    /**
     * Instantiates a new vector index out of bounds exception.
     */
    public VectorIndexOutOfBoundsException() {

    }

    /**
     * Instantiates a new vector index out of bounds exception.
     *
     * @param message the message
     */
    public VectorIndexOutOfBoundsException(String message) {
        System.out.println(message);
    }

}