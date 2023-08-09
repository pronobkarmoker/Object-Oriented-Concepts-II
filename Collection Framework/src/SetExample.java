import java.util.HashSet;

public class SetExample {
    static void hashset(){
        HashSet<Integer> h = new HashSet<>();
        h.add(3);
        h.add(4);
        h.add(5);
        System.out.println(h);

        h.add(3);
        h.add(3);
        h.add(3);
        System.out.println(h); // unique  randomly ordered hashset e but linkedhashset e order same thake  and treeset e sort hy

        h.remove(3);
        System.out.println(h.contains(3));
    }

    public static void main(String[] args){
        hashset();
    }
}
