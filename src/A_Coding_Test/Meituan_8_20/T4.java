package A_Coding_Test.Meituan_8_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/20 11:39
 */
public class T4 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        String[] arr = s.split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        s = input.readLine();
        arr = s.split(" ");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(arr[i]);
        }

        s = input.readLine();
        arr = s.split(" ");
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(arr[i]);
        }

        int count = 0;
        if (m == n){
            for (int i=0; i<m; i++){
                int delta1 = Math.abs(B[i] - A[i]);
                int delta2 = Math.min(Math.abs(A[i]), Math.abs(B[i]));
                count = count + Math.min(delta1, delta2);
            }
        } else if (m > n){

        }
        System.out.println(count);
    }
}
