package Two_dimension_dfs;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/17/2022 5:31 PM
 */
public class T1254 {
    //思路：做过类似的，就是遍历二维数组，碰到0就开始dfs，如果这批0不与边界接触，则是封闭岛
    //     需要设立一个int[][]visited，标记哪些0已经访问过，若访问过就跳过遍历
    public int closedIsland(int[][] grid) {
        int len1 = grid.length;
        int len2 = grid[0].length;
        int count = 0;

        for (int i=0; i<len1; i++){
            for (int j=0; j<len2; j++){
                if (grid[i][j] == 0){
                    if (dfs(grid, i, j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean dfs(int[][] grid, int i, int j){
        //凡是越过了了边界则返回false，因为进入下一轮若越过边界，当前必处在边界上
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return false;
        }
        //如果以1为边界，则返回true
        if (grid[i][j] == 1) return true;

        //已经访问过的节点改为1避免再次访问
        grid[i][j] = 1;
        boolean r1 = dfs(grid, i+1, j);
        boolean r2 = dfs(grid, i, j+1);
        boolean r3 = dfs(grid, i-1, j);
        boolean r4 = dfs(grid, i, j-1);
        return r1 && r2 && r3 && r4;
    }
}
