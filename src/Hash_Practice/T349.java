package Hash_Practice;

import java.util.*;

/**
 * @Classname T349
 * @Description TODO
 * @Date 2022/7/6 17:33
 * @Created by Will
 */
public class T349 {
    public static void main(String[] args) {

    }

    //思路：将一个数组放入HashSet，另一个一个一个对比
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashset1 = new HashSet<>();
        for (int k : nums1) {
            hashset1.add(k);
        }
        HashSet<Integer> hashset2 = new HashSet<>();
        for (int j : nums2) {
            if (hashset1.contains(j)) {
                hashset2.add(j);
            }
        }
        int count = 0;
        int[] result = new int[hashset2.size()];
        for (int i : hashset2) {
            result[count++] = i;
        }
        return result;
    }
}
