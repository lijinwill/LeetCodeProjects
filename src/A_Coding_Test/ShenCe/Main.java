package A_Coding_Test.ShenCe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/30 15:05
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String Sn;
        //String[] S1Arr = Sn.split(" ");

        //思路：首先将0补充回去，然后根据.分割，然后转为十进制Long输出
        //      排除任何一位不在0-255；首位为0，首尾无元素。
        while((Sn = input.readLine()) != null){
            int firstDotPos = 0;
            int lastDotPos = 0;
            int countDot = 0;
            for (int i = 0; i < Sn.length(); i++) {
                //第一个点的Pos位置
                if (Sn.charAt(i) == '.' && countDot == 0){
                    firstDotPos = i;
                    countDot++;
                }else if (Sn.charAt(i) == '.' && countDot == 5){//最后一个点.的位置
                    lastDotPos = i;
                }else if (Sn.charAt(i) == '.'){
                    countDot++;
                }
            }

            //排除首尾无元素。
            if (firstDotPos == 0 || lastDotPos == Sn.length()-1) {
                System.out.println(-1);
                continue;
            }
            //排除首位为0
            String firstNum = Sn.substring(0,firstDotPos);
            if (firstNum == null) {
                System.out.println(-1);
                continue;
            }

            StringBuffer sb = new StringBuffer();
            String[] arrSn = Sn.split("//.");

            boolean flag = true;
            for (int i = 0; i < arrSn.length; i++) {
                if (arrSn[i] == ""){
                    arrSn[i] = "0";
                }
                if (Integer.parseInt(arrSn[i]) < 0 || Integer.parseInt(arrSn[i]) > 255){
                    System.out.println(-1);
                    flag = false;
                    break;
                }
                sb.append(arrSn[i]+".");
            }
            if (flag = false) continue;

            sb.deleteCharAt(sb.length()-1);


            String[] ipAddressInArray = sb.toString().split("\\.");

            long result = 0;
            for (int i = 0; i < ipAddressInArray.length; i++) {

                int power = 3 - i;
                int ip = Integer.parseInt(ipAddressInArray[i]);
                result += ip * Math.pow(256, power);

            }
            System.out.println(result);
        }
    }
}
