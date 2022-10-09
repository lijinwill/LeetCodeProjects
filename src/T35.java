/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/11/12 23:42
 */
public class T35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 7;

        T35 test = new T35();
        int location = test.searchInsert(nums,target);
        System.out.println(location);
    }

    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while(i<nums.length && nums[i] < target){
            i++;
        }

        return i;
    }
}
