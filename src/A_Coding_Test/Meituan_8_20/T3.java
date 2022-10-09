package A_Coding_Test.Meituan_8_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/20 10:57
 */
public class T3 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int timu;
        int fuxi;
        String s = input.readLine();
        String[] arr = s.split(" ");
        timu = Integer.parseInt(arr[0]);
        fuxi = Integer.parseInt(arr[1]);

        int[][] possibilityScore = new int[timu][2];

        s = input.readLine();
        arr = s.split(" ");
        for (int i=0; i<timu; i++){
            possibilityScore[i][0] = Integer.parseInt(arr[i]);
        }

        s = input.readLine();
        arr = s.split(" ");
        for (int i = 0; i < timu; i++) {
            possibilityScore[i][1] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(possibilityScore, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        double result = 0;
        for (int i = 0; i < timu; i++) {
            if (i<fuxi){
                result = result + possibilityScore[i][1];
            }
            result = result + possibilityScore[i][0]*possibilityScore[i][1]/100;
        }
        System.out.println(result);
    }
}
