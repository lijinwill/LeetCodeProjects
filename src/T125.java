/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/8 16:24
 */
public class T125 {
    public static void main(String[] args) {
        String test = "bb";
        boolean result = T125.isPalindrome(test);
        System.out.println(result);
    }
    public static boolean isPalindrome(String s) {
        int len = s.length();

        StringBuilder s1 = new StringBuilder();
        for (int i=0; i<len; i++){
            //取出单个字符
            char ch = s.charAt(i);
            //判断是不是字母或数字
            if ( Character.isLetterOrDigit(ch) ){
                s1.append( Character.toLowerCase(ch) ) ;
            }
        }

        StringBuilder s1_rev = new StringBuilder(s1);
        s1_rev.reverse();
        if (s1_rev.toString().equals(s1.toString())){
            return true;
        }else{
            return false;
        }
    }
}
