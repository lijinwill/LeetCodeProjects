package A_Coding_Test.ShenCe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/30 16:05
 */
public class Main33 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        String S = input.readLine();
        String[] arrS = S.split(" ");
        int maxVal = 0;
        for (int i = 0; i < arrS.length; i++) {
            for (int j = i+1; j < arrS.length; j++) {
                int num1 = Integer.parseInt( arrS[i]);
                int num2 = Integer.parseInt( arrS[j]);
                maxVal = Math.max(maxVal, num1+num2-(j-i));
            }
        }
        System.out.println(maxVal);
    }
}
