package A_Coding_Test.ShunFeng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/31 17:47
 */
public class Main111 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        Long n = Long.parseLong(input.readLine());
        Long result = 1 + n*(n-1)/2;
        System.out.println(result);
    }
}
