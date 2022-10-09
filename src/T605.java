/**
 * @author Will
 * @version 1.0
 * @description: 区别对待 初始、末尾为0 与 中间那种两边为1 的情况
 * @date 2020/12/16 14:36
 */
public class T605 {
    public static void main(String[] args) {
        int[] flowerbed = new int[]{0};
        int n = 1;
        System.out.println(T605.canPlaceFlowers(flowerbed, n));

    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        //处理全是0的情况
        int flag = 0;
        for (int i=0; i<len; i++){
            if (flowerbed[i] == 1){
                flag = 1;
            }
        }
        if (flag == 0){
            return (len+1)/2 >= n ? true:false;
        }

        int count_flower = 0;

        //处理中间有1的情况
        //分别数出两边的零的数量,并分别考虑
        int count_edge_left = 0;
        int count_edge_right = 0;
        for (int i = 0; flowerbed[i] != 1; i++) {
            count_edge_left++;
        }
        for (int i = len-1; flowerbed[i] != 1; i--) {
            count_edge_right++;
        }

        count_flower = count_flower + count_edge_left/2;
        count_flower = count_flower + count_edge_right/2;


        int count_middle = 0;
        for (int i = count_edge_left+1; i < len-count_edge_right; i++) {
            if (flowerbed[i] == 0){
                count_middle++;
            }else{
                count_flower = count_flower + (count_middle-1)/2;
                count_middle = 0;
            }
        }

        return count_flower >= n ? true:false;
    }
}
