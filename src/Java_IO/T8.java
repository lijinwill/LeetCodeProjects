package Java_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Will$
 * @version 1.0
 * @description: 这是牛客网第七题IO练习题 https://ac.nowcoder.com/acm/contest/5657/H
 * @date 2022-04-30$ $
 */
public class T8 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int len = input.read();
        String str = input.readLine();
        String[] strs = str.split(" ");
        Arrays.sort(strs);
        for(int i=0; i<len; i++){
            System.out.print(strs[i]);
            if(i != len-1) System.out.println(" ");
        }
    }
}
