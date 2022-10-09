package Greedy_Practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Will
 * @version 1.0
 * @description:
 * @date 2022/7/1 17:02
 */
public class T763 {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        T763 test = new T763();
        System.out.println(test.partitionLabels(S));
    }
    /*思路：
        1、建立一个HashMap，遍历String S，记录每个字符出现的最远位置，
        2、再次遍历String S，用一个max_right记录已经遍历的字符中最大的位置，
            比较当前字符的位置是否是最大位置，如果是最大位置时，表明找出分割点
     */
    public List<Integer> partitionLabels(String S) {
        //用于返回的答案
        List<Integer> result = new LinkedList<>();
        // 1、用一个HashMap记录每个字符出现的最右位置
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i=0; i<S.length(); i++){
            char temp_char = S.charAt(i);
            if (!hashmap.containsKey(temp_char)){
                hashmap.put(temp_char,i);
            }else{
                hashmap.put(temp_char, i);
            }
        }

        // 2、再次遍历String S，用一个max_right记录已经遍历的字符中最大的位置，
        //   比较当前字符的位置是否是最大位置，如果是最大位置时，表明找出分割点
        int max_right = 0; //记录右边界，右边界是已经访问过的字符中的最右者
        int left = -1; //记录已经裁剪的左边界。
        for (int i=0; i<S.length(); i++){
            char temp_char = S.charAt(i);
            max_right = Math.max(max_right, hashmap.get(temp_char));
            if (i == max_right){
                result.add(i - left);
                left = i;
            }
        }
        return result;
    }
}
