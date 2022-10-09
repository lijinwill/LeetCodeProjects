import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-04-18$ $
 */
public class T32 {
    public static void main(String[] args) {
        String s = "()(()";
        T32 test = new T32();
        System.out.println(test.longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}

