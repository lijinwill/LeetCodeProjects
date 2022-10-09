package Array_Practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/16/2022 1:59 PM
 */
public class T554 {
    public static void main(String[] args) {
        int[][] wall = {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
        T554 test = new T554();
        System.out.println();
    }
    //思路：第一步先统计出每一行的累加数组，例如{1,2,2,1}转换成{1,3,5}，这里把最右侧的省略，因为最右侧是边缘
    //     这些数字出现的位置就是缝隙的位置，然后统计数字所有行中出现最多的那个数字为notBreak，就计算出不用穿墙的次数
    //     然后总的行数减去notBreak，就是需要的break的数量
    public int leastBricks(List<List<Integer>> wall) {
        //这里可以边计算边统计，可以用HashMap记录缝隙与对应的出现次数
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i=0; i<wall.size(); i++){
            //list表示wall中的一行，sum表示前面元素的和
            List<Integer> list = wall.get(i);
            int sum = 0;
            for (int j=0; j<list.size()-1; j++){
                sum = sum + list.get(j);
                //val2表示hashmap中,val1对应的出现次数
                int freq = hashmap.getOrDefault(sum,0)+1;
                hashmap.put(sum,freq);
            }
        }

        //找出hashmap中出现次数最多的那个freq
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> entries : hashmap.entrySet()) {
            maxFreq = Math.max(maxFreq,entries.getValue());
        }
        return wall.size()-maxFreq;
    }
}
