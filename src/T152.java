import java.util.Arrays;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-01$ $
 */
public class T152 {
    public static void main(String[] args) {
        //int[] nums = new int[]{2,3,-2,4};
        //int[] nums = new int[]{-2,0,-1};
        //int[] nums = new int[]{100,-1,1,1,1,1,-1,1,1,-1,11,1,1};
        //int[] nums = new int[]{0,2};
        int[] nums = new int[]{-2,0};
        T152 test = new T152();
        System.out.println(test.maxProduct(nums));
    }
    /*思路：因为都是整数，取决于0和负数的位置，因为正整数是越乘越大的
        先找0的位置，将数组根据0的位置分别遍历；
        然后统计每个部分的负数个数，如果是偶数个，则全部乘起来J就是局部答案；
            如果是奇数个，则J/最左侧负数及其左边数乘积 和 J/最右侧负数及其右边数乘积中的较大着即为局部答案
        返回最大的局部答案
    */
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];

        int result = Integer.MIN_VALUE;
        int last0 = 0;
        int i;
        for(i=0; i<nums.length; i++){
            if(nums[i] == 0 && i == 0) last0 = 1;
            if(nums[i] == 0 && i != 0){
                //就是凡是遇到0，就将其前面的数送去求最大值
                int [] numsCut = Arrays.copyOfRange(nums, last0, i);
                result = Math.max(result, maxProductExcept0(numsCut));
                last0 = i+1;
            }
        }
        //这里的意思是如果只有中间那里有一个0，则0到末尾的数再送去找一下
        if(i == nums.length && nums[i-1] != 0) result = Math.max(result, maxProductExcept0(Arrays.copyOfRange(nums, last0, i)));

        //如果不存在0
        if(last0 == 0){
            result = Math.max(result, maxProductExcept0(nums));
            return result;
        }else{
            if(result < 0){
                return 0;
            }else{
                return result;
            }
        }
    }
    //这部分专门求没有0的数组情况
    public int maxProductExcept0(int[] nums){
        if(nums.length == 1) return nums[0];
        int product = 1;
        int numOfNegative = 0;
        for(int i=0; i<nums.length; i++){
            product = product * nums[i];
            if(nums[i] < 0) numOfNegative++;
        }

        //负数有奇偶个分情况讨论
        if(numOfNegative % 2 == 0){
            return product;
        }else{
            //最左侧负数及其左侧数的乘积
            int i=0;
            int leftProduct = 1;
            for(; nums[i]>0; i++){
                leftProduct *= nums[i];
            }
            leftProduct *= nums[i];
            //最右侧负数及其右侧数的乘积
            i=nums.length-1;
            int rightProduct = 1;
            for(; nums[i]>0; i--){
                rightProduct *= nums[i];
            }
            rightProduct *= nums[i];
            return Math.max(product/leftProduct, product/rightProduct);
        }
    }
}
