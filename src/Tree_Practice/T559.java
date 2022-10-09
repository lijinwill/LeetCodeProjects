package Tree_Practice;

/**
 * @Classname T559
 * @Description TODO
 * @Date 2022/7/23 22:22
 * @Created by Will
 */
public class T559 {
    //思路：深度优先遍历，每一层都定义了一个用于记录该节点的 孩子节点的最大深度 maxChildDepth，
    //     当统计完 孩子节点 的最大深度后，该节点深度是孩子节点最大深度 + 1；
    //     如果没有孩子，则返回的是自己的深度，即 0+1 = 1
    public int maxDepth(Node root){
        if (root == null) return 0;

        int maxChildDepth = 0;

        for (Node child : root.children) {
            maxChildDepth = Math.max(maxChildDepth, maxDepth(child));
        }
        return maxChildDepth + 1;
    }
}
