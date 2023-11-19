package Threads;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.concurrent.ExecutionException;

public class FibonacciNumbers extends JFrame {
    private final JPanel workerJPanel = new JPanel(new GridLayout(2, 2, 5, 5));
    private final JTextField numberJTextField = new JTextField();
    private final JButton goJButton = new JButton("Go");
    private final JLabel fibonacciJLabel = new JLabel();

    private final JPanel eventThreadJPanel = new JPanel(new GridLayout(2, 2, 5, 5));
    private int n1 = 0;
    private int n2 = 1;
    private int count = 1;
    private final JLabel nJLabel = new JLabel("Fibonacci of 1: ");
    private final JLabel nFibonacciJLabel = new JLabel(String.valueOf(n2));
    private final JButton nextNumberJButton = new JButton("Next Number");

    public FibonacciNumbers() {
        super("Fibonacci Numbers");
        setLayout(new GridLayout(2, 1, 10, 10));

        workerJPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "With SwingWorker"));
        workerJPanel.add(new JLabel("Get Fibonacci of: "));
        workerJPanel.add(numberJTextField);
        goJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int n;
                try {
                    n = Integer.parseInt(numberJTextField.getText());
                } catch (NumberFormatException ex) {
                    fibonacciJLabel.setText("Enter an integer.");
                    return;
                }

                fibonacciJLabel.setText("Calculating...");
                BackgroundCalculator task = new BackgroundCalculator(n, fibonacciJLabel);
                task.execute();
            }
        });
        workerJPanel.add(goJButton);
        workerJPanel.add(fibonacciJLabel);

        eventThreadJPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Without SwingWorker"));
        eventThreadJPanel.add(nJLabel);
        eventThreadJPanel.add(nFibonacciJLabel);
        nextNumberJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int temp = n1 + n2;
                n1 = n2;
                n2 = temp;
                ++count;
                nJLabel.setText("Fibonacci of " + count + ": ");
                nFibonacciJLabel.setText(String.valueOf(n2));
            }
        });
        eventThreadJPanel.add(nextNumberJButton);

        add(workerJPanel);
        add(eventThreadJPanel);
        setSize(275, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        FibonacciNumbers application = new FibonacciNumbers();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
