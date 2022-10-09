package Heap;

import java.util.*;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-04$ $
 */
public class T692 {
    /*思路一:
        哈希表统计，<String, Integer>键是字符串，值是出现的次数
        再有一个小根堆，堆比较的是出现次数，如果次数相同
    */
//    public List<String> topKFrequent(String[] words, int k) {
//        List<String> result = new ArrayList<>();
//        HashMap<String, Integer> hashmap = new HashMap<>();
//        //此遍历统计全部单词出现的词频
//        for(int i=0; i<words.length; i++){
//            String word = words[i];
//            if(!hashmap.containsKey(word)){
//                hashmap.put(word, 1);
//            }else{
//                hashmap.put(word, hashmap.get(word)+1);
//            }
//        }
//        //用大根堆去找出最高频的前K个单词
//        PriorityQueue<Map.Entry<String, Integer>> minHeap =
//            new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
//            public int compare(Map.Entry<String,Integer> entry1, Map.Entry<String,Integer> entry2){
//                //如果两个单词的词频不同，则直接取差，这是增序排列。相减的顺序其实可以测试的时候再该。
//                if(entry1.getValue() != entry2.getValue()){
//                    return entry1.getValue() - entry2.getValue();
//                }else{
//                    //如果词频相同，返回字典序较低的，这个谁比较谁可以测试的时候修改
//                    return entry2.getKey().compareTo(entry1.getKey());
//                }
//            }
//        });
//        //将全部hashmap中的元素送入大根堆
//        for(Map.Entry<String,Integer> entry : hashmap.entrySet()){
//            minHeap.offer(entry);
//        }
//        //将前k输出
//        while(result.size() < k){
//            result.add(minHeap.poll().getKey());
//        }
//
//        return result;
//    }

    /*思路二：
        哈希表统计词频，<String, Integer>键是字符串，值是出现的次数
        然后将String[]中的单词放入一个List<String>
        然后用一个Collections.sort()，new comparator排序
        然后输入前k个
    */
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> hashmap = new HashMap<>();
        //此遍历统计全部单词出现的词频
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(!hashmap.containsKey(word)){
                hashmap.put(word, 1);
            }else{
                hashmap.put(word, hashmap.get(word)+1);
            }
        }
        //将不重复的单词全存到List<>
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : hashmap.entrySet()){
            list.add(entry.getKey());
        }
        //修改Collection.sort
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //如果词频不同，则排序
                if(hashmap.get(o1) != hashmap.get(o2)){
                    return hashmap.get(o1) - hashmap.get(o2);
                }else{
                    //如果词频相同则根据字典序排序
                    return o1.compareTo(o2);
                }
            }
        });

        return list.subList(0, k);
    }
}
