package A_Coding_Test.Lenovo_8_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/21 14:21
 */
public class T1 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(input.readLine());


        String SA = input.readLine();
        String[] ArrSA = SA.split(" ");
        String SB = input.readLine();
        String[] ArrSB = SB.split(" ");

        T1 test = new T1();
        test.Help(len, ArrSA, ArrSB);
    }
    public void Help(int len, String[] ArrSA, String[] ArrSB){
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < len; i++) {
            if (ArrSA[i].equals("Rock") && ArrSB[i].equals("Scissor")){
                countA++;
            }
            if (ArrSA[i].equals("Paper") && ArrSB[i].equals("Rock")){
                countA++;
            }
            if (ArrSA[i].equals("Scissor") && ArrSB[i].equals("Paper")){
                countA++;
            }
            if (ArrSB[i].equals("Rock") && ArrSA[i].equals("Scissor")){
                countB++;
            }
            if (ArrSB[i].equals("Paper") && ArrSA[i].equals("Rock")){
                countB++;
            }
            if (ArrSB[i].equals("Scissor") && ArrSA[i].equals("Paper")){
                countB++;
            }
        }
        System.out.println(countA+" "+countB);
    }
}
