package A_Coding_Test.Microsoft_8_26;

import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/26 19:41
 */
public class T2 {
    public static void main(String[] args) {
        int[] A = new int[]{7,1,11,8,4,10};
        int M = 8;
        T2 test = new T2();
        System.out.println(test.solution(A, M));
    }
    //思路：先用一个数组重写不同的点，然后遍历数组，从B[0]+M，B[0]+M+M。。。只要小于len-1
    public int solution(int[] A, int M) {
        // write your code in Java 11 (Java SE 11)
        int len = A.length;
        Arrays.sort(A);

        int maxCount = 1;
        for (int i = 0; i < len; i++) {
            int count = 1;
            for (int j=i+1; j<len; j++){
                if (A[j]-A[i] == M){
                    count++;
                }
            }
            if (count > 1){
                maxCount = Math.max(count+1,maxCount);
            }
        }
        return maxCount;
    }
}
