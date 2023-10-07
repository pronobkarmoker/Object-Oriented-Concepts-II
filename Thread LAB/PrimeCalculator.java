import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingWorker;
import java.util.Random;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PrimeCalculator extends SwingWorker<Integer, Integer> {
    private final Random generator = new Random();
    private final JTextArea intermediateJTextArea;
    private final JButton getPrimesJButton;
    private final JButton cancelJButton;
    private final JLabel statusJLabel;
    private final boolean primes[];
    private boolean stopped = false;

    public PrimeCalculator(int max, JTextArea intermediate, JLabel status, JButton getPrimes, JButton cancel) {
        intermediateJTextArea = intermediate;
        statusJLabel = status;
        getPrimesJButton = getPrimes;
        cancelJButton = cancel;
        primes = new boolean[max];
        for (int i = 0; i < max; i++)
            primes[i] = true;
    }

    public Integer doInBackground() {
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (stopped)
                return count;
            else {
                setProgress(100 * (i + 1) / primes.length);
                try {
                    Thread.currentThread().sleep(generator.nextInt(5));
                } catch (InterruptedException ex) {
                    statusJLabel.setText("Worker thread interrupted");
                    return count;
                }
                if (primes[i]) {
                    publish(i);
                    ++count;
                    for (int j = i + i; j < primes.length; j += i)
                        primes[j] = false;
                }
            }
        }
        return count;
    }

    protected void process(List<Integer> publishedVals) {
        for (int i = 0; i < publishedVals.size(); i++)
            intermediateJTextArea.append(publishedVals.get(i) + "\n");
    }

    protected void done() {
        getPrimesJButton.setEnabled(true);
        cancelJButton.setEnabled(false);
        int numPrimes;
        try {
            numPrimes = get();
        } catch (InterruptedException ex) {
            statusJLabel.setText("Interrupted while waiting for results.");
            return;
        } catch (ExecutionException ex) {
            statusJLabel.setText("Error performing computation.");
            return;
        }
        statusJLabel.setText("Found " + numPrimes + " primes.");
    }

    public void stopCalculation() {
        stopped = true;
    }
}
