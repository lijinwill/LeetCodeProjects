package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-07$ $
 */
public class T131 {
    public static void main(String[] args) {
        String s = "efe";
        T131 test = new T131();
        System.out.println(test.partition(s));
    }

    /*思路：分割问题可以等同于组合问题来做（参考代码随想录那幅图）
        递归用来纵向遍历，for循环用来横向遍历，切割线（就是图中的红线），
        切割到字符串的结尾位置，说明找到了一个切割方法。
    */
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return result;
    }
    //每次传入的还是完整的String s，就是分割的位置也要往下传
    //一旦出现不是回文串的情况就直接剪枝去掉
    public void backtracking(String s, int startIdx){
        if(startIdx == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //注意截取的是startIdx到i位置的子串，for中横向遍历的时候startIdx不变，结尾位置i+1不断改变
        //递归向下的时候startIdx根据前一个子串的结尾位置i右移1位
        for (int i=startIdx; i<s.length(); i++){
            if(isPalindrome(s.substring(startIdx,i+1))){
                path.add(s.substring(startIdx, i+1));
            }else{
                //这里的意思是如果前面都不是回文串，则直接跳过后面的判断，进入i+1的下一次循环
                continue;
            }
            backtracking(s, i+1);
            path.remove(path.size()-1);
        }
    }
    //用于判断子串是否是回文串
    public boolean isPalindrome(String str){
        int len = str.length();
        if (len == 1) return true;
        int i;
        for(i=0; i<len/2; i++){
            if(str.charAt(i) != str.charAt(len-i-1)) break;
        }

        if (i != len/2){
            return false;
        }else{
            return true;
        }
    }
}
