package A_Coding_Test.XieCheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        int q = Integer.parseInt(input.readLine());
//        for (int i = 0; i < q; i++) {
//            //int x = Integer.parseInt(input.readLine());
//            String x = input.readLine();
//            Main.Help(x);
//        }
//    }
    public static void main(String[] args) {
        String x = "313140000";
        Main.Help(x);
    }
    public static void Help(String x){
        //排除单个字符情况
        if (x.length() == 1){
            if (Integer.parseInt(x) % 2 == 0) {
                System.out.println(x);
            }else {
                System.out.println(-1);
            }
            return;
        }

        //统计字符的个数，
        int[] count = new int[10];
        for (int i = 0; i < x.length(); i++) {
            int num = (int)x.charAt(i) - (int)('0');
            count[num]++;
        }

        //不可能情况：如果0的数量是x.length()-1个；没有偶数；
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i < 10; i=i+2) {
            while (count[i] > 0){
                sb.append(i);
                count[i]--;
            }
        }
        if (sb.length() == 0){
            for (int i = 2; i < 10; i=i+2) {
                while (count[i] > 0){
                    sb.append(i);
                    count[i]--;
                }
            }
        }
        while (count[0] > 0) {
            sb.append(0);
            count[0]--;
        }
        for (int i = 2; i < 10; i=i+2) {
            while (count[i] > 0){
                sb.append(i);
                count[i]--;
            }
        }

        int sbNum = Integer.parseInt(sb.toString());
        if (sbNum % 2 == 0){
            System.out.println(sbNum);
        }else{
            System.out.println(-1);
        }
    }
}
