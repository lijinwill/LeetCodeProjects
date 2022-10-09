package String_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-04-25$ $
 */
public class T438 {
    public static void main(String[] args) {
        String s = "aa";
        String p = "bb";
        T438 test = new T438();
        System.out.println(test.findAnagrams(s,p));
    }
    /*思路：滑动窗口，重点在于比较是否是易位词，可以通过int[]数组统计好每个字母出现的频次
        1、统计p中字符出现的频次p_freq
        2、建立滑动窗口，统计窗口的字符串出现频次，并与p_freq比较
        3、记录频次相同的窗口位置，
     */

    public List<Integer> findAnagrams(String s, String p) {
        int s_len = s.length();
        int p_len = p.length();
        List<Integer> result = new ArrayList<>();
        if (s_len < p_len) return result;
        int[] p_freq = new int[26];
        int[] s_freq = new int[26];

        //统计p的词频
        for(int i=0; i<p_len; i++){
            p_freq[p.charAt(i)-'a'] += 1;
        }
        //统计s中滑动窗口的词频
        int i;
        for(i=0; i<s_len; i++) {
            if (i < p_len) {
                s_freq[s.charAt(i) - 'a'] += 1;
            } else {
                if (Arrays.equals(s_freq, p_freq)){
                    result.add(i - p_len);
                }
                s_freq[s.charAt(i) - 'a'] += 1;
                s_freq[s.charAt(i - p_len) - 'a'] -= 1;
            }
        }
        if (Arrays.equals(s_freq, p_freq)){
            result.add(i - p_len);
        }

        return result;
    }
}
