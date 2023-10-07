import java.util.Vector;
import java.util.NoSuchElementException;

public class VectorTest {
    private static final String colors[] = { "red", "white", "blue" };

    public VectorTest() {
        Vector<String> vector = new Vector<String>();
        printVector(vector);

        for (String color : colors)
            vector.add(color);

        printVector(vector);

        try {
            System.out.printf("First element: %s\n", vector.firstElement());
            System.out.printf("Last element: %s\n", vector.lastElement());
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
        }

        if (vector.contains("red"))
            System.out.printf("\n\"red\" found at index %d\n\n", vector.indexOf("red"));
        else
            System.out.println("\n\"red\" not found\n");

        vector.remove("red");
        System.out.println("\"red\" has been removed");
        printVector(vector);

        if (vector.contains("red"))
            System.out.printf("\"red\" found at index %d\n", vector.indexOf("red"));
        else
            System.out.println("\"red\" not found");

        System.out.printf("\nSize: %d\nCapacity: %d\n", vector.size(), vector.capacity());
    }

    private void printVector(Vector<String> vectorToOutput) {
        if (vectorToOutput.isEmpty())
            System.out.print("vector is empty");
        else {
            System.out.print("vector contains: ");
            for (String element : vectorToOutput)
                System.out.printf("%s ", element);
        }

        System.out.println("\n");
    }

    public static void main(String args[]) {
        new VectorTest();
    }
}
