package ListNode_Practice;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/15/2022 3:07 PM
 */
public class T61 {
    //思路：先计算链表长度len，最后需要移动的次数k = k%len;
    //      移动位置计算，一边是head，另一边是len-k，交换这两个位置即可
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode p = head;
        ListNode newHead;
        ListNode tail = head;//记录最后一个节点的指针
        int len = 0;

        //统计链表长度，顺便找到尾节点位置
        while(p != null){
            if (p.next == null){
                tail = p;
            }
            p = p.next;
            len++;
        }
        //简单处理掉重复
        int kPlus = k%len;
        if (kPlus == 0) return head;
        //找出断开位置的上一个节点
        int count=0;
        p = head;
        while(count < len-kPlus-1){
            p = p.next;
            count++;
        }
        //修改next
        tail.next = head;
        head = p.next;
        p.next = null;

        return head;
    }
}
