package Two_dimension_bfs;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/18/2022 7:10 PM
 */
public class T1091 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        T1091 test = new T1091();
        System.out.println(test.shortestPathBinaryMatrix(grid));
    }
    //思路：bfs，有点类似于树的层序遍历，使用queue记录当前节点周围一圈的所有0的位置，
    //     然后for循环遍历queue中记录的这一层0，如果下一层有0，重新计入queue，如果找到0，结束
    //     使用count记录层数，也是最短长度
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        //排除掉开头和结尾是1的情况
        if (grid[0][0] == 1 || grid[rowLen-1][colLen-1] == 1) return -1;
        //用于给出一点的8个方位
        int[] xChange = {0,1,0,-1,1,1,-1,-1};
        int[] yChange = {1,0,-1,0,1,-1,1,-1};

        //queue中存放的是当前是0的节点的坐标
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int count = 0;
        grid[0][0] = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            //遍历bfs的同一层
            for (int i=0; i<size; i++){
                int[] temp = queue.poll();
                if(temp[0]==rowLen-1 && temp[1]==colLen-1) return count;

                //这个for循环用于访问8个方向
                for (int j=0; j<8; j++){
                    int xx = temp[0] + xChange[j];
                    int yy = temp[1] + yChange[j];
                    if (xx>=0 && xx<rowLen && yy>=0 && yy<colLen && grid[xx][yy] == 0){
                        queue.offer(new int[]{xx,yy});
                        grid[xx][yy] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
