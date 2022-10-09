package A_Coding_Test.RedBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main11 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String S1 = input.readLine();
        String[] S1Arr = S1.split(" ");
        int n = Integer.parseInt(S1Arr[0]);
        if (n == 1) {
            System.out.println(0);
            return;
        };
        int m = Integer.parseInt(S1Arr[1]);
        int id = Integer.parseInt(S1Arr[2]);

        int[][] ranking = new int[n][2];
        for (int i=0; i<n; i++){
            String Sn = input.readLine();
            String[] SnArr = Sn.split(" ");
            int sum = 0;
            for (int j=0; j<m; j++) {
                sum = sum + Integer.parseInt(SnArr[j]);
            }
            ranking[i][0] = i;
            ranking[i][1] = sum;
        }

        Arrays.sort(ranking, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else{
                    return o2[1] - o1[1];
                }
            }
        });

        for (int i = 0; i < n; i++) {
            if (ranking[i][0] == id) {
                System.out.println(i);
                return;
            }
        }
    }
}
