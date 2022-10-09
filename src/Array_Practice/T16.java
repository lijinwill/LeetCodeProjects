package Array_Practice;

import java.util.Arrays;

public class T16 {
    //思路：双指针法，先排序
    //     以遍历的方式固定一个节点，左右指针放置在该节点右侧剩余数组的两侧，
    //     求三者和，当小于target，左指针右移；当大于target，右指针左移；
    //     用一个sumRes当前差距最小的和
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int sumRes = nums[0] + nums[1] + nums[2];
        for (int i=0; i<nums.length-2; i++){
            int leftP = i+1;
            int rightP = nums.length-1;
            while(leftP < rightP){
                int sum = nums[i] + nums[leftP] + nums[rightP];
                if (sum > target){
                    rightP--;
                    int delta1 = Math.abs(sum - target);
                    int delta2 = Math.abs(sumRes - target);
                    if (delta1 < delta2) sumRes = sum;

                } else if (sum < target) {
                    leftP++;
                    int delta1 = Math.abs(sum - target);
                    int delta2 = Math.abs(sumRes - target);
                    if (delta1 < delta2) sumRes = sum;

                }else{
                    return sum;
                }
            }
        }
        return sumRes;
    }
}
