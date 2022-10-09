package Hash_Practice;

import java.util.*;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-4-19$ $
 */
public class T18 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,-1000000000,-1000000000,-1000000000,-1000000000};
        //int[] nums = new int[]{-10,-10,-10,-10,0,0,0};
        int target = -1000000000;
        T18 test = new T18();
        System.out.println(test.fourSum(nums, target));
    }

    /*思路：三数求和套for循环
        1、比如nums = [-2,-1,0,0,1,2], target = 0，遍历求三数和为target-nums[i]的List，如果存在，List.add(nums[i])
    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> hashset = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        //最外层循环取四数中的一个
        for(int i=0; i<len; i++){
            //遇到重复的直接跳过提高效率
            if(i>0 && nums[i-1] == nums[i]) continue;

            //这里把除外层循环那个数外的数组copy一份到nums_cut里
            int[] nums_cut = new int[len-1];
            int t = 0;
            for(int c=0; c<len; c++){
                if(c != i) nums_cut[t++] = nums[c];
            }

            //内层求nums_cut数组的3数之和，nums_cut长度是len-1
            int j;
            int len_cut = len - 1;
            for(j=0; j<len_cut-2; j++){
                //这两个if大幅优化效率
                if(nums_cut[j] > (target - nums[i])/3) break;
                if(j>0 && nums_cut[j-1] == nums_cut[j]) continue;

                int left = j+1;
                int right = len_cut-1;
                while(left<right){
                    long sumOf3 = nums_cut[j] + nums_cut[left] + nums_cut[right];
                    if(sumOf3 == target - nums[i]){
                        ArrayList<Integer> part = new ArrayList(
                                Arrays.asList(nums[i], nums_cut[j], nums_cut[left], nums_cut[right]));
                        Collections.sort(part);
                        if(!hashset.contains(part)){
                            result.add(part);
                            hashset.add(part);
                        }
                        left++;
                        right--;
                    }else if(sumOf3 > target - nums[i]){
                        right--;
                    }else if(sumOf3 < target - nums[i]){
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
