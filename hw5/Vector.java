/**
 * Immutable abstraction for Vector
 *
 * @author Michael Maurer, Matthew Keezer
 * @version 1.3
 */
public final class Vector {

    /*
    Create final instance variables
    */
    private final double[] vector;
    private final int length;

    /**
     * Initialize instance variables
     * @param vector array representation of vector
     */
    public Vector(double[] vector) {
        this.vector = vector;
        length = vector.length;
    }

    /**
     * Gets value located at specified index
     * @param i index in vector
     * @return double located at index 'i' in vector
     */
    public double get(int i) {
        double value = 0;
        try {
            value = vector[i];
        } catch (IndexOutOfBoundsException e) {
            throw new VectorIndexOutOfBoundsException(/*"The index with "
                + "values i=" + i + " were not found in vector of "
                + "length=" + length + "."*/);
        }
        return value;
    }

    /**
     * Get's the length of the Vector.
     * @return number of components in vector
     */
    public int getLength() {
        return length;
    }

    /**
     * String representation of vector with components
     * separated by tabs
     * @return String representation of vector
     */
    public String toString() {
        String output = "";
        for (int i = 0; i < length; i++) {
            output += vector[i] + "\t";
        }
        return output;
    }
}