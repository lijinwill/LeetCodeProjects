package Tree_Practice;

import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/17/2022 5:00 PM
 */
public class T654 {
    //
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;;
        if (len == 0) return null;

        int maxVal = nums[0], maxPos = 0;
        int i;
        for (i = 0; i < len; i++) {
            if (nums[i] > maxVal){
                maxVal = nums[i];
                maxPos = i;
            };
        }
        int[] leftNums = Arrays.copyOfRange(nums,0,maxPos);
        int[] rightNums = Arrays.copyOfRange(nums,maxPos+1,len);

        TreeNode root = new TreeNode(maxVal);
        root.left = constructMaximumBinaryTree(leftNums);
        root.right = constructMaximumBinaryTree(rightNums);
        return root;
    }
}
