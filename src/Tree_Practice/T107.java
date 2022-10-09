package Tree_Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname T107
 * @Description TODO
 * @Date 2022/7/16 20:45
 * @Created by Will
 */
public class T107 {
    //思路：和正向层序遍历一致，只不过最后把Collection.reverse(result)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            //用于临时保存一层的数字
            ArrayList<Integer> tempList = new ArrayList<>();

            while(len > 0){
                TreeNode tempNode = queue.poll();
                len--;
                tempList.add(tempNode.val);

                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
            }
            list.add(tempList);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i-- ) {
            result.add(list.get(i));
        }

        return result;
    }
}
