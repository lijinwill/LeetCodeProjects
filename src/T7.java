/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2021/1/16 23:30
 */

/*
7. 整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:
输入: 123
输出: 321

示例 2:
输入: -123
输出: -321

示例 3:
输入: 120
输出: 21

注意:
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
请根据这个假设，如果反转后整数溢出那么就返回 0。

通过次数505,367提交次数1,455,463
*/


public class T7 {
    public static void main(String[] args) {
        int val1 = -2147483648;
        System.out.println( reverse(val1));
    }

//	  我写的，利用字符串反转
//    public static int reverse(int x) {
//
//    	long a;
//
//    	//这里单独写这个是因为java中的int是2^31-1=2147483647,-2^31=-2147483648
//    	//负数绝对值比正数大一，所以需要单独处理
//    	if(x == -2147483648) {
//    		return 0;
//    	}
//
//    	if(x<0) {
//    		x = -x;
//    		String xstring = Integer.toString(x);
//    		String reverse = new StringBuffer(xstring).reverse().toString();
//
//    		a = -Long.parseLong(reverse);//这里用long是因为2147483647反转后超过了int所能存的范围
//    	}else {
//    		String xstring = Integer.toString(x);
//    		String reverse = new StringBuffer(xstring).reverse().toString();
//
//    		a = Long.parseLong(reverse);
//    	}
//
//    	if( a<-Math.pow(2,31) || a>Math.pow(2, 31)-1 )
//    		return 0;
//
//    	return (int)a;
//    }

    //	别人的回答
    public static int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }

}
