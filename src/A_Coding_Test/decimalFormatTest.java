package A_Coding_Test;

import java.text.DecimalFormat;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/20 15:38
 */
public class decimalFormatTest {
    public static void main(String[] args) {
        int a = 100, b = 3;
        DecimalFormat df = new DecimalFormat("0.000");//设置保留位数
        System.out.println(df.format((float)a/b));
    }

}
