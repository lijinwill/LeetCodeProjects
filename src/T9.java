/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2021/1/16 23:33
 */
/**
 *
 * @description 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true

示例2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Will Li
 * @version
 * @date 2020年11月7日下午4:07:34
 *
 */
public class T9 {

    public static void main(String[] args) {
        T9 test = new T9();
        boolean temp = test.isPalindrome(0);
        System.out.println(temp);

    }

    public boolean isPalindrome(int x) {

        if( x!=0 && (x<0 || x%10 == 0) ) {//负数和个位为0的数一定不是回文数，首先排除
            return false;
        }

        if( reverse(x) == x) {
            return true;
        }else {
            return false;
        }

    }

    //这里利用第七题的方法先反转整数
    public int reverse(int y) {
        long n = 0;
        while(y != 0) {
            n = n*10 + y%10;
            y = y/10;
        }
        return ((int)n == n)? (int)n : 0;
    }
}

