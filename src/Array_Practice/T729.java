package Array_Practice;

import java.util.ArrayList;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/16/2022 3:10 PM
 */
public class T729 {
    //思路：用一个boolean[]数组记录一个值有没有被占用(超出内存限制，需要另想办法)
    //      用一个ArrayList<int[]>记录全部的占用，然后添加的时候遍历判断是否已经被占用
    ArrayList<int[]> myCal;
    public T729() {
        myCal = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int i;
        for (i=0; i<myCal.size(); i++){
            int left = myCal.get(i)[0];
            int right = myCal.get(i)[1];
            if (right <= start || end <= left){
                continue;
            }else{
                return false;
            }
        }

        myCal.add(new int[]{start,end});
        return true;
    }
}
