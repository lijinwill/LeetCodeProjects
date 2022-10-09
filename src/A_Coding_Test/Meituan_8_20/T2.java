package A_Coding_Test.Meituan_8_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/20 10:20
 */
public class T2 {
    //思路：用HashMap<int[],Integer>

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        //位置数组
        int[][] pos = new int[3][2];

        for (int i = 0; i < 3; i++) {
            String s = input.readLine();
            String[] arr = s.split(" ");
            pos[i][0] = Integer.parseInt(arr[0]);
            pos[i][1] = Integer.parseInt(arr[1]);
        }

        //距离数组
        int[] length = new int[3];

        String s = input.readLine();
        String[] arr = s.split(" ");
        for (int i = 0; i < 3; i++) {
            length[i] = Integer.parseInt(arr[i]);
        }

        int[] x = {1, 2, 0, -1, -2, -1, 0, 1};
        int[] y = {1, 0, 2, 1, 0, -1, -2, -1};
        HashMap<int[], Integer> hashmap = new HashMap<>();
        //遍历所有定位装置
        for (int i = 0; i < 3; i++) {
            //遍历所有8个方位，找出所有曼哈顿距离符合的点
            for (int j = 0; j < 8; j++) {
                int xx = pos[i][0] + x[j];
                int yy = pos[i][1] + y[j];
                if (xx >= 1 && xx <= n && yy >= 1 && yy <= n) {
                    int[] beacon = new int[]{xx, yy};
                    int change = hashmap.getOrDefault(beacon, 0);
                    hashmap.put(beacon, change + 1);
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        //遍历hashmap
        for (Map.Entry<int[], Integer> entries : hashmap.entrySet()) {
            if (entries.getValue() == 3) {
                pq.add(entries.getKey());
            }
        }
        int[] result = pq.poll();
        System.out.println(result[0] + " " + result[1]);
    }
}
