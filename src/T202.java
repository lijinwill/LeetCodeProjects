import java.util.HashSet;

import static java.lang.Math.pow;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2021/7/24 19:32
 */
public class T202 {

    public static void main(String[] args) {
        int test = 19;
        boolean result = T202.isHappy(test);
        System.out.println(result);
    }



    public static boolean isHappy(int n) {
        HashSet<Integer> mySet = new HashSet<Integer>();
        int next = cal_next(n);
        while( next != 1 ){
            if( !mySet.contains(next) ){
                mySet.add(next);
            }else{
                return false;
            }
            next = cal_next(next);
        }

        return true;
    }

    private static int cal_next(int n){
        int sum = 0;
        while(n != 0){
            sum = (int) (sum + pow( (n%10),2 ));
            n = n/10;
        }
        return sum;
    }


}

