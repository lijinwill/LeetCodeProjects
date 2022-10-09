package Array_Practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Will
 * @version 1.0
 * @description: 73 / 75 放弃了
 * @date 8/11/2022 5:12 PM
 */
public class T1675_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,5,20,3};
        T1675_2 test = new T1675_2();
        System.out.println(test.minimumDeviation(nums));
    }
    //思路：先排序，记录最小值min，将所有奇数*2，因为奇数*2是偶数，所以就将问题计算全部转为最大偶数除2
    //      建立一个大根堆，每轮取出最大元素，如果是偶数，除2放入大根堆继续，并更新最小值min
    //      当最大值是奇数结束循环
    public int minimumDeviation(int[] nums) {
        //建一个大根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int min = Integer.MAX_VALUE;
        //将全部奇数乘2
        for (int i=0; i< nums.length; i++){
            if (nums[i]%2 == 1) nums[i] = nums[i]*2;
            min = Math.min(min,nums[i]);
            pq.add(nums[i]);
        }


        int temp = pq.poll();
        int dif1 =  temp - min;
        int dif2;
        //当最大值是偶数时循环继续
        while(temp%2 == 0){
            min = Math.min(min, temp/2);
            dif2 = pq.peek() - min;
            if (dif2 <= dif1){
                pq.add(temp/2);
                temp = pq.poll();
                dif1 = dif2;
            }else{
                return dif1;
            }
        }
        return temp-min;
    }
}
