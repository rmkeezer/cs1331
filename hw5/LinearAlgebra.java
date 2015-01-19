
/**
 * Linear Algebra static classes
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class LinearAlgebra {

    /**
     * Matrix vector multiply.
     *
     * @param m
     * @param v
     * @return vector prduct of m and v
     * @throws IllegalOperandException the illegal operand exception
     */
    public static Vector matrixVectorMultiply(Matrix m, Vector v)
        throws IllegalOperandException {
        Vector output;
        try {
            int l;
            if (m.getWidth() > v.getLength()) {
                l = m.getWidth();
            } else {
                l = v.getLength();
            }
            double[] temp = new double[l];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    temp[i] += m.get(i, j) * v.get(j);
                }
            }
            output = new Vector(temp);
        } catch (VectorIndexOutOfBoundsException e) {
            throw new IllegalOperandException("Cannot multiply a "
                + "matrix of width " + m.getWidth() + " with a vector"
                + " of length " + v.getLength() + ".");
        } catch (MatrixIndexOutOfBoundsException e) {
            throw new IllegalOperandException("Cannot multiply a "
                + "matrix of width " + m.getWidth() + " with a vector"
                + " of length " + v.getLength() + ".");
        }
        return output;
    }

    /**
     * Matrix add.
     *
     * @param m1
     * @param m2
     * @return matrix sum of m1 and m2
     * @throws IllegalOperandException the illegal operand exception
     */
    public static Matrix matrixAdd(Matrix m1, Matrix m2)
        throws IllegalOperandException {
        Matrix output;
        try {
            int h, l;
            if (m1.getHeight() > m2.getHeight()
                || m1.getWidth() > m2.getWidth()) {
                h = m1.getHeight();
                l = m1.getWidth();
            } else {
                h = m2.getHeight();
                l = m2.getWidth();
            }
            double[][] temp = new double[h][l];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < l; j++) {
                    temp[i][j] = m1.get(i, j) + m2.get(i, j);
                }
            }
            output = new Matrix(temp);
        } catch (MatrixIndexOutOfBoundsException e) {
            throw new IllegalOperandException("Cannot add a matrix "
                + "of height " + m1.getHeight() + " and width "
                + m1.getWidth() + " with a matrix of height "
                + m2.getHeight() + " and width " + m2.getWidth()
                + ".");
        }
        return output;
    }

    /**
     * Dot product.
     *
     * @param v1
     * @param v2
     * @return vector product of v1 and v2
     * @throws IllegalOperandException the illegal operand exception
     */
    public static double dotProduct(Vector v1, Vector v2)
        throws IllegalOperandException {
        double output;
        try {
            int l;
            if (v1.getLength() > v2.getLength()) {
                l = v1.getLength();
            } else {
                l = v2.getLength();
            }
            double temp = 0;
            for (int i = 0; i < l; i++) {
                temp += v1.get(i) * v2.get(i);
            }
            output = temp;
        } catch (VectorIndexOutOfBoundsException e) {
            throw new IllegalOperandException("Cannot dot product a "
                + "vector of length " + v1.getLength() + " with a "
                + "vector of length " + v2.getLength() + ".");
        }
        return output;
    }

    /**
     * Vector add.
     *
     * @param v1
     * @param v2
     * @return vector sum of v1 and v2
     * @throws IllegalOperandException the illegal operand exception
     */
    public static Vector vectorAdd(Vector v1, Vector v2)
        throws IllegalOperandException {
        Vector output;
        try {
            int l;
            if (v1.getLength() > v2.getLength()) {
                l = v1.getLength();
            } else {
                l = v2.getLength();
            }
            double[] temp = new double[l];
            for (int i = 0; i < l; i++) {
                temp[i] += v1.get(i) + v2.get(i);
            }
            output = new Vector(temp);
        } catch (VectorIndexOutOfBoundsException e) {
            throw new IllegalOperandException("Cannot add a "
                + "vector of length " + v1.getLength() + " with a "
                + "vector of length " + v2.getLength() + ".");
        }
        return output;
    }

}