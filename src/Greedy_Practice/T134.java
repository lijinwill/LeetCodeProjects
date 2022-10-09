package Greedy_Practice;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-05-15$ $
 */
public class T134 {
    public static void main(String[] args) {
//        int[] gas = new int[]{1,2,3,4,5};
//        int[] cost = new int[]{3,4,5,1,2};
//        int[] gas = new int[]{2,3,4};
//        int[] cost = new int[]{3,4,3};
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,1,5,4,2};
        T134 test = new T134();
        System.out.println(test.canCompleteCircuit(gas, cost));
    }

    /*思路：代码随想录方法二
        定义一个剩余rest[]，记录经过这个加油站后的油的变化(为了节约空间其实不用定义数组)
        然后从0处求和restSum和sum，一旦sum<0，表明从当前位置出发油是不够的，出发位置至少是i+1，需要重置sum,然后继续遍历。
        至于为什么要重置，是因为如果前面都是负的，则开始位置必在后面，如果后边全正，表明这次开始求sum的位置是可以开始的位置
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int index = 0;//答案
        int rest;
        int restSum = 0;//记录全部rest[]元素的和，必须大于0才能跑完全程
        int sum = 0;//记录部分sum的和
        for (int i = 0; i < len; i++) {
            rest = gas[i] - cost[i];
            restSum = restSum + rest;
            sum = sum + rest;
            if (sum < 0) {
                index = (i + 1) % len;
                sum = 0;
            }
        }
        if (restSum < 0) return -1;//必须大于0才能跑完全程

        return index;
    }
}
