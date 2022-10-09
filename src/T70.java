/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/11/16 21:13
 */
public class T70 {

    public static void main(String[] args) {
        int n = 45;
        T70 test = new T70();
        System.out.println(test.climbStairs(n));
    }

    //方法一：递归，用数组记录结果降低计算量
//    public int climbStairs(int n) {
//        int memo[] = new int[n+1];
//        int result = climbStairsMemo(n, memo);
//        return result;
//    }
//    public int climbStairsMemo(int n, int memo[]){
//        if (memo[n]>0){
//            return memo[n];
//        }
//
//        if (n == 1){
//            memo[n] =1;
//        }else if (n == 2){
//            memo[n] = 2;
//        }else if (n > 2){
//            memo[n] = climbStairsMemo(n-1,memo) + climbStairsMemo(n-2,memo);
//        }
//        return memo[n];
//    }

    //方法二：数学方法，Binet's Formula

    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }



}
