/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2021/1/6 13:26
 */
public class T8 {
    public static void main(String[] args) {
        System.out.println(T8.myAtoi("123"));
    }
    public static int myAtoi(String s) {
        int len = s.length();
        //空字符串返回0
        if (s.length() == 0){
            return 0;
        }
        //第一个非空格字符不是有效整数字符，无法转换直接返回0
        int i = 0;
        while(s.charAt(i) == ' '){
            i++;
        }
        if (i == len-1 || s.charAt(i)<48||s.charAt(i)>57){
            return 0;
        }

        




        return 1;
    }
}
