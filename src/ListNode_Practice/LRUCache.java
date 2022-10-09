package ListNode_Practice;

import java.util.HashMap;

/**
 * @author Will$
 * @version 1.0
 * @description: TODO
 * @date 2022-04-24$ $
 */
public class LRUCache {
    /*思路：建立一个HashMap和一个DLinkedList双向队列，HashMap存放key,Node；DLinkedList存放key,value
        双向队列的作用是维护访问频次，最近访问过的 新建（如果之前不存在）或是 移动插入（如果之前存在）到队列的头部
        哈希表存放了链表节点在内存中的位置，其作用是o(1)时间内快速访问队列，
        如果没有哈希表，则在双向队列中增、删、改都要遍历一遍队列，时间复杂度高
    */
    HashMap<Integer, DLinkedList> hashmap = new HashMap<>();
    //表示输入的LRU缓存的大小
    private int capacity;
    //增设头尾节点方便后续队列的增删改
    private DLinkedList head;
    private DLinkedList tail;
    //构造器
    public LRUCache(int capacity) {
        //初始化
        this.capacity = capacity;
        this.head = new DLinkedList();
        this.tail = new DLinkedList();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(hashmap.containsKey(key)) {
            moveToHead(hashmap.get(key));
            return hashmap.get(key).val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        //如果hashmap中不存在key，且hashmap的size小于capacity，则hashmap中添加进去，队列前部添加进去
        if(!hashmap.containsKey(key)){
            if(hashmap.size() < capacity){
                DLinkedList node = new DLinkedList(key, value);
                hashmap.put(key, node);
                addToHead(node);
            }else if(hashmap.size() == capacity) {
                //如果hashmap中不存在key，且hashmap的size等于capacity，
                //则将队列尾部的节点删除，返回节点到temp，hashmap中删除temp; 新建节点，hashmap中添加进去，队列头部添加进去
                DLinkedList temp = removeTail();
                hashmap.remove(temp.key);
                DLinkedList node = new DLinkedList(key, value);
                hashmap.put(key, node);
                addToHead(node);
            }
        }else {
            //如果hashmap中存在key，如果value与原先不同，更新队列中那个节点，并移动到开头
            if(value != hashmap.get(key).val) {
                hashmap.get(key).val = value;
                moveToHead(hashmap.get(key));
            }else{
                moveToHead((hashmap.get(key)));
            }
        }
    }


    private void addToHead(DLinkedList node){
        node.pre = head;
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
    }
    private void moveToHead(DLinkedList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    private DLinkedList removeTail(){
        DLinkedList temp = tail.pre;
        tail.pre = temp.pre;
        temp.pre.next = tail;
        return temp;
    }
}
