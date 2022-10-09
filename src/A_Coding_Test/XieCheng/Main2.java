package A_Coding_Test.XieCheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/30 18:57
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(input.readLine());

        for (int i=0; i<q; i++){
            String Sn = input.readLine();
            String[] arrSn = Sn.split(" ");
            int a = Integer.parseInt(arrSn[0]);
            int b = Integer.parseInt(arrSn[1]);
            int c = Integer.parseInt(arrSn[2]);

        }

    }
    public void Help(int a, int b, int c){
        int result = 0;
        int min = Math.min(Math.min(a,b),c);
        result = result + min*2;
        b = b - min;
        if (b == 2){
            result = result + 1;
        }else if(b > 2){
            result = result + b/2+1;
        }
        System.out.println(result);
    }

}
