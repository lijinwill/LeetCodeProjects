package A_Coding_Test.ShenCe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/30 16:05
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        int[] arrs = {998, 570, 876, 200, 877};
        System.out.println(Main3.getMinDay1(arrs));

    }
    public static int getMinDay1(int[] arrs){
        int len=arrs.length;
        int[] arri=new int[len];
        int[] arrj=new int[len];
        for(int i=0;i<len;i++){
            arri[i]=arrs[i] +i;
            arrj[i]=arrs[i] -i;
        }
        int maxi=arri[0];
        int res=-1;
        for (int i=1;i<len;i++){
            res=Math.max(res,arrj[i]+maxi);
            maxi=Math.max(maxi,arri[i]);
        }
        return res;
    }
}
