package ListNode_Practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-04-20$ $
 */
public class T148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        T148 test = new T148();
        test.sortList(head);
    }
    //思路1：最简单的方法，先全部元素放到数组，然后排序，然后再存到链表里
    public ListNode sortList(ListNode head) {
        ListNode p = head;
        ArrayList<Integer> array = new ArrayList<>();
        while(p != null){
            array.add(p.val);
            p = p.next;
        }
        array.sort(Comparator.naturalOrder());

        p = head;
        for(int i=0; i<array.size(); i++){
            p.val = array.get(i);
            p = p.next;
        }
        return head;
    }
}
