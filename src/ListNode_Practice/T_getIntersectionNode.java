package ListNode_Practice;

/**
 * @Classname T0207
 * @Description 面试题 02.07. 链表相交; 一时半会没找到位置
 * @Date 2022/7/6 14:37
 * @Created by Will
 */
public class T_getIntersectionNode {
    public static void main(String[] args) {
//        int n = 2;
//        ListNode headA = new ListNode(1);
//        headA.next = new ListNode(2);
//        headA.next.next = new ListNode(3);
//        headA.next.next.next = new ListNode(4);
//        T_getIntersectionNode test = new T_getIntersectionNode();
//        test.getIntersectionNode(headA);
    }
    //思路：注意，两个链表如果相交，且一长一短，则先把长的指针移动到还剩短的那么长，然后再比较
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        //先统计两个链表长度
        int countA = 0;
        int countB = 0;
        while(pA != null){
            pA = pA.next;
            countA++;
        }
        while(pB != null){
            pB = pB.next;
            countB++;
        }

        //然后放弃长的那部分
        pA = headA;
        pB = headB;
        int temp = 0;
        if (countA <= countB){
            while(temp < countB-countA){
                temp++;
                pB = pB.next;
            }
            while(pA != null){
                if (pA == pB){
                    return pA;
                }else{
                    pA = pA.next;
                    pB = pB.next;
                }
            }
        }else{
            while(temp < countA-countB){
                temp++;
                pA = pA.next;
            }
            while(pA != null){
                if (pA == pB){
                    return pA;
                }else{
                    pA = pA.next;
                    pB = pB.next;
                }
            }
        }
        return null;
    }
}
