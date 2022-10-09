package A_Coding_Test.RedBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/28 16:52
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String S1 = input.readLine();
        String[] S1Arr = S1.split(" ");
        Long n = Long.parseLong(S1Arr[0]);
        Long K = Long.parseLong(S1Arr[1]);

        String S2 = input.readLine();
        String[] S2Arr = S2.split(" ");
        Long count = 0L;
        for (int i=0; i<n-1; i++){
            Long spell1 = Long.parseLong(S2Arr[i]);
            for (int j=i+1; j<n; j++) {
                Long spell2 = Long.parseLong(S2Arr[j]);
                if (spell1 * spell2 >= K) count = count + 2;
            }
        }
        System.out.println(count);
    }
}

//    Long spell1 = Long.parseLong(S2Arr[i]);
