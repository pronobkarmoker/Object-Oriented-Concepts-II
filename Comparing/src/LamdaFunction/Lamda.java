package LamdaFunction;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Lamda {
    public static void main(String[] args) {
        int[] arr = {3,4,5,6};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i*2);
        }

        arrayList.forEach((item) -> System.out.println(item*2));

        Consumer<Integer> fun = (item) -> System.out.println(item*2);
        arrayList.forEach(fun);

        operation sum = (a ,b) -> a+b;
        operation sub = (a ,b) -> a-b;
        operation mul = (a ,b) -> a*b;
        operation div = (a ,b) -> a/b;

        Lamda mycalc = new Lamda();
        System.out.println(mycalc.op(4,6,sub));
        System.out.println(mycalc.op(4,6,sum));
        System.out.println(mycalc.op(4,6,mul));
        System.out.println(mycalc.op(4,6,div));



    }

    private int op(int a , int b, operation op){
        return op.op(a,b);
    }

    interface operation{
        int op(int a , int b);
    }
}
