package Citi;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/10/25 16:00
 */
public class Task5 {
    public static void main(String[] args) {
        Task5 test = new Task5();
        System.out.println(test.solution("abaaba"));
    }
    public int solution(String S) {
        // write your code in Java SE 8
        HashMap<String,Integer> hashmap = new HashMap<>();
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (int i = 0; i < S.length(); i++) {
            for (int j = i+1; j < S.length(); j++) {
                String sub = S.substring(i,j);
                int count = subCount(sub, S);
                hashmap.put(sub,count);
            }
        }

        for (Map.Entry<String, Integer> entry : hashmap.entrySet()){
            pq.offer(entry);
        }


        String tmp = pq.peek().getKey();
        int tmpLen = pq.poll().getValue();
        int minLen = tmp.length();
        while(!pq.isEmpty()){
            String tmp2 = pq.peek().getKey();
            int tmp2Len = pq.poll().getValue();
            if(tmpLen == tmp2Len){
                minLen = Math.min(minLen, tmp2.length());
            }else{
                break;
            }
        }

        return minLen;
    }
    public int subCount(String sub, String S){
        int count = 0;

        for (int i = 0; i <= S.length()-sub.length(); i++) {
            String S_sub = S.substring(i,i+sub.length());
            if(S_sub.equals(sub)){
                count++;
            }
        }
        return count;
    }
}
