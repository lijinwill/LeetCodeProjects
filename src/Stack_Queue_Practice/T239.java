package Stack_Queue_Practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname T239
 * @Description TODO
 * @Date 2022/7/11 20:39
 * @Created by Will
 */
public class T239 {

    /*思路：
        1、滑动窗口存入队列，先确定滑动窗口开始时的最大值及其出现的下标[max,idx]，
        2、每右移一位，出队一个入队一个，如果出队的值等于最大值，再次循环找出最大值；
        3、如果入队的值大于最大值，更新[max,idx]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> result = new LinkedList<>();

        LinkedList<Integer> queue = new LinkedList<>();
        //先找出一开始窗口的最大值与下标
        for (int i=0; i<k; i++){
            queue.offer(nums[i]);
        }
        int[] max_idx = findMax(queue);
        result.offer(max_idx[0]);

        //然后循环进行下面的窗口，每次循环出队一个out，入队一个nums[i]
        for (int i=k; i<nums.length; i++){
            int out = queue.poll();
            queue.offer(nums[i]);
            //if 如果出队的元素就是 上一轮队列中的最大值，那么不管入队的是啥，我都要重新找一遍最大值及其下标
            //else if 如果出队的元素不是 上一轮的最大值，那么新入队的就和上一轮的最大值比较，如果更小，则不更新最大值
            if (i-k == max_idx[1]){
                int[] temp = findMax(queue);
                max_idx[0] = temp[0];
                max_idx[1] = i-k+1 + temp[1];

                result.offer(max_idx[0]);
            } else if (max_idx[0] <= nums[i]) {
                max_idx[0] = nums[i];
                max_idx[1] = i;
                result.offer(nums[i]);
            }else if (max_idx[0] > nums[i]){
                result.offer(max_idx[0]);
            }
        }
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }
    public int[] findMax(LinkedList<Integer> queue){
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i=0; i<queue.size(); i++){
            if (queue.get(i) >= max){
                max = queue.get(i);
                idx = i;
            }
        }
        return new int[]{max,idx};
    }
}
