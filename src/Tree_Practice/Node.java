package Tree_Practice;
/*
 * @description: 这是N叉树的定义
 * @author Will$
 * @date 2022-04-08$ $
 * @version 1.0
 */

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};