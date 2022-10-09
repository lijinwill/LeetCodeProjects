package Heap;

import java.util.*;

/**
 * @Classname T451_2
 * @Description TODO
 * @Date 2022/7/14 18:25
 * @Created by Will
 */
public class T451_2 {
    /*思路：1、遍历字符串，用HashMap对其统计频率
           2、用大根堆存Entry
           3、输出大根堆的Entry为字符串
    */
    public String frequencySort(String s) {
        HashMap<Character,Integer> hashmap = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (!hashmap.containsKey(c)){
                hashmap.put(c,1);
            }else {
                hashmap.put(c,hashmap.get(c)+1);
            }
        }

        PriorityQueue<HashMap.Entry<Character,Integer>> pq = new PriorityQueue<>(new Comparator<HashMap.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        Set<Map.Entry<Character,Integer>> entries = hashmap.entrySet();
        for (Map.Entry<Character,Integer> entry : entries){
            pq.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            char c = pq.peek().getKey();
            int frequency = pq.poll().getValue();
            while (frequency > 0){
                sb.append(c);
                frequency--;
            }
        }
        return sb.toString();
    }
}
