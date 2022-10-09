package Array_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class T15 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        T15 test = new T15();
        System.out.println(test.threeSum(nums));

    }

    /*思路：双指针
    1、先把数组排好序
    2、遍历每一个数，数的两侧是指针，如果三个数的和大于0，则左指针左移，和小于0，则右指针右移
    3、注意当出现重复数字时，直接跳过重复部分，继续移动左右指针
    */
    /*思路：双指针
        1、先把数组排好序
        2、遍历每一个数，数的两侧是指针，如果三个数的和大于0，则左指针左移，和小于0，则右指针右移
        3、注意当出现重复数字时，直接跳过重复部分，继续移动左右指针

    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        HashSet<ArrayList<Integer>> hashset = new HashSet<>();
        //第一层循环用于将每个数作为中间的情况遍历过去
        for(int i=1; i<nums.length-1; i++){
            int left = i-1;
            int right = i+1;

            //第二层循环用于移动左右指针
            while(left>=0 && right<nums.length){
                int sum = nums[left] + nums[i] + nums[right];
                if(sum == 0){
                    ArrayList<Integer> part = new ArrayList<>(Arrays.asList(nums[left], nums[i], nums[right]));
                    if(!hashset.contains(part)){
                        hashset.add(part);
                        result.add(part);
                    }
                    left--;
                    right++;
                }else if(sum>0){
                    left--;
                }else{
                    right++;
                }
            }
        }

        return result;
    }
}
