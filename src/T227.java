import java.util.Stack;

public class T227 {
    public static void main(String[] args) {
        String s = "3+2  *2";
        T227 test = new T227();
        System.out.println(test.calculate(s));

    }

    public int calculate(String s) {
        //单个字符直接返回
        int len = s.length();
        if (len == 1) {
            return Integer.parseInt(s);
        }
        /*************第二次，考虑用栈******************/
        Stack<Integer> num_stack = new Stack<>();

        int num = 0;
        char pre_num = '+';
        for (int i = 0; i < len; ++i) {
            //先找出数字
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            //然后考虑数字后的运算符
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
                switch (pre_num) {
                    case '+':
                        num_stack.push(num);
                        break;
                    case '-':
                        num_stack.push(-num);
                        break;
                    case '*':
                        num_stack.push(num_stack.pop() * num);
                        break;
                    default:
                        num_stack.push(num_stack.pop() / num);

                }
                pre_num = s.charAt(i);
                num = 0;
            }
        }
        int result = 0;
        while (!num_stack.empty()) {
            result = result + num_stack.pop();
        }
        return result;
    }

    /*************第一次尝试，没有考虑数组可以是2位数及以上，所以失败
     public int calculate(String s) {
     StringBuilder result = new StringBuilder();
     //第一步先把空格去掉
     for(int i=0; i<len; i++){
     if(s.charAt(i) != ' '){
     result.append(s.charAt(i));
     }else{
     continue;
     }
     }

     //第二步计算乘除
     int i=1;
     while(i<result.length()){
     if(result.charAt(i)=='*'){
     int temp = (int)result.charAt(i-1) * (int)result.charAt(i+1);
     result.delete(i-1,i+2);
     result.insert(i-1,temp+'0');
     continue;
     }
     if(result.charAt(i)=='/'){
     int temp = (int)result.charAt(i-1) / (int)result.charAt(i+1);
     result.delete(i-1,i+2);
     result.insert(i-1,(char)temp);
     continue;
     }
     i++;
     }

     //第三步计算加减
     i=1;
     while(i<result.length()){
     if(result.charAt(i)=='+'){
     int temp = (int)result.charAt(i-1) + (int)result.charAt(i+1);
     result.delete(i-1,i+2);
     result.insert(i-1,(char)temp);
     continue;
     }
     if(result.charAt(i)=='-'){
     int temp = (int)result.charAt(i-1) - (int)result.charAt(i+1);
     result.delete(i-1,i+2);
     result.insert(i-1,(char)temp);
     continue;
     }
     i++;
     }
     return  Integer.parseInt(result.toString());
     }
     */
}
