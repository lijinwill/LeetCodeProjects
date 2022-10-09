package Greedy_Practice;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/07/02 14:37
 */
public class T738 {
    public static void main(String[] args) {
        int n = 100;
        T738 test = new T738();
        System.out.println(test.monotoneIncreasingDigits(n));
    }
    /*思路：
        1、只要出现charArray[i-1] >= charArray[i]的情况，则charArray[i]-1 且 后面全部改为9
        2、如果已经是单调递增的，则直接返回
     */
    public int monotoneIncreasingDigits(int n) {
        if(n<10) return n;

        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();
        int len = charArray.length;

        for (int i = len-1; i > 0 ; i--) {
            if (charArray[i-1] >= charArray[i]){
                charArray[i-1]--;
                for (int j=len-1; j>=i; j--){
                    charArray[j] = '9';
                }

            }
        }

        return Integer.parseInt(String.valueOf(charArray));
    }
}
