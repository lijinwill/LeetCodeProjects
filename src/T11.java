import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2020/11/27 16:40
 */
public class T11 {
    public static void main(String[] args) {
        int[] height = new int[]{};
        int result = T11.maxArea(height);
        System.out.println(result);
    }

    public static int maxArea(int[] height) {

        //方法二：更垃圾！！！
//        //找最大的数
//        IntSummaryStatistics stat = Arrays.stream(height).summaryStatistics();
//        int maxnum = stat.getMax();
//        //数组长度
//        int length = height.length;
//
//        //最大面积
//        int maxArea = 0;
//
//        //i表示从高往低处考虑
//        for (int i = maxnum; i > 0; i--) {
//            //定义一个记录数组，count表示里面有几个数
//            int[] data = new int[]{-1,-1};
//            int count = 0;
//
//            for (int j = 0; j < length; j++) {
//                if (height[j]>=i && data[0]==-1) {
//                    data[0] = j;
//                    continue;
//                }
//                if (height[j]>=i && data[0]!=-1){
//                    data[1] = j;
//                }
//            }
//
//            if (data[1] == -1){
//                continue;
//            }else{
//                int Area = i * ( data[1]-data[0] );
//                maxArea = maxArea>Area ? maxArea:Area;
//            }
//
//        }
//        return maxArea;




        //方法一：暴力的两两遍历，效率太低
        int length = height.length;
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++){
                area = height[i]>height[j] ? height[j]*(j-i) : height[i]*(j-i);
                maxArea = area>maxArea ? area : maxArea;
            }
        }

        return maxArea;
    }
}
