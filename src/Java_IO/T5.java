package Java_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will$
 * @version 1.0
 * @description: 这是牛客网Java IO练习第五题
 * @date 2022-04-30$ $
 */
public class T5 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //这里将char转为String再转为int，读取了第一个数
        int size = Integer.parseInt(input.readLine());
        for(int i=0; i<size; i++){
            //将第二行转为String数组
            String s = input.readLine();
            String[] arr = s.split(" ");
            int sum = 0;
            for(int j=1; i<=Integer.parseInt(arr[0]); j++){
                sum += Integer.parseInt(arr[j]);
            }
            System.out.println(sum);
        }
    }
}
