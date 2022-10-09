package Array_Practice;

import java.util.Arrays;
/**
 * @author Will
 * @version 1.0
 * @description: 这是失败做法，无法通过全部测试，而且代码太耗时间
 * @date 8/11/2022 5:12 PM
 */
public class T1675 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,8,6,1,6};
        T1675 test = new T1675();
        System.out.println(test.minimumDeviation(nums));
    }

    //思路：先排序，然后考察数组两端的数据，如果最大值是偶数，则除二，比较更改前后大小变化，若变大，则不更新并结束循环
    //              如果最小值是奇数，则乘2，比较更改前后大小变化，若变大，则不更新并结束循环；
    //      再排序，重复上述操作直到最大值是奇数，最小值是偶数；或是改变只会变大
    public int minimumDeviation(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[len-1];
        int dif = max - min;
        //当最大值为偶或最小值为奇数时执行循环
         while(min%2 == 1 || max%2 == 0){
            //如果最大值是偶数，最小值是奇数，比较两者往哪边移动能使dif最小
            if(max%2 == 0 && min%2 == 1){
                int change1 = nums[len-2] - Math.min(min, max/2);
                int change2 = Math.max(min*2,max) - nums[1];
                if(change1 <= dif && change2 <= dif){
                    if(change1 < change2){
                        nums[len-1] = max/2;
                    }else{
                        nums[0] = min*2;
                    }
                    //(change1 < change2) ? nums[len-1]=max/2 : nums[0]=min*2;
                }else if(change1 <= dif && change2 > dif){
                    nums[len-1]=max/2;
                }else if(change1 > dif && change2 <= dif){
                    nums[0]=min*2;
                }else{
                    return dif;
                }
            }else if(max%2 == 0 && min%2 != 1){  //如果最大值是偶数
                int change1 = nums[len-2] - Math.min(min, max/2);
                if(change1 <= dif){
                    nums[len-1] = max/2;
                }else{
                    return dif;
                }
            }else if(max%2 != 0 && min%2 == 1){  //如果最小值是奇数
                int change2 = Math.max(min*2,max) - nums[1];
                if(change2 <= dif){
                    nums[0] = min*2;
                }else{
                    return dif;
                }
            }else{
                return dif;
            }

            Arrays.sort(nums);
            min = nums[0];
            max = nums[len-1];
            dif = max - min;
        }
        return dif;
    }
}
