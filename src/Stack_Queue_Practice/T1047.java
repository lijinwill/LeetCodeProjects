package Stack_Queue_Practice;

import java.util.Stack;

/**
 * @Classname T1047
 * @Description TODO
 * @Date 2022/7/10 15:28
 * @Created by Will
 */
public class T1047 {
    //这题和括号匹配那题基本一样，用一个栈就可以解决
    public String removeDuplicates(String s) {
        //先去重，得到不重复的字符串保存在stack里面
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if (stack.empty()){
                stack.push(temp);
            } else {
                if (stack.peek().equals(temp)){
                    stack.pop();
                }else{
                    stack.push(temp);
                }
            }
        }
        //然后将stack中的内容转换成String输出
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
