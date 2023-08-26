package ZhongYiHangYan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/10/14 15:14
 */
public class Main1 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        String s = br.readLine();
//
//        Main1.help(s,n);
//    }

    public static void main(String[] args) {
        String s = "XXXXX.X.XXXX";
        int n = 2;
        System.out.println(Main1.help(s,n));
    }

    public static int help(String s, int n){
        //思路：统计两个x中间的.的个数即可
        int result = 0;

        StringBuffer sb = new StringBuffer();
        if (s.charAt(0) != 'X'){
            sb.append("X");
            sb.append(s);
        }else{
            sb.append(s);
        }
        if (s.charAt(n-1) != 'X'){
            sb.append("X");
        }

        for (int i = 0; i < sb.length(); i++) {
            if (i+1 < sb.length() && sb.charAt(i) == 'X' && sb.charAt(i+1) == 'X'){
                continue;
            }
            for(int j = i+1; j < sb.length(); j++){
                if (sb.charAt(j) == 'X'){
                    if(j-i-1 >= 1 && j-i-1 <= 3){
                        result++;
                    }else{
                        result = result + (j-i-2)/3 + 1;
                    }
                    i = j-1;
                    break;
                }
            }

        }

        return result;
    }
}
