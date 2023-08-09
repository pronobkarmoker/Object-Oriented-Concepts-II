import java.util.HashMap;

public class MapInterfaceExample {
    static void hashmap(){
        HashMap<Integer,String> m = new HashMap<>();

        m.put(3,"shuvo");
        m.put(1,"pronob");
        m.put(2,"karmakar");

        System.out.println(m);

        System.out.println(m.get(2));

        System.out.println(m.containsKey(4));
        System.out.println(m.containsValue("shuvo"));

        System.out.println(m.keySet());
        System.out.println(m.values());
    }

    public static void main(String[] args){
        hashmap();
    }
}
