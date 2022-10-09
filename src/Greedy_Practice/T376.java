package Greedy_Practice;

import java.util.ArrayList;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-13$ $
 */
public class T376 {
    public static void main(String[] args) {
        //int[] nums = new int[]{1,7,4,9,2,5};
        //int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        int[] nums = new int[]{0,0,0,0,0};
        T376 test = new T376();
        System.out.println(test.wiggleMaxLength(nums));
    }
    /*思路1：贪心
        统计峰值的个数，参考代码随想录的思路1
    */
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 1) return 1;
        if (len == 2 && nums[0] != nums[1]){
            return 2;
        }else if(len == 2 && nums[0] == nums[1]){
            return 1;
        }

        ArrayList<Integer> list = new ArrayList<>();
        //遍历数组，遇到重复且连续的数字就删除
        for (int i=0; i<len-1; i++){
            if(nums[i] != nums[i+1]){
                list.add(nums[i]);
            }
        }
        list.add(nums[len-1]);

        //如果list只有一个数，则result为一，大于一个数，则为2
        int result = list.size()==1 ? 1:2;
        //再遍历数组，寻找左右都比它小或是左右都比它大的峰值数量
        for (int i=1; i<list.size()-1;i++){
            if((list.get(i-1)<list.get(i) && list.get(i)>list.get(i+1)) ||
                    (list.get(i-1)>list.get(i) && list.get(i)<list.get(i+1))){
                result++;
            }
        }
        return result;
    }
}
