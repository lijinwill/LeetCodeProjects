package A_Coding_Test.TianYiYun_9_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/14 20:42
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int bagWeight = Integer.parseInt(scan.readLine());

        String S2 = scan.readLine();
        String S3 = scan.readLine();
        String[] S2Arr = S2.split(" ");
        String[] S3Arr = S3.split(" ");

        int len = Integer.parseInt(S2Arr[0]);

        int[] value = new int[len];
        int[] weight = new int[len];

        for (int i = 1; i <= len; i++) {
            value[i-1] = Integer.parseInt(S2Arr[i]);
            weight[i-1] = Integer.parseInt(S3Arr[i]);
        }
        Main3.bagProblem(weight, value, bagWeight);
    }
    public static void bagProblem(int[] weight, int[] value, int bagWeight){
        int weightLen = weight.length;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weightLen; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
            }
        }

        System.out.println(dp[bagWeight]);

    }
}
