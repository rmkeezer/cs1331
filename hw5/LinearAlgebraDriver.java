import java.util.InputMismatchException;

/**
 * Driver for Linear Algebra.
 *
 * @author Michael Maurer, Matthew Keezer
 * @version 1.3
 */
public class LinearAlgebraDriver {

    /**
     * Runs program asking user for input and running linear algebra methods.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        LinearAlgebraScanner input = new LinearAlgebraScanner();
        boolean done = false;
        while (!done) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("0. matrix + matrix");
            System.out.println("1. matrix * vector");
            System.out.println("2. vector . vector");
            System.out.println("3. vector + vector");
            System.out.println("4. Exit\n");
            String line = input.nextLine();
            int userInput = Integer.parseInt(line);
            System.out.println();
            boolean correctMatrix = false;
            if (userInput == 0) {
                System.out.println("Please enter a matrix!");
                System.out.println("Enter empty line to terminate!");
                Matrix m1 = null;
                while (!correctMatrix) {
                    try {
                        m1 = input.readMatrix();
                        correctMatrix = true;
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please enter a valid matrix.");
                    }
                }
                System.out.println("Please enter a matrix!");
                System.out.println("Enter empty line to terminate!");
                Matrix m2 = null;
                correctMatrix = false;
                while (!correctMatrix) {
                    try {
                        m2 = input.readMatrix();
                        correctMatrix = true;
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please enter a valid matrix.");
                    }
                }
                System.out.println();
                try {
                    System.out.println(LinearAlgebra.matrixAdd(m1, m2));
                } catch (IllegalOperandException e) {
                    System.out.println("Failure.");
                }
            } else if (userInput == 1) {
                System.out.println("Please enter a matrix!");
                System.out.println("Enter empty line to terminate!");
                Matrix m1 = null;
                while (!correctMatrix) {
                    try {
                        m1 = input.readMatrix();
                        correctMatrix = true;
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please enter a validmatrix.");
                    }
                }
                System.out.println("Please enter a vector!");
                Vector v1 = null;
                correctMatrix = false;
                while (!correctMatrix) {
                    try {
                        v1 = input.readVector();
                        correctMatrix = true;
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please enter a valid vector.");
                    }
                }
                try {
                    System.out.println(
                        LinearAlgebra.matrixVectorMultiply(m1, v1));
                } catch (IllegalOperandException e) {
                    System.out.println("Failure.");
                }
            } else if (userInput == 2) {
                System.out.println("Please enter a vector!");
                System.out.println("Separate vector components by "
                    + "using a space.");
                Vector v1 = null;
                while (!correctMatrix) {
                    try {
                        v1 = input.readVector();
                        correctMatrix = true;
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please enter a valid vector.");
                    }
                }
                System.out.println("Please enter a vector!");
                System.out.println("Separate vector components by "
                    + "using a space.");
                Vector v2 = null;
                correctMatrix = false;
                while (!correctMatrix) {
                    try {
                        v2 = input.readVector();
                        correctMatrix = true;
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please enter a valid vector.");
                    }
                }
                try {
                    System.out.println(LinearAlgebra.dotProduct(v1, v2));
                } catch (IllegalOperandException e) {
                    System.out.println("Failure.");
                }
            } else if (userInput == 3) {
                System.out.println("Please enter a vector!");
                System.out.println("Separate vector components by "
                    + "using a space.");
                Vector v1 = null;
                while (!correctMatrix) {
                    try {
                        v1 = input.readVector();
                        correctMatrix = true;
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please enter a valid vector.");
                    }
                }
                System.out.println("Please enter a vector!");
                System.out.println("Separate vector components by "
                    + "using a space.");
                Vector v2 = null;
                correctMatrix = false;
                while (!correctMatrix) {
                    try {
                        v2 = input.readVector();
                        correctMatrix = true;
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please enter a valid vector.");
                    }
                }
                try {
                    System.out.println(LinearAlgebra.vectorAdd(v1, v2));
                } catch (IllegalOperandException e) {
                    System.out.println("Failure.");
                }
            } else if (userInput == 4) {
                done = true;
            }
        }
    }
}