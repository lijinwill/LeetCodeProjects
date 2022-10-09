package A_Coding_Test.Oppo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/2 21:11
 */
public class Main1 {

    public int maxDigit (int[] digits) {
        // write code here
        StringBuffer sb = new StringBuffer();

        Arrays.sort(digits);
        for (int i = digits.length-1; i >=0; i--) {
            sb.append(digits[i]);
        }

        return Integer.parseInt(sb.toString());
    }
}
