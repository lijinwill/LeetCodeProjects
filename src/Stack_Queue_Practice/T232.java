package Stack_Queue_Practice;

import java.util.Stack;

/**
 * @Classname T232
 * @Description TODO
 * @Date 2022/7/10 11:51
 * @Created by Will
 */
public class T232 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public T232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        //如果stack2空而stack1不空，则将Stack1的搬到stack2中
        if(stack2.empty() && !stack1.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if(stack2.empty() && !stack1.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        if (stack1.empty() && stack2.empty()){
            return true;
        }
        return false;
    }
}
