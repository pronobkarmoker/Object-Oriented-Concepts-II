import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Sort2 {
    private static final String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

    public void printElements() {
        List<String> list = Arrays.asList(suits);

        System.out.printf("Unsorted array elements:\n%s\n", list);

        Collections.sort(list, Collections.reverseOrder());

        System.out.printf("Sorted list elements:\n%s\n", list);
    }

    public static void main(String args[]) {
        Sort2 sort2 = new Sort2();
        sort2.printElements();
    }
}
