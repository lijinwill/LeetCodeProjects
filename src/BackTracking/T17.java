package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-05$ $
 */
public class T17 {
    public static void main(String[] args) {
        String digits = "23";
        T17 test = new T17();
        System.out.println(test.letterCombinations(digits));
    }
    /*思路：当成一个树去回溯，因为本题每一个数字代表的是不同集合，也就是求不同集合之间的组合，
            而77. 组合 (opens new window)和216.组合总和III (opens new window)都是是求同一个集合中的组合！

     */
    List<String> result = new ArrayList<>();
    StringBuffer path = new StringBuffer();

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if(len == 0) return result;

        HashMap<Character, String> mapping = new HashMap<>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");

        backtrack(mapping, digits, 0);

        return result;
    }

    //digits是类似于“234”，idx表示遍历的层数
    public void backtrack(HashMap<Character,String> mapping, String digits, int idx){
        //退出条件，当遍历到最后一层
        if(path.length() == digits.length()){
            result.add(path.toString());
            return;
        }
        //这个表示当前遍历的数字（即当前层）对应的字符串
        String str = mapping.get(digits.charAt(idx));
        //这个for循环遍历树的一层中的所有元素
        for(int i = 0; i<str.length(); i++){
            path.append(str.charAt(i));
            //去下一层
            backtrack(mapping, digits, idx+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
