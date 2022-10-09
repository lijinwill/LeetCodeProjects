package A_Coding_Test.Huawei_8_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/24 18:57
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(input.readLine());//村民数目

        String s = input.readLine();
        String[] arrS = s.split(" ");
        int[] a = new int[arrS.length];//村名的钱
        for (int i=0; i< arrS.length; i++) {
            a[i] = Integer.parseInt(arrS[i]);
        }
        Arrays.sort(a);

        int n = Integer.parseInt(input.readLine());//捐款数目
        int nPlus = n;
        //思路：先排序，然后从小到大分配n，先分配到下一个人的钱数，如果能相等且还有钱，则继续分配
        //      如果只能分给一个人，则不分配返回1 n;
        int count = 1;
        for (int i=1; i< a.length; i++){
            int delta = a[i] - a[i-1];
            if(delta == 0) {
                count++;
                continue;
            }
            if (delta * i <= nPlus){
                nPlus = nPlus - (delta * i);
                for (int j=0; j<i; j++){
                    a[j] = a[i];
                }
                count++;
            }else{
                break;
            }
        }

        int t;
        for (t=0; t<m-1; t++) {
            if (a[t] != a[t+1]){
                break;
            }
        }
        if (t == m-1 && a[m-1] == a[m-2] && nPlus/m > 0){
            int d = nPlus/m;
            nPlus = nPlus - d * m;
        }


        if (count == 2){
            System.out.println(1 + " " + n);
        }else{
            System.out.println(count + " " + nPlus);
        }

    }
}
