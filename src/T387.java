import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/23 13:49
 */
public class T387 {
    public static void main(String[] args) {
        String s = "cc";
        System.out.println(T387.firstUniqChar(s));
    }
    public static int firstUniqChar(String s) {
        int len = s.length();

        byte[] bytes = s.getBytes();
        Arrays.sort(bytes);


        return -1;
    }
}
