import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2021/7/26 21:30
 */
public class T599 {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] result = T599.findRestaurant(list1,list2);
        System.out.println(Arrays.toString(result));
    }


    //思路：以一个数组为基点，遍历另一个数组，如果遇到相同的，就把两者的坐标存入HashMap中，直到遍历结束；
    //      两个数组都遍历结束后，遍历HashMap，得到最小的索引和
    public static String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<Integer,Integer> my_hashmap = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if ( list1[i].equals( list2[j]) ){
                    my_hashmap.put(i,j);
                }
            }

        }
        int max = 0;
        int count = 0;
        int[] pos={0};
        for (Map.Entry<Integer, Integer> entry : my_hashmap.entrySet()) {
            if ( max <= ( entry.getKey() + entry.getValue())){
                max = ( entry.getKey() + entry.getValue() );
                pos[count++] = entry.getKey();
            }

        }

        String[] result = new String[count];
        for (int i = 0; i < pos.length; i++) {
            result[i] = list1[i];
        }

        return result;
    }


}
