package Stack_Queue_Practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/15/2022 2:10 PM
 */
public class FreqStack {
    //思路：用一个HashMap记录出现的数字以及其频率，
    //      用一个PriorityQueue<int[]> pq记录数字，频率，以及在栈中的排序index
    //      其中进入pq时，先根据第二位的频率排序，若频率相同，则根据第三位栈中位置排序
    HashMap<Integer, Integer> hashmap;
    PriorityQueue<int[]> pq;
    int idx;

    public FreqStack() {
        hashmap = new HashMap<>();
        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //先根据频率排序，频率相同时再根据栈中顺序排序
                if (o1[1] == o2[1]){
                    return o2[2] - o1[2];
                }else{
                    return o2[1] - o1[1];
                }
            }
        });
        idx = 0;
    }

    public void push(int val) {
        int change = hashmap.getOrDefault(val,0) + 1;
        hashmap.put(val,change);
        pq.add(new int[]{val, change, idx++});
    }

    public int pop() {
        int[] out = pq.poll();
        hashmap.put(out[0],out[1]-1);
        return out[0];
    }
}
