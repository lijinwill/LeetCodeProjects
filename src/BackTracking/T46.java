package BackTracking;

import java.util.LinkedList;
import java.util.List;

public class T46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        T46 test = new T46();
        System.out.println(test.permute(nums));
    }
    //需返回的结果
    List<List<Integer>> result = new LinkedList<>();

    //当前考虑的列，临时结果
    LinkedList<Integer> current = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return result;
    }

    public void backtrack(int[] nums) {
        //当排列出1个可行的排列后就添加到结果中
        if (current.size() == nums.length) {
            result.add(new LinkedList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i])) {
                continue;
            }
            current.add(nums[i]);//若元素没有出现过就添加进去
            backtrack(nums);//递归向下
            current.removeLast();//上一步退出递归后立马移除最后一个元素
        }
    }
}





