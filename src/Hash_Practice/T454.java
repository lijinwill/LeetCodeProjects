package Hash_Practice;

import java.util.HashMap;

/**
 * @Classname T454
 * @Description TODO
 * @Date 2022/7/7 11:25
 * @Created by Will
 */
public class T454 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{-2,-1};
        int[] nums3 = new int[]{-1,2};
        int[] nums4 = new int[]{0,2};

        T454 test = new T454();
        System.out.println(test.fourSumCount(nums1,nums2,nums3,nums4));

    }

    /*思路：
        1、先用hashmap1统计出1和2数组的加和及其出现次数，这么做主要是本题只需要输出个数即可
        2、然后同样的统计出3和4的加和，如果hashmap1中有相反数，则count+次数
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int len = nums1.length;
        int result = 0;
        HashMap<Integer,Integer> hashmap1 = new HashMap<>();

        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        int temp;
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (hashmap1.containsKey(temp)) {
                    hashmap1.put(temp, hashmap1.get(temp) + 1);
                } else {
                    hashmap1.put(temp, 1);
                }
            }
        }

        for (int i : nums3){
            for (int j: nums4){
                temp = i+j;
                if (hashmap1.containsKey(-temp)){
                    result = result + hashmap1.get(-temp);
                }
            }
        }
        return result;
    }
}
