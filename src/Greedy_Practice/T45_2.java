package Greedy_Practice;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-15
 */
public class T45_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        T45_2 test = new T45_2();
        System.out.println(test.jump(nums));

    }

    /*思路：用覆盖范围来做而不是用数组统计
           count记录跳跃次数
           curDist表示当前跳跃次数下的最远范围，当i=0时，curDistance=0;
           maxDist表示下一轮能跳跃的最远范围，当maxDist>=len-1，表明找到最小count，结束循环
     */
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;

        int count = 0;
        int curDist = 0;
        int maxDist = 0;

        for (int i = 0; i < len; i++) {
            maxDist = Math.max(maxDist, i + nums[i]);
            if (maxDist >= len - 1) {
                count++;
                break;
            }
            if (i == curDist) {
                curDist = maxDist;
                count++;
            }
        }

        return count;
    }


























    /*思路：用一个数组minJump记录每个位置的最小跳跃次数
           遍历数组，minJump[i] = Math.min(
           效率太低！！！
     */
//    public int jump(int[] nums) {
//        int len = nums.length;
//
//        int[] minJump = new int[len];
//        for (int i=0; i<len; i++){
//            for (int j=i+1; j<len && j<=i+nums[i]; j++){
//                if(minJump[j] == 0){
//                    minJump[j] = minJump[i] + 1;
//                }else{
//                    minJump[j] = Math.min(minJump[j], minJump[i]+1);
//                }
//            }
//        }
//        return minJump[len-1];
//    }
}
