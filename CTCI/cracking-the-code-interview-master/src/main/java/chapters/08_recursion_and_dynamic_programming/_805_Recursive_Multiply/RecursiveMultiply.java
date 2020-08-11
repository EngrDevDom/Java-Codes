package _805_Recursive_Multiply;

/**
 * Recursive Multiply: Write a recursive function to multiply two positive integers without using
 * the * operator (or / operator}. You can use addition, subtraction, and bit shifting, but you should
 * minimize the number of those operations.
 */
public class RecursiveMultiply {

    public static int multiply(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        } else if (x < y) {
            return multiplyFunction(x, y);
        } else {
            return multiplyFunction(y, x);
        }
    }

    private static int multiplyFunction(int smaller, int bigger) {
        if (smaller == 1) {
            return bigger;
        }

        int prod = multiplyFunction(smaller / 2, bigger);

        if (smaller % 2 == 0) {
            return prod + prod;
        } else {
            return prod + prod + bigger;
        }
    }

}
