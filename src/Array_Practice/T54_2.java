package Array_Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname T54_2
 * @Description TODO
 * @Date 2022/7/3 15:23
 * @Created by Will
 */
public class T54_2 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        T54_2 test = new T54_2();
        System.out.println(test.spiralOrder(matrix));

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int len_x = matrix.length;
        int len_y = matrix[0].length;
        //记录现在访问到第几圈，这个第几圈由长宽中的较小者决定
        int loop = 0;
        List<Integer> result = new ArrayList<>();

        //这个与第56题不同的是这个要左开右闭
        while(loop <= Math.min(len_x,len_y)/2){
            for (int j=loop; j<len_y-loop; j++){
                result.add(matrix[loop][j]);
                if (result.size() == len_x*len_y) return result;
            }
            for (int i=loop+1; i<len_x-loop; i++){
                result.add(matrix[i][len_y-loop-1]);
                if (result.size() == len_x*len_y) return result;
            }
            for (int j=len_y-loop-2; j>=loop; j--){
                result.add(matrix[len_x-loop-1][j]);
                if (result.size() == len_x*len_y) return result;
            }
            for (int i=len_x-loop-2; i>loop; i--){
                result.add(matrix[i][loop]);
                if (result.size() == len_x*len_y) return result;
            }
            loop++;
        }
        if (len_x == len_y){
            result.add(matrix[len_x/2][len_y/2]);
        }
        return result;
    }
}
