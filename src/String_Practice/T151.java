package String_Practice;

import java.util.HashMap;

/**
 * @Classname T151
 * @Description TODO
 * @Date 2022/7/8 10:21
 * @Created by Will
 */
public class T151 {
    public static void main(String[] args) {
        String s = "     hello world       ";
        T151 test = new T151();
        System.out.println(test.reverseWords(s));
    }
    /*思路：
        1、用split方法分割字符串，新建StringBuilder，反转顺序将单词添加进去
     */
    public String reverseWords(String s) {
        StringBuilder strB = new StringBuilder();

        //注意这里的结果会自动舍弃掉末尾的空格，而且前面的空格分割结果不是“ ”，而是“”
        String[] splitStr = s.split(" ");
        for (int i= splitStr.length-1; i>=0; i--){
            if (splitStr[i] != ""){
                strB.append(splitStr[i]+" ");
            }
        }
        strB.deleteCharAt(strB.length()-1);
        return strB.toString();
    }
}
