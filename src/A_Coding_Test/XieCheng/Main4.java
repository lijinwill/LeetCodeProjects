package A_Coding_Test.XieCheng;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/30 18:57
 */
public class Main4 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(input.readLine());
//
//        String S = input.readLine();
//        String[] arrS = S.split(" ");
//        int[] nums = new int[arrS.length];
//        for (int i = 0; i < arrS.length; i++) {
//            nums[i] = Integer.parseInt(arrS[i]);
//        }
//        Main test = new Main();
//        test.Help(n,nums);
//    }
    public static void main(String[] args) {
        int[] nums = {-5,1,2};
        int n = 3;
        Main4 test = new Main4();
        test.Help(n,nums);

    }
    //先定位到差值最大的位置，如果；
    public void Help(int n, int[] nums){
        int[] delta = new int[n-1];
        int maxDelta = 0;
        int maxDeltaPos = 0;
        for (int i = 0; i < n-1; i++) {
            delta[i] = Math.abs(nums[i+1] - nums[i]);
            if (delta[i] > maxDelta){
                maxDelta = delta[i];
                maxDeltaPos = i;
            }
        }

        //如果最大在两侧
        if (maxDeltaPos == 0){
            nums[0] = nums[1];
            delta = new int[n-1];
            maxDelta = 0;
            for (int i = 0; i < n-1; i++) {
                delta[i] = Math.abs(nums[i+1] - nums[i]);
                if (delta[i] > maxDelta){
                    maxDelta = delta[i];
                }
            }
            System.out.println(maxDelta);
            return;
        }
        //如果最大在两侧
        if (maxDeltaPos == n-2){
            nums[n-1] = nums[n-2];
            delta = new int[n-1];
            maxDelta = 0;
            for (int i = 0; i < n-1; i++) {
                delta[i] = Math.abs(nums[i+1] - nums[i]);
                if (delta[i] > maxDelta){
                    maxDelta = delta[i];
                }
            }
            System.out.println(maxDelta);
            return;
        }

        int left =Math.abs(nums[maxDeltaPos+1] - nums[maxDeltaPos-1])/2;
        int right = Math.abs(nums[maxDeltaPos+2] - nums[maxDeltaPos])/2;
        if (left/2 == 1) left = left + 1;
        if (right/2 == 1) right = right + 1;
        int deltaNew = Math.min(left, right);
        System.out.println(deltaNew);
        return;
    }
}


