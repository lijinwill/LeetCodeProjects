package A_Coding_Test.Bilibili;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/1 18:58
 */
public class Main {
        public static void main(String[] args) {
            int num = 64 * 64;
            Main test = new Main();
            System.out.println(test.help(num));
        }
        public int help(int num){
            //如果不是素数就往下执行
            if (Sushu(num)){
                return num;
            }
            int min = num;
            int break1 = 0;
            int break2 = 0;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                int temp = num/i;
                if (temp * i == num && min > temp+i){
                    min = temp+i;
                    break1 = i;
                    break2 = temp;
                }
            }
            //如果无法缩小，返回原值，如果可以继续缩小，返回两者加和
            if (min == num){
                return num;
            }else {
                return help(break1) + help(break2);
            }
        }

        //判断素数
        public boolean Sushu(int n){
            for (int i = 2; i <= Math.sqrt(n); i++) {
                int temp = n/i;
                if (temp * i == n){
                    return false;
                }
            }
            return true;
        }
}
