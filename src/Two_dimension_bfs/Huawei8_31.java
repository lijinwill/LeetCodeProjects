package Two_dimension_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/31 20:27
 */
public class Huawei8_31 {
    public static void main(String[] args) {
        int[][] grid = {{1,6,2,1},{1,1,0,1},{1,1,0,1},{1,1,0,1},{1,1,0,1},{1,1,0,1},{1,1,0,1},{1,1,3,1}};
        Huawei8_31 test = new Huawei8_31();
        System.out.println(test.shortestPathBinaryMatrix(grid));
    }
    //思路：bfs，有点类似于树的层序遍历，使用queue记录当前节点周围一圈的所有0的位置，
    //     然后for循环遍历queue中记录的这一层0，如果下一层有0，重新计入queue，如果找到0，结束
    //     使用count记录层数，也是最短长度
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        //用于给出一点的4个方位
        int[] xChange = {0,1,0,-1,};
        int[] yChange = {1,0,-1,0,};

        //找出起点坐标
        int startPosX = 0;
        int startPosY = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 2){
                    startPosX = i;
                    startPosY = j;
                }
            }
        }

        //queue中存放的是当前是0的节点的坐标
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startPosX,startPosY});
        int count = 0;
        grid[startPosX][startPosY] = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            //遍历bfs的同一层
            for (int i=0; i<size; i++){
                int[] temp = queue.poll();

                //这个for循环用于访问4个方向
                for (int j=0; j<4; j++){
                    int xx = temp[0] + xChange[j];
                    int yy = temp[1] + yChange[j];
                    if (xx>=0 && xx<rowLen && yy>=0 && yy<colLen && (grid[xx][yy] == 0 || grid[xx][yy] == 3)){
                        if(grid[xx][yy] == 3 ) return count;
                        queue.offer(new int[]{xx,yy});
                        grid[xx][yy] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
