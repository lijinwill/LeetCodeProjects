package A_Coding_Test.YouKa;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/6 19:54
 */
public class test1 {
    public static void main(String[] args) {
        String str1 = "a1b2c3";
        String str2 = "d1e2f3g4h5";

        System.out.println(alternativeMerge2(str1,str2));
    }
    public static String alternativeMerge2 (String str1, String str2) {
        // write code here
        StringBuffer sb = new StringBuffer();
        if (str1.length() < str2.length()){

            for (int i = 0; i < str1.length(); i++) {
                sb.append(str1.charAt(i));
                sb.append(str2.charAt(i));
            }

        }else{
            int shortLen = str2.length();
            int longLen = str1.length();

            for (int i = 0; i < longLen; i++) {
                if (i >= shortLen){
                    sb.append(str1.charAt(i));
                    sb.append(str2.charAt(i%shortLen));
                    continue;
                }
                sb.append(str1.charAt(i));
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }
}
