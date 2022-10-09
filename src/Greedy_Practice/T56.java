package Greedy_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56 {
    /*思路：先按左边界排序，然后比较右边界
    如果当前右边界小于下一个的左边界，则两者加入result；
    如果当前右边界大于下一个左边界，却小于下一个右边界，则合并两者
    如果当前右边界大于下一个右边界，则抛弃下一个元素。
*/
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        T56 test = new T56();
        System.out.println(test.merge(intervals));
    }
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        //这个comparator一定要会背，比较的是两个数组，根据数组的第一位比较
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] interval1, int[] interval2){
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> result = new ArrayList<>(Arrays.asList(intervals));
        for(int i=0; i<result.size()-1; ){
            int one_right =  result.get(i)[1];//前一个的右区间
            int two_left =  result.get(i+1)[0];//后一个的左区间
            int two_right =  result.get(i+1)[1];//后一个的右区间

            if(one_right < two_left){
                i = i + 1;
            }else if(two_left <= one_right && one_right <= two_right){
                result.get(i)[1] = two_right;
                result.remove(i+1);
            }else if(one_right > two_right){
                result.remove(i+1);
            }
        }
        //将List转为数组
        return result.toArray(new int[result.size()][]);
    }
}
