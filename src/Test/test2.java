package Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/10/16 13:15
 */
public class test2 {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(3,5,1,4,7,2,3);
        StringBuilder str = new StringBuilder();
        arr.stream().filter(t -> t>3).forEach(s->{
            str.append(s);
        });
        System.out.println(str);
    }
}
