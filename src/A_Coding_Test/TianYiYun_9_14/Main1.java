package A_Coding_Test.TianYiYun_9_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/14 19:33
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scan.readLine());

        int[] count = new int[1000002];
        for (int i = 0; i < n; i++) {
            String Sn = scan.readLine();
            String[] SnArr = Sn.split("\\,");
            int left = Integer.parseInt(SnArr[0]);
            int right = Integer.parseInt(SnArr[1]);

            for (int j = left; j < right; j++) {
                count[j]++;
            }

        }

        int result = 0;
        for (int i = 0; i <= 1000001; i++) {
            if (count[i] == 1){
                result++;
            }
        }
        System.out.println(result);
    }
}
