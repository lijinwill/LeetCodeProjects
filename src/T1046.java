import java.util.Arrays;
import java.util.Collections;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/23 13:31
 */
public class T1046 {
    public static void main(String[] args) {
        int[] stones = new int[]{7,2,3};
        System.out.println(T1046.lastStoneWeight(stones));

    }
    public static int lastStoneWeight(int[] stones) {
        int len = stones.length;

        while (len > 1) {
            Arrays.sort(stones);
            int dif = stones[len - 2] - stones[len - 1];
            if (dif > 0) {
                stones[len - 2] = dif;
                len--;
            } else if (dif < 0) {
                stones[len - 2] = -dif;
                len--;
            } else {
                len = len - 2;
            }

        }

        if (len == 0){
            return 0;
        }else{
            return stones[0];

        }
    }
}
