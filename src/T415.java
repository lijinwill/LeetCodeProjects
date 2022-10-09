/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/30 14:23
 */
public class T415 {
    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "9";
        System.out.println(T415.addStrings(num1, num2));
    }
    public static String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int len_max = Math.max(len1,len2);

        StringBuffer num1_sb = new StringBuffer(num1);
        StringBuffer num2_sb = new StringBuffer(num2);
        StringBuffer num1_rev = num1_sb.reverse();
        StringBuffer num2_rev = num2_sb.reverse();
        while (num1_rev.length() < len_max) {
            num1_rev.append("0");
        }
        while (num2_rev.length() < len_max) {
            num2_rev.append("0");
        }

        StringBuffer result = new StringBuffer();

        int add = 0;
        int i;
        for (i = 0; i<len_max; i++) {
            //提取出两个数
            int n1 = (int)num1_rev.charAt(i) - (int)('0');
            int n2 = (int)num2_rev.charAt(i) - (int)('0');
            //求和
            int sum = n1 + n2 + add;

            if (sum<10){
                result.append(sum);
                add = 0;
            }else{
                result.append(sum%10);
                add = 1;
            }
        }

        StringBuffer result1 = result;
        if (add == 1){
            result1 = result.append(1);
        }

        return result1.reverse().toString();


    }
}
