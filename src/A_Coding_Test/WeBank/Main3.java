package A_Coding_Test.WeBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/13 21:22
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
//        int n =  4, m = 4;

        int[] arr = new int[n];
        long res = 0;
        for (int i = 1; i <= m-2; i++) {
            for (int j = i+1; j <= m-1; j++) {
                for (int k = j+1; k <= m; k++) {
                    for (int A = 0; A <= n-3; A++) {
                        for (int B = 0; B <= n-3; B++) {
                            if (A+B > n-3) continue;
                            for (int C = 0; C <= n-3; C++) {
                                int D = Math.max(0,n-3-A-B-C);
                                res += A*(i-1)+B*(m-j+2)+C*(m-k+2)+D*k;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(res%998244353);
    }
}
