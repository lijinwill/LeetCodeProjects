package Tree_Practice;
/*
 * @description: 可以模仿二叉树的递归遍历套入树的层序遍历吗？？
 * @author Will$
 * @date 2022-04-08$ $
 * @version 1.0
 */
import Tree_Practice.Node;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T429 {
    public static void main(String[] args) {
        Node root = new Node(3);


        T429 test = new T429();
        System.out.println(test.levelOrder(root));
    }
    
    /*思路：和二叉树的层序遍历是一样的，只是N叉树的访问子节点需要循环
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> level_val = new ArrayList<>();
            while(len > 0){
                Node tempNode = queue.poll();
                level_val.add(tempNode.val);

                for(Node child : tempNode.children){
                    if (child != null) queue.offer(child);
                }
                len--;
            }
            result.add(level_val);
        }
        return result;
    }
}