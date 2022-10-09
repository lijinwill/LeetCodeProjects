package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname T131_2
 * @Description TODO
 * @Date 2022/8/1 21:05
 * @Created by Will
 */
public class T131_2 {
    public static void main(String[] args) {
        String s = "efe";
        T131_2 test = new T131_2();
        System.out.println(test.partition(s));
    }
    //思路：分割问题和组合问题本质一致
    List<String> path = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        partitionHelp(s);
        return result;
    }
    public void partitionHelp(String s){
        int len = s.length();
        if (len == 0){
            result.add(new ArrayList<>(path));
        }
        for (int i=1; i<=s.length(); i++){
            String left_s = s.substring(0,i);
            String right_s = s.substring(i,len);
            if (isHuiWen(left_s)){
                path.add(left_s);
                partitionHelp(right_s);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isHuiWen(String str){
        int len = str.length();
        for (int i=0; i<len/2; i++){
            if (str.charAt(i) != str.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}
