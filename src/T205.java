import java.util.HashMap;
import java.util.Map;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2021/7/26 17:07
 */
public class T205 {

    public static void main(String[] args) {
        String s = "agg";
        String t = "add";
        boolean result = isIsomorphic(s,t);
        System.out.println(result);
    }


    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> s2t = new HashMap<>();
        Map<Character,Character> t2s = new HashMap<>();

        int i = 0;
        while(i < s.length()){
            char x = s.charAt(i);
            char y = t.charAt(i);

            if ( (s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x) ){
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);

            i++;
        }

        return true;
    }
}
