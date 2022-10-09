package ListNode_Practice;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/15/2022 4:46 PM
 */
public class T92 {
    //思路：先定位到开始反转的位置，然后用全链表反转的方法将其反转
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //1个节点或是left==right的情况先排除
        if (head.next == null || left==right) return head;

        //注意这里为了覆盖全部可能的开始位置，需要设置dummyHead
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        head = dummyHead;

        ListNode curPre = head;
        ListNode cur1 = head.next;
        ListNode cur2 = head.next.next;
        int pos = 1;//用于记录当前处理到的位置
        while(pos < right){
            if (pos < left){
                //寻找初始位置
                curPre = curPre.next;
                cur1 = cur1.next;
                cur2 = cur2.next;
                pos++;

            }else{
                //调整节点next
                cur1.next = cur2.next;
                cur2.next = curPre.next;
                curPre.next = cur2;
                //后移
                cur2 = cur1.next;
                pos++;
            }
        }
        return head.next;
    }
}
