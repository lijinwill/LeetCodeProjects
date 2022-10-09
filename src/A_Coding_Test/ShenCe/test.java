package A_Coding_Test.ShenCe;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/30 15:33
 */
public class test {
    public static void main(String[] args) {
        String s = "1......2";
        String[] arr = s.split("\\.");
        for (int i = 0; i < arr.length; i++) {
            int partNum;
            if (arr[i] == ""){
                partNum = 0;
            }else {
                partNum = Integer.parseInt(arr[i]);
            }
            System.out.println(partNum);
        }
    }
}
