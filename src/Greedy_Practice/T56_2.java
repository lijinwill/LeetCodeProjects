package Greedy_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56_2 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        T56 test = new T56();
        System.out.println(test.merge(intervals));
    }

    /* 思路：
        1、先按照左边界排序，然后与后续比较右边界，当右边界大于后者的左边界时，合并区间，
        2、直到区间不再重复，就写入到list形式的result中
        3、将list形式的result转为int[][]数组形式
    */
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int one_left = result.get(result.size()-1)[0];
            int one_right = result.get(result.size()-1)[1];
            int two_left = intervals[i][0];
            int two_right = intervals[i][1];

            if (one_right < two_left) {
                result.add(intervals[i]);
            } else if (one_right >= two_left && one_right <= two_right) {
                result.remove(result.size()-1);
                result.add(new int[]{one_left, two_right});
            } else if (one_right > two_right) {
                continue;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
