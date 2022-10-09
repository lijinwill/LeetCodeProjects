package A_Coding_Test.ShenCe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/30 15:51
 */
public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[][] cityTocity = new int[n][2];

        for (int i = 0; i < n; i++) {
            String Sn = input.readLine();
            String[] SnArr = Sn.split(" ");
            cityTocity[i][0] = Integer.parseInt(SnArr[0]);
            cityTocity[i][1] = Integer.parseInt(SnArr[1]);
        }
        String Sl = input.readLine();
        String[] SlArr = Sl.split(" ");
        int firstTra = Integer.parseInt(SlArr[0]);
        int lastTra = Integer.parseInt(SlArr[1]);


    }
}
