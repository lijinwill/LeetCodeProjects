/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-04-26$ $
 */
public class T238 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,1,8,2};
        T238 test = new T238();
        System.out.println(test.productExceptSelf(nums));
    }
    //思路：前缀和，建立两个nums长度数组，一个l_pr(left product)记录i左侧数的乘积，一个r_pr记录i右侧数乘积
    //      然后result = l_pr[i] * r_pr[i]
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] l_pr = new int[len];
        l_pr[0] = 1;
        int[] r_pr = new int[len];
        r_pr[len-1] = 1;
        int[] result = new int[len];

        //从左往右乘积
        for(int i=1; i<len; i++){
            l_pr[i] = l_pr[i-1] * nums[i-1];
        }
        //从右往左乘积
        for(int i=len-2; i>=0; i--){
            r_pr[i] = r_pr[i+1] * nums[i+1];
            //可以在算右乘积和的时候顺便把结果数组算了
            result[i] = r_pr[i] * l_pr[i];
        }
        result[len-1] = l_pr[len-1];
        return result;
    }


//     别人的
//    public int[] productExceptSelf(int[] nums) {
//        int len = nums.length;
//        int[] ans = new int[len];
//        ans[0] = nums[0];
//        for (int i = 1; i < len; i++) {// 左侧的累乘积
//            ans[i] = ans[i - 1] * nums[i];
//        }
//        int mul = 1;// 右侧的累乘积
//        for (int i = len - 1; i > 0; i--) {
//            ans[i] = ans[i - 1] * mul;
//            mul *= nums[i];
//        }
//        ans[0] = mul;
//        return ans;
//    }
}
