import java.util.Arrays;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/12/16 13:46
 */
public class T455 {
    public static void main(String[] args) {
        //小孩数组
        int[] g = new int[]{1};
        //饼干数组
        int[] s = new int[]{};

        System.out.println(T455.findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int len_g = g.length;
        int len_s = s.length;
        int max_len = Math.max(len_g,len_s);


        Arrays.sort(g);
        Arrays.sort(s);

        int point_g = 0;
        int point_s = 0;

        while (point_g<len_g && point_s<len_s) {
            if (g[point_g] <= s[point_s]){
                point_g++;
                point_s++;
            }else {
                point_s++;
            }
        }

        return point_g;
    }
}
