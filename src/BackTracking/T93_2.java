package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname T93_2
 * @Description TODO
 * @Date 2022/8/2 21:39
 * @Created by Will
 */
public class T93_2 {
    public static void main(String[] args) {
        String s = "25525511135";
        T93_2 test = new T93_2();
        System.out.println(test.restoreIpAddresses(s));
    }
    //思路：分割问题，类似于组合问题，回溯过程中遇到分割出的子串不在0-255则需要返回
    List<String> path = new ArrayList<>();
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        restoreIpHelp(s);
        return result;
    }

    //由于是遍历不是找路径所以无需返回值
    public void restoreIpHelp(String s){
        if (path.size() > 4) return;
        if (path.size() == 4 && s.length() == 0){
            //因为结果是ip地址，所以需要简单的转换
            StringBuilder sb = new StringBuilder();
            for (String temp : path) {
                sb.append(temp+".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
        }

        for (int i=1; i<=s.length(); i++){
            String leftStr = s.substring(0,i);
            //排除单个0外的0开头的情况
            if (leftStr.length() > 1 && leftStr.charAt(0) == '0') break;
            //排除不在0-255之间的情况
            if ( Integer.parseInt(leftStr) < 0 || 255 < Integer.parseInt(leftStr)){
                break;
            }
            String rightStr = s.substring(i,s.length());
            path.add(leftStr);
            restoreIpHelp(rightStr);
            path.remove(path.size()-1);
        }
    }
}
