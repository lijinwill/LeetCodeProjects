package ListNode_Practice;

/**
 * @Classname T206
 * @Description TODO
 * @Date 2022/7/5 15:23
 * @Created by Will
 */
public class T206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        T206 test = new T206();
        test.reverseList(head);
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        while(cur != null){
            head = cur;
            cur = cur.next;
            head.next = pre;
            pre = head;
        }
        return head;
    }
}
