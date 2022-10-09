package ListNode_Practice;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 8/15/2022 4:44 PM
 */
public class T25 {
    //思路：先写分组的反转，再反复调用
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null || k == 1) return head;
        //先统计链表长度
        int len = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            len++;
        }

        int left = 1;
        int right = k;
        while(right <= len){

            head = reverseBetween(head,left,right);
            left = left + k;
            right = right + k;
        }
        return head;
    }
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
