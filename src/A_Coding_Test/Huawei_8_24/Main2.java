package A_Coding_Test.Huawei_8_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/24 19:49
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s1 = input.readLine();
        String[] arrS1 = s1.split(" ");
        int m = Integer.parseInt(arrS1[0]);
        int n = Integer.parseInt(arrS1[1]);

        int count = 0;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s = input.readLine();
            String[] arrS = s.split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(arrS[j]);
                if (matrix[i][j] == 0){
                    count++;
                }
            }
        }

        System.out.println(count/3);
        //思路：dfs斜着遍历，遍历过后的就标记为1


    }
    public void dfs(int[][] matrix){

    }
}
