/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/2 22:37
 */
public class T509 {
    public static void main(String[] args) {
        System.out.println(T509.fib(0));
    }
    public static int fib(int N) {
        if (N==1){
            return 1;
        }

        int pre = 0;
        int cur = 1;

        int sum = 0;
        for (int i = 1; i < N; i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;

    }
}
