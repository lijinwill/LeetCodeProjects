/**
 * @author Will
 * @version 1.0
 * @description: 相当于26进制转为10进制
 * @date 2020/12/8 21:07
 */
public class T171 {
    public static void main(String[] args) {
        System.out.println(T171.titleToNumber("A"));
    }
    public static int titleToNumber(String s) {
        byte[] bytes = s.getBytes();
        int len = bytes.length;

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = (int) (sum + (bytes[i]-64) * (Math.pow(26,len-i-1)));
        }

        return sum;
    }
}
