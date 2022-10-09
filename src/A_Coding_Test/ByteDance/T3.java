package A_Coding_Test.ByteDance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/21 20:08
 */
public class T3 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        String sCommon = input.readLine();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sCommon.length(); i++) {
            char temp = sCommon.charAt(i);
            if (temp - 'a' >= 0 && temp - 'z'<=0){
                sb.append(temp);
            }
            if (temp == '{'){
                sb.append(1);
            }
        }

        String sModify = sb.toString();
        String[] arrS = sModify.split("1");
        int size = arrS.length;
        int len1 = arrS[0].length();//模板中第一个子串长度
        int len2 = arrS[size-1].length();//模板中最后一个子串长度

        //处理每一行
        for (int i = 0; i < N; i++) {
            String sRow = input.readLine();//用于匹配的行
            int sRowLen = sRow.length();

            int pos_arrS = 0;//用于记录判断到了模板中的第几个
            String tempS = arrS[pos_arrS];//模板中第pos个String
            int len = tempS.length();//模板中第一个子串长度

            //首尾比较一下，内部的只要出现过就返回true

            if(! sRow.substring(sRowLen - len2, sRowLen).equals(arrS[size - 1])){
                System.out.println(false);
                continue;
            }
            //用于滑动比较sRow是否可以匹配上
            int j;
            for (j=0; j<sRow.length(); ){
                if (sRow.substring(j,len).equals(tempS)){
                    pos_arrS++;
                    j = j+len;
                }else{
                    j++;
                }
            }
            if (pos_arrS > size){
                System.out.println(true);
                continue;
            }
        }
    }
}
