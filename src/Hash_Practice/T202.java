package Hash_Practice;

import java.util.HashSet;

/**
 * @Classname T202
 * @Description TODO
 * @Date 2022/7/6 19:32
 * @Created by Will
 */
public class T202 {
    public static void main(String[] args) {
        T202 test = new T202();
        System.out.println(test.isHappy(103));
    }

    //用hashset判断一个数计算快乐数的过程中，是否会重复出现某些数
    public boolean isHappy(int n) {
        HashSet<Integer> hashset = new HashSet<>();

        int sum = 0;

        while(n != 1 && !hashset.contains(n)){
            hashset.add(n);
            //这个用来做快乐数的一次运算
            while(n>0){
                int temp = n%10;
                sum = sum + temp*temp;
                n = n/10;
            }
            n = sum;
            sum = 0;
        }
        if (n == 1){
            return true;
        }else{
            return false;
        }
    }
}
