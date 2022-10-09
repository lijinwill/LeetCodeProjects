/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/14 22:07
 */
public class T392 {
    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";
        System.out.println( T392.isSubsequence(s, t) );

    }
    public static boolean isSubsequence(String s, String t) {
        int ps = 0;

        for (int i=0; i<t.length() && ps<s.length(); i++){
            if (s.charAt(ps) == t.charAt(i)){
                ps++;
            }
        }
        return ps==s.length() ? true:false;
    }
}
