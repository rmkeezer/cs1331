/**
 * Immutable abstraction of Matrix.
 *
 * @author Michael Maurer, Matthew Keezer
 * @version 1.3
 */
public final class Matrix {

    /*
    Create final instance variables
    */
    private final double[][] matrix;
    private final int height, width;

    /**
     * Initialize instance variables
     * @param matrix 2D array representation of Matrix
     */
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        height = matrix.length;
        width = matrix[0].length;
    }

    /**
     * Gets value located at specified row and column
     * @param i row
     * @param j column
     * @return double located at row i and column j in matrix
     */
    public double get(int i, int j) {
        double value = 0;
        try {
            value = matrix[i][j];
        } catch (IndexOutOfBoundsException e) {
            throw new MatrixIndexOutOfBoundsException(/*"The index with "
                + "values i=" + i + " and j=" + j + " were not found "
                + "in matrix of height=" + height + " and width="
                + width + "."*/);
        }
        return value;
    }

    /**
     * Get's the height of the matrix.
     * @return number of rows in matrix
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get's the width of the matrix.
     * @return number of columns in matrix
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets String representation of matrix.
     * Columns separated by tabs, rows by new lines.
     * @return String representation of matrix.
     */
    public String toString() {
        String output = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                output += matrix[i][j] + "\t";
            }
            output += "\n";
        }
        return output;
    }
}