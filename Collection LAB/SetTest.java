import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;

public class SetTest {
    private static final String colors[] = { "red", "white", "blue",
            "green", "gray", "orange", "tan", "white", "cyan",
            "peach", "gray", "orange" };

    public SetTest() {
        List<String> list = Arrays.asList(colors);
        System.out.printf("ArrayList: %s\n", list);
        printNonDuplicates(list);
    }

    private void printNonDuplicates(Collection<String> collection) {
        Set<String> set = new HashSet<String>(collection);
        System.out.println("\nNonduplicates are: ");
        for (String s : set) {
            System.out.printf("%s ", s);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        new SetTest();
    }
}
