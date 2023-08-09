import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Lists{
    static void Arraylist(){
        ArrayList<Integer> l = new ArrayList<>();

        l.add(4);
        l.add(3);
        l.add(8);
        l.add(6);
        System.out.println(l);

        System.out.println(l.get(1));

        l.set(1 , 10);
        System.out.println(l);

        System.out.println(l.contains(10));

    }

    static void Linkedlists(){
        LinkedList<Integer> l = new LinkedList<>();

        l.add(4);
        l.add(3);
        l.add(8);
        l.add(6);
        System.out.println(l);

        System.out.println(l.get(1));

        l.set(1 , 10);
        System.out.println(l);

        System.out.println(l.contains(10));
    }

    static void Stacks(){
        Stack <String> s = new Stack<>();

        s.push("Shuvo");
        s.push(" karmakar");
        System.out.println(s.peek());

        System.out.println(s.pop());

        System.out.println(s.peek());

        System.out.println(s.size());

        System.out.println(s.empty());
    }

    public static void main(String[] args) {
        Arraylist();
        Linkedlists();
        Stacks();
    }

}
