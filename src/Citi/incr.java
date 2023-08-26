package Citi;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/10/25 15:20
 */

public class incr{
    public static void main(String args[]) {
        int i,j;
        i = j = 3;
        int n = 2 * ++i;
        int m = 2 * j++;
        System.out.println(i +"" + j + "" + n + "" + m);
    }
}