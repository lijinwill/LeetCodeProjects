import java.math.BigInteger;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/30 23:34
 */
public class T43 {
    public static void main(String[] args) {
        String num1 = "1432535325354325";
        String num2 = "934535435345354";
        System.out.println(T43.multiply(num1, num2));
    }
    public static String multiply(String num1, String num2) {
        BigInteger num1_bg = new BigInteger(num1);
        BigInteger num2_bg = new BigInteger(num2);

        BigInteger multiply = num1_bg.multiply(num2_bg);
        return multiply.toString();
    }
}
