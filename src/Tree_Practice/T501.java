package Tree_Practice;

import java.util.*;

/**
 * @Classname T501
 * @Description TODO
 * @Date 2022/7/28 14:45
 * @Created by Will
 */
public class T501 {
    //遍历然后用HashMap统计出现的频次，最后返回频次最高的即可

    HashMap<Integer, Integer> hashmap = new HashMap<>();
    public int[] findMode(TreeNode root) {

        inOrder(root);

        //hashmap 降序排序
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(hashmap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        ArrayList<Integer> list = new ArrayList<>();
        int num1 = entryList.get(0).getKey();
        int freq1 = entryList.get(0).getValue();
        list.add(num1);
        for (int i=1; i<entryList.size(); i++) {
            int num_i = entryList.get(i).getKey();
            int freq_i = entryList.get(i).getValue();

            if (freq1 == freq_i) {
                list.add(num_i);
            }else{
                break;
            }
        }

        //转成数组
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public void inOrder(TreeNode root){
        if (root == null) return;

        inOrder(root.left);
        if (hashmap.containsKey(root.val)){
            hashmap.put(root.val, hashmap.get(root.val)+1);
        }else {
            hashmap.put(root.val,1);
        }

        inOrder(root.right);
    }
}
