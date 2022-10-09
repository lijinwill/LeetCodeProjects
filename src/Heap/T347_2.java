package Heap;

import java.util.*;

/**
 * @Classname T347_2
 * @Description TODO
 * @Date 2022/7/14 11:08
 * @Created by Will
 */
public class T347_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        T347_2 test = new T347_2();
        System.out.println(test.topKFrequent(nums,k));
    }
    //思路依然是遍历数组，哈希表统计频次；然后小顶堆输出频率低的，剩下的就是频率高的。
    public int[] topKFrequent(int[] nums, int k) {
        //将数组中数据频次统计到哈希表
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i : nums){
            if(!hashmap.containsKey(i)){
                hashmap.put(i,1);
            }else{
                hashmap.put(i,hashmap.get(i)+1);
            }
        }

        //建立小根堆
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
                                        new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        //遍历哈希表，将哈希表内容存入小根堆
        Set<Map.Entry<Integer, Integer>> entries = hashmap.entrySet();
        for (Map.Entry<Integer,Integer> entry : entries){
            pq.offer(entry);
            if (pq.size() > k){
                pq.poll();
            }
        }

        //输出小根堆的所有元素
        int[] result = new int[pq.size()];
        for (int i=0; i<k; i++){
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
