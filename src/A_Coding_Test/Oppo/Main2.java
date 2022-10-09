package A_Coding_Test.Oppo;

import ListNode_Practice.ListNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/9/2 21:17
 */
public class Main2 {
    public ListNode combineTwoDisorderNodeToOrder(ListNode node1, ListNode node2) {
        // write code here
        // 存入HashMap,key 数字，value，地址
        HashMap<String, ListNode> hashmap = new HashMap<>();
        PriorityQueue<Map.Entry<String, ListNode>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, ListNode>>() {
            @Override
            public int compare(Map.Entry<String, ListNode> o1, Map.Entry<String, ListNode> o2) {
                return Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey());
            }
        });
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;

        while(node1 != null){
            hashmap.put(node1.val+"", node1);
            node1 = node1.next;
        }
        while(node2 != null){
            hashmap.put(node2.val+"", node2);
            node2 = node2.next;
        }

        for (Map.Entry<String, ListNode> entry : hashmap.entrySet()) {
            pq.offer(entry);
        }

        while(pq.size() > 0){
            p.next = pq.poll().getValue();
            p = p.next;
        }
        p.next = null;

        return dummyHead.next;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;/**/
        }
    }
}
