package A_Coding_Test.Microsoft_8_19;

import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/19 18:18
 */
public class T1 {
    public static void main(String[] args) {
        int[] X = {2,3,4,5,6,7,8,9};
        T1 test = new T1();
        System.out.println(test.solution(X,2));
    }
    //思路，从两侧往中间趋近，因为两侧总是要覆盖掉的
    //1、先根据x排序所有点，然后每轮干掉最边缘的点以及x+w和x-w内的点
    //2、不断循环，直到全部的点都被覆盖
    public int solution(int[] X, int W) {
        // write your code in Java 11 (Java SE 11)
        //先把一维数组转为二维数组
        int len = X.length;

        Arrays.sort(X);

        int left = X[0];//表示左边拖拉机的位置
        int right = X[len-1];//表示右边拖拉机的位置
        int curLeft = 0;//表示XY中在左边拖拉机覆盖的最后一个位置
        int curRight = len-1;//表示XY中在右边拖拉机覆盖的最后一个位置

        int count = 0;
        while(curLeft < curRight){
            left = left + W;
            right = right - W;
            for (int i=curLeft; i<len; i++){
                if (X[i] > left) {
                    curLeft = i;
                    break;
                }
            }
            for (int i = curRight; i>=0; i--){
                if (X[i] < right) {
                    curRight = i;
                    break;
                }
            }
            count = count + 2;
        }
        if (curLeft == curRight){
            count++;
        }
        return count;
    }
}
