package A_Coding_Test.Microsoft_8_26;

import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/26 20:03
 */
public class T3 {
    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {1,2};
        T3 test = new T3();
        System.out.println(test.solution(A,B));
    }
    public int solution(int[] A, int[] B) {
        // write your code in Java 11 (Java SE 11)
        int len = A.length;
        int[] min = new int[len];
        int[] max = new int[len];
        for (int i = 0; i < len; i++) {
            if (A[i] < B[i]){
                min[i] = A[i];
                max[i] = B[i];
            }else{
                min[i] = B[i];
                max[i] = A[i];
            }
        }
        Arrays.sort(min);
        Arrays.sort(max);

        int numMin = Integer.MAX_VALUE;
        int numMax = Integer.MAX_VALUE;
        if (min[0] == 1){
            int i;
            for (i = 0; i < len-1; i++) {
                if (min[i+1] - min[i] == 2){
                    numMin = min[i] + 1;
                }
            }
            if (i == len-1) numMin = min[len-1] + 1;
        }else{
            numMin = min[0];
        }

        if (max[0] == 1){
            int j;
            for (j = 0; j < len-1; j++) {
                if (max[j+1] - max[j] == 2){
                    numMax = max[j] + 1;
                }
            }
            if (j == len-1) numMin = min[len-1] + 1;

        }else{
            numMax = max[0];
        }

        return Math.min(numMin, numMax);

    }
}
