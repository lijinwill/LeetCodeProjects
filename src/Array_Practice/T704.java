package Array_Practice;

/**
 * @Classname T704
 * @Description TODO
 * @Date 2022/7/3 10:42
 * @Created by Will
 */
public class T704 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 13;
        T704 test = new T704();
        System.out.println(test.search(nums,target));
    }
    /* 实现二分查找
     */
    public int search(int[] nums, int target) {
        if (target > nums[nums.length-1] || target < nums[0]) return -1;

        int left = 0;
        int right = nums.length;
        int mid;
        while (left <= right){
            mid = (left+right)/2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid-1;
            }
        }
        return -1;
    }
}
