package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname T17_2
 * @Description TODO
 * @Date 2022/7/30 13:26
 * @Created by Will
 */
public class T17_2 {
    List<String> result = new ArrayList<>();
    StringBuffer path = new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        HashMap<Character, String> hashmap = new HashMap<>();
        hashmap.put('2',"abc");
        hashmap.put('3',"def");
        hashmap.put('4',"ghi");
        hashmap.put('5',"jkl");
        hashmap.put('6',"mno");
        hashmap.put('7',"pqrs");
        hashmap.put('8',"tuv");
        hashmap.put('9',"wxyz");

        letterCombHelp(digits, hashmap, 0);
        return result;
    }

    public void letterCombHelp(String digits, HashMap<Character, String> hashmap, int idx){
        if (path.length() > digits.length()) return;
        if (path.length() == digits.length()){
            result.add(path.toString());
            return;
        }
        //当前层的String，
        String temp = hashmap.get(digits.charAt(idx));
        for (int i = 0; i<temp.length(); i++){
                path.append(temp.charAt(i));
                letterCombHelp(digits, hashmap, idx+1);
                path.deleteCharAt(path.length()-1);

        }
    }
}
