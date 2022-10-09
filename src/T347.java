import java.util.HashMap;
import java.util.Map;

public class T347 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 2;
        T347 test = new T347();
        System.out.println(test.topKFrequent(nums, k));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k]; //结果数组

        int len = nums.length;

        if (len == 1) {
            return nums;
        }
        //
        Map<Integer, Integer> map = new HashMap();
        //统计出现频次
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //找出频次最高的
        int maxValue = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
        }
        //根据频次倒序输出
        int i = 0;
        while(i < k) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxValue) {
                    result[i++] = entry.getKey();
                }
            }
            maxValue--;
        }
        return result;
    }
}


