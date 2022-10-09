import java.util.Arrays;

public class T42 {
    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
        T42 test = new T42();
        System.out.println(test.trap(height));
    }

    /*思路：将数组转为二维矩阵，然后横向遍历
    1、先将数组转为二维int[][]矩阵，宽度为height.length()，高度为heigth的最大值
    2、第一重循环竖向从底部向上遍历，第二重横向从左往右，需要先经过1，在经过0，再经过1的才算是雨水。
*/
    public int trap(int[] height) {
        int len = height.length;//表示数组横向长度
        int[] sorted = Arrays.copyOf(height,len);
        Arrays.sort(sorted);//排序的目的是找出最大值，作为二维矩阵的高度
        int highest = sorted[len-1];

        //生成二维矩阵并对其赋值
        boolean[][] two_dim = new boolean[highest][len];
        for(int j=0; j<len; j++){
            for(int i=0; i<height[j]; i++){
                two_dim[i][j] = true;
            }
        }
        int count = 0;
        //从底向上遍历行
        for(int i=0; i<highest; i++){
            //从左向右遍历列
            for(int j=0; j<len-1; j++){
                if(two_dim[i][j] == true && two_dim[i][j+1] == false){
                    for(int k=j+1; k<len; k++){
                        if(two_dim[i][k] == true){
                            count = count + k - j - 1;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}
