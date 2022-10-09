package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Classname T973_2
 * @Description TODO
 * @Date 2022/7/14 21:11
 * @Created by Will
 */
public class T973_2 {
    /*思路：直接计算距离，然后大根堆存放距离最近的前k个点的序号与距离
           然后直接输出大根堆内的坐标
    */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        //直接计算距离，然后大根堆存放距离最近的前k个点的序号与距离
        for (int i=0; i<points.length; i++){
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.offer(new int[]{i, dist});
            if (pq.size() > k){
                pq.poll();
            }
        }
        //直接输出大根堆内的坐标，temp[0]表示某一点在points中的序号
        int[][] result = new int[k][2];
        int i=0;
        for (int[] temp : pq) {
            result[i][0] = points[temp[0]][0];
            result[i][1] = points[temp[0]][1];
            i++;
        }
        return result;
    }
}
