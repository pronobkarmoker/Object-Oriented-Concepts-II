import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
    static void queue(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q.peek()); // 1 show

        System.out.println(q.poll()); // 1 will removed

        System.out.println(q.peek());

        System.out.println(q.size());

        System.out.println(q.isEmpty());

        System.out.println(q);
    }

    static void priorityqueue() {
        PriorityQueue<Integer> q = new PriorityQueue<>(); // priority min number
        q.add(10);
        q.add(5);
        q.add(7);

        System.out.println(q.peek());
        System.out.println(q);

        System.out.println(q.poll());

        System.out.println(q.peek());
        System.out.println(q);

    }

    static void dequeue(){
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.addFirst(2);
        dq.addFirst(4);
        dq.addLast(5);
        dq.addLast(7);

        System.out.println(dq);

        System.out.println(dq.pollFirst());
        System.out.println(dq.pollLast());

        System.out.println(dq);
    }

    public static void main(String[] args){
        queue();
        priorityqueue();
        dequeue();
    }
}
