package A_Coding_Test.Lenovo_8_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/21 14:39
 */
public class T2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        int count = 0;//统计一行长度
        HashSet<String> hashset = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<n; i++){
            String S = input.readLine();
            String[] ArrS = S.split(" ");

            for (String temp : ArrS) {
                if (hashset.contains(temp)) {
                    continue;
                } else {
                    hashset.add(temp);
                    sb.append(temp + " ");
                }
            }
        }
        String sbs = sb.toString();
        String[] arr_sbs = sbs.split(" ");
        Arrays.sort(arr_sbs);

        for (String temp : arr_sbs) {
            if (count + temp.length() < 50){
                System.out.print(temp + " ");
                count = count + temp.length() + 1;
            }else if (count + temp.length() == 50){
                System.out.print(temp);
                System.out.println();
                count = 0;
            }else{
                System.out.println();
                count = 0;
                System.out.print(temp + " ");
                count = count + temp.length() + 1;
            }
        }
    }
}
