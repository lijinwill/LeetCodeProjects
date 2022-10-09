package Tree_Practice;

import java.util.LinkedList;

/**
 * @Classname T116
 * @Description TODO
 * @Date 2022/7/19 23:43
 * @Created by Will
 */
public class T116 {
    /*思路：层序遍历。当len=1的时候，next指向null，其余的指向下一个Node即可

     */
    public NodeWithNext connect(NodeWithNext root) {
        if (root == null) return root;

        LinkedList<NodeWithNext> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            while(len > 0){
                NodeWithNext tempNode = queue.poll();
                if(len == 1){
                    tempNode.next = null;
                }else{
                    tempNode.next = queue.peek();
                }
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);

                len--;
            }
        }
        return root;
    }
}
