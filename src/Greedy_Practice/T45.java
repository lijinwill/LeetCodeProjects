package Greedy_Practice;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/15 19:06
 */
public class T45 {
    public static void main(String[] args) {
        int[] test = new int[]{2,3,1,1,4};
        System.out.println(T45.jump(test));

    }
    //自己写的方法效率太低
/*    public static int jump(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return 0;
        }

        //新建一个count数组记录到达当前位置所需的最小步数
        int[] step = new int[nums.length];
        //从i=0处出发
        step[0] = 0;
        //用来表示当前位置所能到达的最远位置
        int p1 = 0;
        int maxStep = 0;
        for (int i = 0; step[len-1] == 0; i++) {
            p1 = nums[i] + i;
            for (int j = i+1; j<=p1 && j<len; j++) {
                if (step[j] == 0){
                    step[j] = step[i] + 1;
                }
            }

        }
        return step[len-1];
    }*/

    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
