package ListNode_Practice;

/**
 * @Classname T203
 * @Description TODO
 * @Date 2022/7/5 13:59
 * @Created by Will
 */
public class T203 {
    public static void main(String[] args) {

    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;

        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
