package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-04-22$ $
 */
public class T973 {
    public static void main(String[] args) {
        int[][] points = new int[][]{{1,3}, {-2,2}};
        int k = 1;
        T973 test = new T973();
        System.out.println(test.kClosest(points, k));
    }
    /*思路1、另外建一个int[][]，其中存放points的次序与距离原点的距离
            建立一个存放[pos,dist]元素的大根堆，存放最近的k个点
            然后输出大根堆到int[][]

    */
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        int[][] result = new int[k][2];

        //此变量存储points的位置与到原点距离
        int[][] pos_dist = new int[len][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for(int i=0; i<len; i++){
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            if(maxHeap.size() < k){
                maxHeap.offer(new int[]{i,dist});
            }else{
                if(maxHeap.peek()[1] > dist){
                    maxHeap.poll();
                    maxHeap.offer(new int[]{i, dist});
                }
            }
        }
        int i = 0;
        while(maxHeap.size() > 0){
            result[i++] = points[maxHeap.poll()[0]];
        }
        
        return result;
    }
}
