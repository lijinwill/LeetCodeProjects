package Heap;

import java.util.*;

/**
 * @Classname T692_2
 * @Description TODO
 * @Date 2022/7/14 19:51
 * @Created by Will
 */
public class T692_2 {
    public static void main(String[] args) {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        T692_2 test = new T692_2();
        System.out.println(test.topKFrequent(words,k));
    }
    //思路：用HashMap统计词频，然后用小跟堆存放频次最高的<单词,频次>
    //     输出为list
    public List<String> topKFrequent(String[] words, int k) {
        //用HashMap统计词频
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (String s : words){
            if (!hashmap.containsKey(s)){
                hashmap.put(s,1);
            }else{
                hashmap.put(s, hashmap.get(s)+1);
            }
        }
        //遍历HashMap，用小根堆存放频次前k个的entry
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o1.getValue()-o2.getValue();
            }
        });

        for (Map.Entry<String,Integer> entry : hashmap.entrySet()){
            pq.offer(entry);
            if (pq.size() > k){
                pq.poll();
            }
        }

        //遍历小根堆输出List
        List<String> result = new ArrayList<>();
        while(pq.size() > 0){
            result.add(pq.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }

}
