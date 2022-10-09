package Tree_Practice;

import java.util.Arrays;

/**
 * @Classname T108
 * @Description TODO
 * @Date 2022/7/29 22:30
 * @Created by Will
 */
public class T108 {
    //思路：递归，每次取数组中间位置的数作为根节点
    public TreeNode sortedArrayToBST(int[] nums) {
        //递归退出条件
        int len = nums.length;
        if (len <= 0) return null;

        //递归处理，取数组终点作为当前层根节点
        int mid = nums[len/2];
        TreeNode root = new TreeNode(mid);

        int[] left_nums = Arrays.copyOfRange(nums, 0, len/2);
        int[] right_nums = Arrays.copyOfRange(nums,len/2+1, len);

        //前序遍历的左右子树
        root.left = sortedArrayToBST(left_nums);
        root.right = sortedArrayToBST(right_nums);

        return root;
    }
}
