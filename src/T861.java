/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/7 14:30
 */
public class T861 {
    public static void main(String[] args) {
        int[][] test = new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int result = T861.matrixScore(test);
        System.out.println(result);
    }

    public static int matrixScore(int[][] A) {
        int row = A.length;//总行数
        int colume = A[0].length;//总列数
        //先将首数字为0的行反转
        for (int i = 0; i < row; i++) {
            if (A[i][0] == 0){
                for (int j = 0; j < colume; j++) {
                    A[i][j] = A[i][j]>0 ? 0:1;//反转一行
                }
            }
        }

        //再将第二列开始，0多的列反转
        for (int j = 1; j < colume; j++) {
            //先看这一列中是0多还是1多
            int sum = 0;
            for (int i = 0; i < row; i++) {
                if (A[i][j]==1){
                    sum++;
                }
            }
            //如果0多就反转
            if (sum <= row/2){
                for (int i = 0; i < row; i++) {
                    A[i][j] = A[i][j]>0 ? 0:1;
                }
            }

        }

        int result = 0;
        for (int i = 0; i < row; i++) {
            String temp = "";
            for (int j = 0; j < colume; j++) {
                temp = temp + String.valueOf(A[i][j]);

            }
            result = result + Integer.parseInt(temp,2);
        }

        return result;
    }
}
