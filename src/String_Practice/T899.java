package String_Practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class T899 {
    public static void main(String[] args) {
        String s = "nhtq";
        int k = 1;
        T899 test = new T899();
        System.out.println(test.orderlyQueue(s,k));
    }

    //思路：k=1的情况暴力解决，k>1的情况直接记住结论，肯定可以排序成升序，则直接排序即可
    public String orderlyQueue(String s, int k) {
        if (k == 1){
            String smallestS = s;
            StringBuffer sb = new StringBuffer(s);
            StringBuffer sbTemp = new StringBuffer(s);
            for (int i=0; i<s.length(); i++){
                char temp = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(temp);

                if (sb.toString().compareTo(smallestS) < 0){
                    smallestS = sb.toString();
                }
            }
            return smallestS;

        }else{
            //这里注意String排序直接转为char[]数组
            char[] sChar = s.toCharArray();
            Arrays.sort(sChar);
            return new String(sChar);
        }
    }
}
