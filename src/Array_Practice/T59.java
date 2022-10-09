package Array_Practice;

/**
 * @Classname T59
 * @Description TODO
 * @Date 2022/7/5 10:50
 * @Created by Will
 */
public class T59 {
    public static void main(String[] args) {
        int n = 5;
        T59 test = new T59();
        System.out.println(test.generateMatrix(n));

    }
    /*思路：
        1、注意边界，左闭右开，即每个子for循环不包含该行的最后一个元素
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        //这个loop表示现在是第几圈了
        int loop = 0;
        int cur = 1;
        while(loop < n/2){

            for(int j=loop; j<n-loop-1; j++){
                result[loop][j] = cur++;
            }
            for(int i=loop; i<n-loop-1; i++){
                result[i][n-loop-1] = cur++;
            }
            for(int j=n-loop-1; j>loop; j--){
                result[n-loop-1][j] = cur++;
            }
            for(int i=n-loop-1; i>loop; i--){
                result[i][loop] = cur++;
            }
            loop++;
        }
        //如果loop是奇数，则最中心的位置需要补一个
        if(n%2 == 1){
            result[n/2][n/2] = n*n;
        }
        return result;
    }
}
