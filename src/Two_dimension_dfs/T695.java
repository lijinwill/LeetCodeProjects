package Two_dimension_dfs;

public class T695 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{0,0,1,0,0,0,0,1,0,0,0},
                                    {0,0,0,0,0,0,0,1,1,1,0},
                                    {0,1,1,0,1,0,0,0,0,0,0},
                                    {0,1,0,0,1,1,0,0,1,0,1},
                                    {0,1,0,0,1,1,0,0,1,1,1},
                                    {0,0,0,0,0,0,0,0,0,0,1},
                                    {0,0,0,0,0,0,0,1,1,1,0},
                                    {0,0,0,0,0,0,0,1,1,0,0}};
        T695 test = new T695();
        System.out.println(test.maxAreaOfIsland(grid));
    }

    int totalLen = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int len_x = grid.length;
        int len_y = grid[0].length;

        int[][] grid_copy = grid;

        int resultLen = 0;
        int area = 0;
        for(int i=0; i<len_x; i++){
            for(int j=0; j<len_y; j++){
                if(grid[i][j] == 1){
                    totalLen = 0;
                    int areaDFS = DFS(i,j,grid_copy);
                    if (areaDFS >= area){
                        area = areaDFS;
                        resultLen = Math.max(resultLen,totalLen);
                    }
                }
            }
        }
        return resultLen;
    }

    public int DFS(int i, int j, int[][] grid_copy){
        if(i<0 || j<0 || i>=grid_copy.length || j>=grid_copy[0].length || grid_copy[i][j]==0 || grid_copy[i][j]==2){
            return 0;
        }
        if(grid_copy[i][j] == 1){
            grid_copy[i][j] = 2;
            //统计当前点周围点是0或边界的个数
            int sumOfNeibour0 = 0;
            //当前点下方侧是1
            if (i+1 == grid_copy.length || grid_copy[i+1][j]==0){
                sumOfNeibour0++;
            }
            //当前点上方是1
            if (i-1 == -1 || grid_copy[i-1][j]==0){
                sumOfNeibour0++;
            }
            //当前点左方是1
            if (j-1 == -1 || grid_copy[i][j-1]==0){
                sumOfNeibour0++;
            }
            //当前点左方是1
            if (j+1 == grid_copy[0].length || grid_copy[i][j+1]==0){
                sumOfNeibour0++;
            }
            totalLen = totalLen + sumOfNeibour0;
        }

        int count = 1;
        count = count + DFS(i+1, j, grid_copy);
        count = count + DFS(i-1, j, grid_copy);
        count = count + DFS(i, j-1, grid_copy);
        count = count + DFS(i, j+1, grid_copy);

        return count;
    }
}
