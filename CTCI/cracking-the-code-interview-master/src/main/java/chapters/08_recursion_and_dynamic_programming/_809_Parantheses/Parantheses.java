package _809_Parantheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Parentheses: Implement an algorithm to print all valid (i.e., properly opened and closed) combinations
 * of n pairs of parentheses.
 * EXAMPLE
 * Input: 3
 * Output: ((())) , (()()) , (())() , ()(()) , ()()( )
 */
public class Parantheses {

    public static List<String> generateParentheses(int n) {
        List<String> solutions = new ArrayList();
        addParenthesis(new char[n * 2], 0, n, n, solutions);
        return solutions;
    }

    private static void addParenthesis(char[] solution, int index, int leftReminder, int rightReminder, List<String> solutions) {
        if (leftReminder == 0 && rightReminder == 0) {
            solutions.add(new String(solution));
            return;
        }
        if (leftReminder > 0) {
            solution[index] = '(';
            addParenthesis(solution, index + 1, leftReminder - 1, rightReminder, solutions);
        }
        if (rightReminder > 0 && rightReminder > leftReminder) {
            solution[index] = ')';
            addParenthesis(solution, index + 1, leftReminder, rightReminder - 1, solutions);
        }
    }
}
