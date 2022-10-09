package Array_Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Will
 * @version 1.0
 * @description: 设置一个矩阵，记忆访问过的节点，然后按照右->下->左->上的顺序循环遍历原矩阵
 * @date 2020/11/18 17:03
 */
public class T54 {
    public static void main(String[] args) {
        int[][] matrix = {{1}};
        T54 test = new T54();
        List<Integer> result = new ArrayList<>();
        result = test.spiralOrder(matrix);
        System.out.println(result);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int a = matrix[0].length;//表示横向长度
        int b = matrix.length;//表示纵向长度

        int[][] matrix_visited = new int[b][a];//表示已经访问过的矩阵

        List<Integer> list = new ArrayList<>();//输出一维List

        int flag = 1;//取值可能1，2，3，4，表示四个方向
        int x=0, y=0;//表示此时正在遍历的位置

        int i = 0;//计数器，是循环的终止条件！
        while( i<a*b && x<b && y<a){
            if (flag==1){
                list.add(matrix[x][y]);
                i++;
                matrix_visited[x][y] = 1;
                if ((y+1)==a || matrix_visited[x][y+1] == 1){
                    flag = 2;
                    x++;
                    continue;
                }
                y++;

            }else if (flag == 2){
                list.add(matrix[x][y]);
                i++;
                matrix_visited[x][y] = 1;
                if ((x+1)==b || matrix_visited[x+1][y] == 1){
                    flag = 3;
                    y--;
                    continue;
                }
                x++;

            }else if (flag == 3){
                list.add(matrix[x][y]);
                i++;
                matrix_visited[x][y] = 1;
                if ((y-1)==-1 || matrix_visited[x][y-1]==1){
                    flag = 4;
                    x--;
                    continue;
                }
                y--;

            }else if (flag == 4){
                list.add(matrix[x][y]);
                i++;
                matrix_visited[x][y] = 1;
                if (matrix_visited[x-1][y]==1){
                    flag = 1;
                    y++;
                    continue;
                }
                x--;
            }
        }

        return list;

    }
}

