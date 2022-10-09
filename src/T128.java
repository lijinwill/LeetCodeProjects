import java.util.Arrays;

public class T128 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        T128 test = new T128();
        System.out.println(test.longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
        int result = 0;
        int len = nums.length;
        Arrays.sort(nums);

        int current_result = 1;
        for(int i=0; i<len-1; i++){
            if(nums[i+1] == nums[i]){
                continue;
            }
            if(nums[i+1]-nums[i] == 1){
                current_result++;
            }else{
                result = Math.max(result, current_result);
                current_result = 1;
            }
        }
        return result;
    }
}
