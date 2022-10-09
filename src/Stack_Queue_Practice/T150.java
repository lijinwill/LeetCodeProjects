package Stack_Queue_Practice;

import java.util.Stack;

/**
 * @Classname T150
 * @Description TODO
 * @Date 2022/7/10 16:17
 * @Created by Will
 */
public class T150 {
    //思路：利用栈保存数字，每次遇到运算符就弹出两个数字进行运算
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<tokens.length; i++){
            if (tokens[i].equals("+")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1+num2);
            }else if(tokens[i].equals("-")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1-num2);
            }else if(tokens[i].equals("*")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1*num2);
            }else if(tokens[i].equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1/num2);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
