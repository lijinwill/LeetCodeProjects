package Stack_Queue_Practice;

import java.util.Stack;

/**
 * @Classname T20
 * @Description TODO
 * @Date 2022/7/10 15:06
 * @Created by Will
 */
public class T20 {
    public static void main(String[] args) {
        String s = "]";
        T20 test = new T20();
        System.out.println(test.isValid(s));
    }
    /*思路：
    1、遇到左边的括号就入栈，遇到右边的就匹配，如果与出栈的不匹配，则直接return false
    2、全部匹配完栈必须为空，

     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if (c == ')'){
                if (stack.empty() || !stack.pop().equals('(')) return false;
            }else if (c == ']'){
                if (stack.empty() || !stack.pop().equals('[')) return false;
            }else if (c == '}'){
                if (stack.empty() || !stack.pop().equals('{')) return false;
            }
        }
        return stack.empty();
    }
}
