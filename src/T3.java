import java.util.HashSet;
import java.util.Set;

public class T3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        T3 test = new T3();
        System.out.println(test.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return 0;
        if(len == 1) return 1;

        Set<Character> hashset = new HashSet<>();
        hashset.add(s.charAt(0));
        int l = 0;//左指针
        int r = 1;//右指针
        int count = 1;
        int max_len = 1;
        while (r < len){
            char l_char = s.charAt(l);
            char r_char = s.charAt(r);
            //如果右侧不在hashset中，则右移r指针，count++
            if (!hashset.contains(r_char)){
                hashset.add(r_char);
                r++;
                count++;
                max_len = Math.max(max_len, count);
            }else{  //如果右侧在hashset中，移除最左元素，左移左指针，count--
                hashset.remove(l_char);
                l++;
                count--;
            }
        }
        return max_len;
    }

}
