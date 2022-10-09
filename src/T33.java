import java.util.Arrays;

public class T33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 4;
        T33 test = new T33();
        System.out.println( test.search(nums,target) );
    }
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 1 && nums[0] != target){
            return -1;
        }else if(len == 1 && nums[0] == target){
            return 0;
        }

        int i = 0;
        while(nums[i] < nums[i+1]){
            i++;
        }
        return Math.max(
                binary_search(Arrays.copyOfRange(nums, 0, i+1), target),
                binary_search(Arrays.copyOfRange(nums, i+1, nums.length), target)+i+1
        );
    }

    public int binary_search(int[] nums, int target){
        int len = nums.length;
        int i = 0, j = len-1, med = (i+j)/2;

        while(i <= j){
            if(nums[med] < target){
                i = med;
                med = (i + j)/2;
            }else if(nums[med] > target){
                j = med;
                med = (i + j)/2;
            }else{
                return med;
            }
        }
        return -1;
    }
}
