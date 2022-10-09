package A_Coding_Test.ShunFeng;

import A_Coding_Test.XieCheng.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/31 15:43
 */
public class Main1 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(input.readLine());
//        Main1.Help(n);
//    }
    public static void main(String[] args) {
        int n = 5;
        Main1.Help(n);
    }
    public static void Help(int n){
        int max = n;
        int min = 1;
        int mid = (max+min)/2;
        int count = 0;
        while(mid != n){
            if (mid > n){
                max = mid-1;
                mid = (max+min)/2;
                count++;
            } else if (mid < n) {
                min = mid + 1;
                mid = (max+min)/2;
                count++;
            }else{
                System.out.println(count);
                return;
            }
        }
        System.out.println(count);
        return;
    }
}
