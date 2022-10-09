package ListNode_Practice;

/**
 * @Classname T19
 * @Description TODO
 * @Date 2022/7/5 16:24
 * @Created by Will
 */
public class T19 {
    public static void main(String[] args) {
        int n = 2;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        T19 test = new T19();
        test.removeNthFromEnd(head, n);
    }
    //思路：双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，
    // 然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        int count = 0;
        while(fast != null){
            if (count < n+1){
                fast = fast.next;
                count++;
            }else{
                fast = fast.next;
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
