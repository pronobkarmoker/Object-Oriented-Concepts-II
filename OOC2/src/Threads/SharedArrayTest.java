package Threads;
public class SharedArrayTest {
    public static void main(String[] arg) {
        SimpleArray sharedSimpleArray = new SimpleArray(6);
        ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
        ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(writer1);
        executor.execute(writer2);

        executor.shutdown();

        try {
            boolean tasksEnded = executor.awaitTermination(1, TimeUnit.MINUTES);

            if (tasksEnded)
                System.out.println(sharedSimpleArray);
            else
                System.out.println("Timed out while waiting for tasks to finish.");
        } catch (InterruptedException ex) {
            System.out.println("Interrupted while waiting for tasks to finish.");
        }
    }
}
