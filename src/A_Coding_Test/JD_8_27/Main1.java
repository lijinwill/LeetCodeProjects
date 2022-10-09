package A_Coding_Test.JD_8_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/27 19:28
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String S1 = input.readLine();
        String[] S1_arr = S1.split(" ");
        int n = Integer.parseInt(S1_arr[0]);
        int k = Integer.parseInt(S1_arr[1]);

        String S = input.readLine();

        StringBuffer sb = new StringBuffer();

        String left = S.substring(0,k);
        String right = S.substring(k,S.length());

        sb.append(left.toUpperCase());
        sb.append(right.toLowerCase());
        System.out.println(sb.toString());
    }
}
