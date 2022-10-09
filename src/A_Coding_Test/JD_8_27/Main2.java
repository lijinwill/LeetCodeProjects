package A_Coding_Test.JD_8_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/27 19:46
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String S = input.readLine();
        String[] S_arr = S.split(" ");
        int[] arr = new int[n];
        int i = 0;
        for (String temp : S_arr) {
            arr[i++] = Integer.parseInt(temp);
        }
        Main2 test = new Main2();
        test.help(n,arr);

    }
    //思路，统计偶数位置和奇数位置出现数字的次数，选出现次数最多的作为高低值，剩下的数字就是需要转换的
    public void help(int n, int[] arr){
        PriorityQueue<Map.Entry<String,Integer>> pqJi = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        PriorityQueue<Map.Entry<String,Integer>> pqOu = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        HashMap<String,Integer> hashmapJi = new HashMap<>();
        HashMap<String,Integer> hashmapOu = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 1){
                int freq = hashmapJi.getOrDefault(Integer.toString(arr[i]),0);
                hashmapJi.put(Integer.toString(arr[i]), freq+1);
            } else {
                int freq = hashmapOu.getOrDefault(Integer.toString(arr[i]),0);
                hashmapOu.put(Integer.toString(arr[i]), freq+1);
            }
        }
        //遍历两个hashmap，找出freq最高的两个key，如果key不相同，则输出n - freq1 -freq2
        //如果key相同，则输出

        for (Map.Entry<String,Integer> entry : hashmapJi.entrySet()){
            pqJi.offer(entry);
        }
        for (Map.Entry<String,Integer> entry : hashmapOu.entrySet()){
            pqOu.offer(entry);
        }

        String lowNum = pqJi.peek().getKey();
        int lowFreq = pqJi.poll().getValue();
        String highNum = pqOu.peek().getKey();
        int highFreq = pqOu.poll().getValue();

        if (lowNum.equals(highNum)){
            if (lowFreq < highFreq){
                String lowNum2 = pqJi.peek().getKey();
                int lowFreq2 = pqJi.poll().getValue();
                System.out.println(n - lowFreq2 - highFreq);
            }else{
                String highNum2 = pqOu.peek().getKey();
                int highFreq2 = pqOu.poll().getValue();
                System.out.println(n - lowFreq - highFreq2);

            }

        }else{
            System.out.println(n - lowFreq - highFreq);
        }
    }
}
