package A_Coding_Test.ByteDance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/21 19:47
 */
public class T2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        String[] arr  = s.split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        int count = 0;
        for (int i=0; i<n; i++){
            String temp = input.readLine();
            for (int j=0; j<m; j++){
                if (temp.charAt(j) != '.'){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
