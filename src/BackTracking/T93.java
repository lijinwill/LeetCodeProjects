package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-10$ $
 */
public class T93 {
    public static void main(String[] args) {
        String s = "0000";
        T93 test = new T93();
        System.out.println(test.restoreIpAddresses(s));
    }
    /*思路：回溯分割，树形结构分割向下
        1、第一层for循环确定每一层点的不同位置，第二层for循环依次确定下一层
     */

    ArrayList<String> result = new ArrayList<>();
    StringBuffer path = new StringBuffer();
    int count = 0;//用于记录.的个数
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12 || s.length()<4) return result;
        backtracking(s,0);
        return result;
    }

    public void backtracking(String s, int startIdx){
        if(startIdx==s.length() && count==4){
            //把最后一个.去掉，因为每次加上去的时候都会把点.加上去;
            path.deleteCharAt(path.length()-1);
            result.add(path.toString());
            //去完后记得加回去
            path.append('.');
        }
        //这层for循环遍历每个节点的不同位置
        for (int i = startIdx; i<s.length(); i++){
            //如果截取的长度大于3，且不再0-255之间，或是0开头，则结束这层循环
            String str = s.substring(startIdx, i+1);
            int strInt = Integer.parseInt(str);
            //这是剪枝的判断操作，(str.charAt(0) == '0' && str.length() != 1)是排除首尾为0但又不是只有0的情况
            if(count>3 || str.length()>3 || strInt > 255 || (str.charAt(0) == '0' && str.length() != 1)){
                break;
            }else{
                //如果截取的长度小于3，且再0-255之间，不以0开头，则加入path
                path.append(str);
                path.append('.');
                count++;
            }

            backtracking(s, i+1);
            path.delete(path.length()-str.length()-1, path.length());
            count--;
        }
    }
}
