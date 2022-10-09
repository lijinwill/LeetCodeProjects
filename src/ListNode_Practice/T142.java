package ListNode_Practice;

import java.util.HashSet;

/**
 * @Classname T142
 * @Description TODO
 * @Date 2022/7/6 15:18
 * @Created by Will
 */
public class T142 {
    //思路：用一个HashSet存ListNode，如果.next存在于HashSet中，则返回该节点
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashset = new HashSet<>();

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = new ListNode();
        p = dummyHead;
        while(p != null){
            if (!hashset.contains(p.next)){
                hashset.add(p.next);
                p = p.next;
            }else{
                return p.next;
            }
        }
        return null;
    }
}
