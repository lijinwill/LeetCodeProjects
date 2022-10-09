package Stack_Queue_Practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname T225
 * @Description 队列模拟栈，思路就是两个队列，一个中转，另一个用来存放元素；
 *      当需要出队列时，就把队列中前面的元素都移动到另一个中转队列，然后最后一个元素出去。
 *      再把中转队列中的元素都移动回来
 *      当入队列时直接放入有元素的队列的末尾
 *
 * @Date 2022/7/10 13:44
 * @Created by Will
 */
public class T225 {
    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;

    public T225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.addLast(x);
    }

    public int pop() {
        while (queue1.size() > 1){
            queue2.addLast(queue1.poll());
        }
        int temp =  queue1.poll();
        while (queue2.size() > 0){
            queue1.addLast(queue2.poll());
        }
        return temp;
    }

    public int top() {
        return queue1.getLast();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
