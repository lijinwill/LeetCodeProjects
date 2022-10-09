package A_Coding_Test.JD_8_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(input.readLine());
//
//        String s = input.readLine();
//        String[] sArr = s.split(" ");
//        int[] nums = new int[n];
//
//        //生成数组，并统计数组中的最大值
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            nums[i] = Integer.parseInt(sArr[i]);
//            max = Math.max(max, nums[i]);
//        }
//        Main.help(nums,n,max);
//    }

    public static void help(int[] nums, int n, int max){
        int[] dp = new int[max+1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;

        if (max > 3){
            //遍历1到max中所有的数
            for (int i = 4; i <= max; i++) {
                dp[i] = dp[i-1] + 1;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    int temp = i/j;
                    if (j * temp == i){
                        dp[i] = Math.min(dp[i], dp[j]+dp[temp]+1);
                    }
                }
            }
        }

        int count = 0;
        //遍历nums统计结果
        for (int i = 0; i < n; i++) {
            count = count + dp[nums[i]];
        }
        System.out.println(count);

    }


    //测试代码
    public static void main(String[] args) {
        int[] nums = {2,6,7};
        int n = 3;
        int max = 7;

        help(nums, n, max);
    }
}
