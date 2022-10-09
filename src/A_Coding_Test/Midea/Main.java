package A_Coding_Test.Midea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/28 20:54
 */
public class Main {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "instance", "of", "code", "alignment."};
        int M = 13;
        Main test = new Main();
        test.justifyFill(words,M);
    }
    public ArrayList<String> justifyFill (String[] words, int M) {
        // write code here
        int len = words.length;

        ArrayList<String> result = new ArrayList<>();
        int left=0;
        int right = 0;
        int countLen = 0;//表明字符长度
        while(right < len){
            countLen = countLen + words[right].length();
            //表明单词太多时，需要放入list
            if (countLen > M-1){
                StringBuffer sb = new StringBuffer();

                int trueCountLen = countLen - words[right].length();
                int wordNum = right - left;
                int spaceNum = (M - trueCountLen)/(wordNum-1);
                int spaceRemain = (M - trueCountLen)%(wordNum-1);
                boolean flag = true;
                while(left < right) {
                    sb.append(words[left++]);
                    if (left == right) break;
                    for (int i = 0; i < spaceNum; i++) {
                        sb.append(" ");
                    }
                    if (flag == true){
                        for (int i = 0; i < spaceRemain; i++) {
                            sb.append(" ");
                        }
                        flag = false;
                    }
                }
                result.add(sb.toString());
                countLen = words[right].length();
            }
            right++;
        }

        if (left < right){
            StringBuffer sb2 = new StringBuffer();
            int spaceNum = M - words[left].length();
            sb2.append(words[left]);
            for (int i = 0; i < spaceNum; i++) {
                sb2.append(" ");
            }
            result.add(sb2.toString());
        }

        return result;
    }
}
