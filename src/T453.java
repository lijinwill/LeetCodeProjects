import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/30 20:29
 */
public class T453 {
    public static void main(String[] args) {
        int[] test = new int[]{1,2147483647};
        System.out.println(T453.minMoves(test));
    }
    public static int minMoves(int[] nums) {
        int len = nums.length;
        int min = nums[0];
        for (int i = 0; i < len; i++) {
            min = Math.min(min,nums[i]);
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            result = result + nums[i] - min;
        }

        return result;
















        //太耗时
/*        int len = nums.length;
        BigInteger total = new BigInteger("0");

        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            String numi = String.valueOf(nums[i]);
            BigInteger Numi = new BigInteger(numi);

            total = total.add(Numi);
            min = Math.min(min,nums[i]);
        }
        BigInteger Min = new BigInteger(String.valueOf(min));
        BigInteger Len = new BigInteger(String.valueOf(len));
        BigInteger min_multi = Min.multiply(Len);
        BigInteger result = total.subtract(min_multi);
        return result.intValue();*/
    }
}
