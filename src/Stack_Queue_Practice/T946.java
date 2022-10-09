package Stack_Queue_Practice;

import java.util.Stack;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/14/2022 10:16 PM
 */
public class T946 {
    public static void main(String[] args) {
        int[] pushed = {0,2,1};
        int[] popped = {0,1,2};
        T946 test = new T946();
        System.out.println(test.validateStackSequences(pushed, popped));
    }
    //思路：直接模拟就完事儿了，一开始先根据popped入栈pushed中的元素
    //      popped中的数据只能要么来自栈顶，要么来自pushed中的剩余元素；
    //      如果两边都不满足，则表明无法得到此popped
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);
        int cur1 = 1;
        int cur2 = 0;

        while(cur1 <= len && cur2<len){
            //当栈为空，就将pushed入栈
            if (stack.empty()){
                stack.push(pushed[cur1++]);
                continue;
            }
            //当栈顶与popped当前元素相同，出栈，cur2++；若不同，入栈或者return false
            if (stack.peek() == popped[cur2]){
                stack.pop();
                cur2++;
            }else{
                if (cur1 != len){
                    stack.push(pushed[cur1++]);
                }else{
                    return false;
                }
            }

        }
        return stack.empty() ? true:false;
    }
}
