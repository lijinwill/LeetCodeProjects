package A_Coding_Test.TianYiYun_9_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/14 20:38
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scan.readLine());
        String Sn = scan.readLine();
        String[] SnArr = Sn.split("\\,");

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        for (int i=0; i <n; i++){
            int temp = Integer.parseInt(SnArr[i]);
            if (temp%2 == 0){
                sb1.append(temp+",");
            }else{
                sb2.append(temp+",");
            }
        }
        sb1.append(sb2);
        sb1.deleteCharAt(sb1.length()-1);
        System.out.println(sb1);


    }
}
