import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/11/14 13:56
 */
public class T66 {
    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9};
        T66 test = new T66();
        int[] result = test.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }

    public int[] plusOne(int[] digits){
        int lastp = digits.length - 1;

        for(int i=lastp; i>=0; i--){
            digits[i]++;
            if (digits[i] != 10){
                return digits;
            }
            digits[i] = 0;
        }

        //下面可以直接new int[长度 + 1]是因为999+1=000此时digits已经全是0了
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
