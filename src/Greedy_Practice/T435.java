package Greedy_Practice;

import java.util.Arrays;
import java.util.Comparator;

public class T435 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        T435 test = new T435();
        System.out.println(test.eraseOverlapIntervals(intervals));
    }

    /* 思路：按照右边界排序，从左向右记录非交叉区间的个数。
        最后用区间总数减去非交叉区间的个数就是需要移除的区间个数了。
    */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int right = Integer.MIN_VALUE;
        for (int i=0; i<intervals.length; i++){
            if (right <= intervals[i][0]){
                right = intervals[i][1];
            }else{
                count++;
            }
        }
        return count;
    }
}
