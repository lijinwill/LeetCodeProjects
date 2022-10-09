package A_Coding_Test.ByteDance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/21 18:48
 */
public class T1 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());

        for (int row = 0; row < t; row++) {

            String nk = input.readLine();
            String[] arrNk = nk.split(" ");
            int n = Integer.parseInt(arrNk[0]);//01串长度
            int k = Integer.parseInt(arrNk[1]);//可交换次数
            String oriStr = input.readLine();
            int leftLen = 0;
            int rightLen = 0;
            //只要边缘是1就行
            for (int i = 0; i < n; i++) {
                if (oriStr.charAt(i) == '0') {
                    leftLen++;
                }else{
                    break;
                }
            }
            for (int i = n-1; i >= 0; i--) {
                if (oriStr.charAt(i) == '0') {
                    rightLen++;
                }else{
                    break;
                }
            }
            //求1的个数
            int count1 = 0;
            for (int i = 0; i < n; i++) {
                if (oriStr.charAt(i) == '1') count1++;
            }

            if (leftLen + rightLen <= k){
                int result = 11 + (count1-2)*11;
                System.out.println(result);
            }else if (leftLen > k && rightLen > k){
                int result = count1*11;
                System.out.println(result+"");
            }else{
                int result = 10 + (count1-1)*2;
                System.out.println(result+"");
            }
        }

    }
}
