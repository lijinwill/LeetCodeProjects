package A_Coding_Test.WeBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/13 21:50
 */
public class Main22 {
    public static void main(String[] args) throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(input.readLine());
            while(n > 0){
                String Sn = input.readLine();
                String[] SnArr = Sn.split(" ");
                long num = Long.parseLong(SnArr[0]);
                long target = Long.parseLong(SnArr[1]);
                Main22.help(num, target);
                n--;
            }
        }
//    public static void main(String[] args) {
//        int num = 1024;
//        int targer = 1;
//        Main2.help(num,targer);
//    }
    public static void help(long num, long target){
        if (num == target) {
            System.out.println(0);
            return;
        }

        int countDelete2 = 0;
        int countAdd2 = 0;
        if (num < target){
            while(num < target){
                num = num*2;
                countAdd2++;
            }
            int countMin = 0;
            if (num == target){
                countMin = countMin + countAdd2/3;
                countAdd2 = countAdd2%3;
                countMin = countMin + countAdd2/2;
                countAdd2 = countAdd2%2;
                countMin = countMin + countAdd2;
                System.out.println(countMin);
            }else{
                System.out.println(-1);
            }
        }else{
            while(num > target){
                if (num%2 != 0){
                    System.out.println(-1);
                    return;
                }
                num = num/2;
                countDelete2++;
            }
            int countMin = 0;
            if (num == target){
                countMin = countMin + countDelete2/3;
                countDelete2 = countDelete2%3;
                countMin = countMin + countDelete2/2;
                countDelete2 = countDelete2%2;
                countMin = countMin + countDelete2;
                System.out.println(countMin);
            }else{
                System.out.println(-1);
            }
        }
    }
}
