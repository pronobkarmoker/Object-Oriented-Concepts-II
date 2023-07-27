import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(3);
        list.add(9);
        list.add(5);
        list.add(1);
        list.add(2);
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        System.out.println(list);

        System.out.println( list.get(13));

        list.remove();
        System.out.println(list);

        CustomGenArraylist<Integer> list2 = new CustomGenArraylist<>();
        for (int i = 0; i < 15; i++) {
            list2.add(i);
        }
        System.out.println(list2);
    }
}