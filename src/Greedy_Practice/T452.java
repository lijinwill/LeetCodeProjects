package Greedy_Practice;

import java.util.Arrays;
import java.util.Comparator;

public class T452 {
    public static void main(String[] args) {
        int[][] points = new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        //int[][] points = new int[][]{{-2147483646,-2147483645}, {2147483646,2147483647}};
        T452 test = new T452();
        System.out.println(test.findMinArrowShots(points));
    }

    /**
     * 思路：找出全部不相交的区间就行了，因为相交的区间都能被一针射掉
     *      1、先根据左区间对数组排序，
     *      2、遍历排序后的区间，找出全部不相交的区间，统计个数就是答案
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if(points.length == 1) return 1;

        int result = 1;
        Arrays.sort(points, (o1, o2) -> {
            if(o1[0] > o2[0]){
                return 1;
            }else if (o1[0] < o2[0]){
                return -1;
            }else{
                return 0;
            }
        });

        for(int i=1; i<points.length; i++){
            //如果不重叠，则所需的针肯定+1
            if(points[i-1][1] < points[i][0]){
                result++;
            }else{
                //如果重叠，则修改当前的右区间为左侧的那个右区间和当前右区间的较小者
                points[i][1] = Math.min(points[i-1][1],points[i][1]);
            }
        }

        return result;
    }
}
