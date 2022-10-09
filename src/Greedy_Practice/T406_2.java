package Greedy_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/14/2022 9:43 PM
 */
public class T406_2 {
    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        T406_2 test = new T406_2();
        System.out.println( test.reconstructQueue(people) );
    }
    //思路：将数组按照身高从大到小排列，同身高下再按第二位升序排列
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o2[0] - o1[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] p : people){
            list.add(p[1],p);
        }
        return list.toArray(new int[list.size()][]);
    }
}
