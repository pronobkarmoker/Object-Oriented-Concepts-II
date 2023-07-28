import java.util.*;

public class Collection_Vector {
    public static void main(String[] args) {
//      collection

        List<Integer> l1 = new ArrayList<>();   // arraylist  -> multiple thread
        List<Integer> l2 = new LinkedList<>();

        l2.add(34);
        l2.add(4);
        l2.add(3);
        l2.add(44);
        l2.add(33);
        l2.add(42);
        l2.add(55);

        System.out.println(l2.isEmpty());
        System.out.println(l1.isEmpty());

        System.out.println(l2);


//      VECTOR  -> single thread

        List<Integer> vector = new Vector<>();
        vector.add(5);
        vector.add(4);
        vector.add(55);
        vector.add(44);
        vector.add(43);
        vector.add(33);

        System.out.println(vector);  // not fast as arraylist


    }
}