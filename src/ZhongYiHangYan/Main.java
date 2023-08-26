package ZhongYiHangYan;

import java.util.Scanner;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/10/14 15:54
 */
public class Main {
    public static void main(String[] args){
        Scanner br = new Scanner(System.in);
        int n = br.nextInt();

        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 1; i <= n; ++i) {
            a = b;
            b = c;
            c = a + b;
        }

        System.out.println(c);
    }
}
