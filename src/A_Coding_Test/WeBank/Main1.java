package A_Coding_Test.WeBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/13 19:35
 */
public class Main1 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(input.readLine());
//        String numsStr = input.readLine();
//        String[] numsArr = numsStr.split(" ");
//
//        Main1.help(n, numsArr);
//    }
    public static void main(String[] args) {
        int n = 4;
        String[] numsArr = {"123" ,"4545","678", "23"};
        Main1.help(n,numsArr);
    }

    public static void help(int n, String[] numsArr){
        int[] nums = new int[numsArr.length];
        for (int i = 0; i < numsArr.length; i++) {
            nums[i] = Integer.parseInt(numsArr[i]);
        }
        Arrays.sort(nums);

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0) - o1.charAt(0);
            }
        });
        for (int j = n-1; j>n-4; j--) {
            pq.offer(nums[j]+"");
        }
        StringBuffer sb = new StringBuffer();

        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        System.out.println(sb);
    }
}
