package A_Coding_Test.JD_8_27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/8/27 20:33
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int time = a/3;
        int t=2;
        while(t<time){
            List<Integer> list = new ArrayList<>();
            for (int i = 2; i <= a/3; i++) {
                for (int k=0; k<i; k++){
                    list.add(3);
                }
                for (int j = 0; j < a-a*i; j++) {
                    list.add(1);
                }
            }
            int[] res = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                res[i] = list.get(i);
            }
        }
        System.out.println();
    }

    int count=0;
    List<Integer> path = new ArrayList<>();
    public int permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);

        return count % (1000000000+7);
    }
    public void backtracking(int[] nums, boolean[] used){
        if(path.size() == nums.length){
            count++;
        }

        //注意这个哈希集只在每一层起作用，因此定义在递归里面的for循环前面
        HashSet<Integer> hashset = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(used[i] == false && path.size()<nums.length && hashset.contains(nums[i])==false){
                hashset.add(nums[i]);
                path.add(nums[i]);
                used[i] = true;
            }else{
                continue;
            }
            backtracking(nums,used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
