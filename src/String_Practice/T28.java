package String_Practice;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/11/12 23:15
 */
public class T28 {
    public static void main(String[] args) {
        String haystack = "";
        String needle = "";
        T28 test = new T28();
        System.out.println( test.strStr(haystack,needle) );
    }

    public static int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            String substring = haystack.substring(i, i+needle.length());
            if(substring.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
