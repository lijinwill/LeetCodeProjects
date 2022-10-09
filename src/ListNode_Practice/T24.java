package ListNode_Practice;

/**
 * @Classname T24
 * @Description TODO
 * @Date 2022/7/5 15:39
 * @Created by Will
 */
public class T24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        T24 test = new T24();
        test.swapPairs(head);
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;

        head = p2;
        while (p1 != null && p2 != null){
            p1.next = p2.next;
            p2.next = p1;
            p1 = p1.next;
            p2 = p1.next;
        }
        return head;
    }
}
