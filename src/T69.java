import static java.lang.Math.pow;

/**
 * @author Will
 * @version 1.0
 * @description: 使用了官方题解的方法二：二分查找
 * @date 2020/11/15 22:52
 */
public class T69 {
    public static void main(String[] args) {
        int x = 999;
        T69 test = new T69();
        int result = test.mySqrt(x);
        System.out.println(result);
    }

    public int mySqrt(int x) {
        int low = 0;
        int up = x;
        int mid = (low + up)/2;
        while(mid<=up && mid>=low){

            if( pow(mid,2)<=x && pow(mid+1,2)>x ){
                return mid;
            }else if ( pow(mid,2)<x && pow(mid+1,2)>=x ){
                return mid+1;
            }else if( pow(mid+1,2)<x ){
                low = mid;

            }else if( pow(mid,2)>x ){
                up = mid;
            }

            mid = (low + up)/2;
        }
        return mid;
    }
}
