package Array_Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/16/2022 3:49 PM
 */
public class T731 {
    //和单区间的T729类似，区别是需要维护两个list，一个list1存覆盖过一次的区间，另一个list2存覆盖过两次的区间
    //   加入区间时，先查找覆盖过两次的区间是否有重合，如果有，返回false； 如果没有，再查找覆盖一次的区间；
    //   如果没有和覆盖一次的区间重合，直接加入list1；如果有重合，将重合部分加入list2，剩余部分加入list1

    List<int[]> list1;
    List<int[]> list2;
    public T731() {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        //先查覆盖两次的区间
        for (int i=0; i<list2.size(); i++){
            int left2 = list2.get(i)[0];
            int right2 = list2.get(i)[1];
            if (left2 < end && start < right2){
                //这是重合的情况，存在三重覆盖直接return false
                return false;
            }
        }
        //在查询一次覆盖区间是否有重合
        int i=0;
        for (i=0; i<list1.size(); i++){
            int left1 = list1.get(i)[0];
            int right1 = list1.get(i)[1];
            if (left1 < end && start < right1){
                //这是重合的情况，存在二重覆盖，二重覆盖添加到list2
                //注意此处无需更新一重覆盖区域，因为更新完二重区间后，接下来的区间能执行到这一步的
                // 必定是不会有二重覆盖的，只能没覆盖或一重覆盖。只需更新二重即可。
                list2.add(new int[]{Math.max(left1,start), Math.min(right1,end)});
            }
        }
        //如果一次覆盖区间全不重合，则直接加入list1
            list1.add(new int[]{start,end});
            return true;
    }
}
