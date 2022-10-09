package Hash_Practice;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Classname T242
 * @Description TODO
 * @Date 2022/7/6 17:09
 * @Created by Will
 */
public class T242 {
    //String转charArray应该是最简单
    public boolean isAnagram(String s, String t) {
        char[] s_charArray = s.toCharArray();
        char[] t_charArray = t.toCharArray();

        Arrays.sort(s_charArray);
        Arrays.sort(t_charArray);

        return Arrays.equals(s_charArray,t_charArray);
    }
}
