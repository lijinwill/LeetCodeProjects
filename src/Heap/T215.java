package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname T215
 * @Description TODO
 * @Date 2022/7/14 18:06
 * @Created by Will
 */
public class T215 {
    //排序的做法就不做了，这里练习一下优先队列

    public static void main(String[] args) {

    }
    public int findKthLargest(int[] nums, int k) {
        //用小根堆，每次把最小的弹出
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i: nums){
            pq.offer(i);
            if (pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }

}
