package ListNode_Practice;

public class T86 {
    //思路：双指针法。左指针指向大于等于x的节点的前一个位置，右指针指向左指针右侧小于x的节点的前一个位置
    //      然后交换两个节点的值。交换完后左节点右移，继续右节点判断。直到左节点右侧不存在小于x的值。
    public ListNode partition(ListNode head, int x) {
        //建一个虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;

        ListNode leftP = head;
        ListNode rightP = head.next;
        while(rightP.next != null){
            //如果左指针下一个小于x，则继续，就是说左边遇到>=x的才执行下面的代码
            if(leftP.next.val < x){
                leftP = leftP.next;
                rightP = leftP.next;
                continue;
            }
            //符合条件下完成一次交换
            while(rightP.next != null){
                if(rightP.next.val < x){
                    ListNode tempP = leftP.next;
                    leftP.next = rightP.next;
                    rightP.next = rightP.next.next;
                    leftP.next.next = tempP;
                    break;
                }
                rightP = rightP.next;
            }

            leftP = leftP.next;
        }
        return head.next;
    }
}
