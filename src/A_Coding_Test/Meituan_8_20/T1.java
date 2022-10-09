package A_Coding_Test.Meituan_8_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/20 10:00
 */
public class T1 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(input.readLine());
        String s1 = input.readLine();
        String s2 = input.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<len; i++){
            sb.append(s1.charAt(i));
            sb.append(s2.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
