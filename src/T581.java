/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-04-25$ $
 */
public class T581 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,4,5};
        T581 test = new T581();
        System.out.println(test.findUnsortedSubarray(nums));
    }
    /*https://pic.leetcode-cn.com/1627957087-VYaluV-%E6%9C%80%E7%9F%AD%E6%97%A0%E5%BA%8F%E8%BF%9E%E7%BB%AD%E5%AD%90%E6%95%B0%E7%BB%84%E9%A2%98%E8%A7%A3.png
这个算法背后的思想是无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界。
    1、先从左往右找到非升序的左边界，然后从右往左找出非升序的右边界
    2、然后找出非升序中的最小值和最大值，插入到原先的有序的左右两部分对应位置
*/
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1) return 0;
        int left = 0;
        int right = len-1;

        //找出非升序左边界
        for(int i=0; i<len-1; i++){
            if(nums[i] > nums[i+1]){
                left = i;
                break;
            }
            //这里把全升序的情况排除掉
            if(left == 0 && i==len-2){
                return 0;
            }
        }
        //找出非升序右边界
        for(int j=len-1; j>0; j--){
            if(nums[j-1] > nums[j]){
                right = j;
                break;
            }
        }
        int min = nums[left];
        int max = nums[right];
        //找出非升序部分最小值与最大值
        for(int i=left; i<=right; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        //找出最小值在左右升序中的位置
        for(int i=0; i<left; i++){
            if(min < nums[i]){
                left = i;
                break;
            }
        }
        //找出最大值在左右升序中的位置
        for(int j=len-1; j>right; j--){
            if(nums[j] < max){
                right = j;
                break;
            }
        }
        return right -left + 1;
    }
}
