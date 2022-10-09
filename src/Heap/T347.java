package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-04-22$ $
 */
public class T347 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        T347 test = new T347();
        System.out.println(test.topKFrequent(nums, k));
    }
    /*思路：建一个哈希表，记录每个元素及其出现的次数
        然后遍历哈希表，将前k个元素（不考虑相对大小）的key，value存入小顶堆的数组中，此小顶堆根据数组的第二位排序
        然后继续哈希表剩余元素，当小顶堆堆顶数组value，小于
    */
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        //此minHeap为[key,value]的二维数组
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //将<值，出现次数>存入hashmap
        for(int i=0; i<len; i++){
            if(!hashmap.containsKey(nums[i])){
                hashmap.put(nums[i],1);
            }else{
                hashmap.put(nums[i], hashmap.get(nums[i]) + 1);
            }
        }
        //此循环将出现次数为前k个的元素存入小顶堆
        for(Integer key : hashmap.keySet()){
            if(minHeap.size() < k){
                minHeap.offer( new int[]{key, hashmap.get(key)} );
            }else{
                if(minHeap.peek()[1] < hashmap.get(key)){
                    minHeap.poll();
                    minHeap.offer( new int[]{key, hashmap.get(key)} );
                }
            }
        }
        //将前k的key输出
        int[] result = new int[k];
        int i = 0;
        while(minHeap.size() > 0){
            result[i] = minHeap.poll()[0];
            i++;
        }
        return result;
    }
}
