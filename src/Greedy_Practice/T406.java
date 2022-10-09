package Greedy_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class T406 {
    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        T406 test = new T406();
        System.out.println( test.reconstructQueue(people) );
    }
    /**
     * 解题思路：先排序再插入
     * 1.排序规则：按照先H高度降序，K升序排序
     * 2.然后根须people[1]插入到一个新的ArrayList中，至于为什么可以直接插进去？
     *      因为先排好 大的 位置，小的 插入进去并不会影响 大的 的k值。
     *
     * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     *
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1]-o2[1];
                return o2[0] - o1[0];
            }
        });

        ArrayList<int[]> list = new ArrayList();
        for (int[] p : people){
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][]);
    }
}
