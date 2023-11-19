package IO;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileDemonstrationn extends JFrame {
    private JTextArea outputArea;
    private JScrollPane scrollPane;

    // set up GUI
    public FileDemonstrationn() {
        super("Testing class File");

        outputArea = new JTextArea();

        scrollPane = new JScrollPane(outputArea);

        add(scrollPane, BorderLayout.CENTER);

        setSize(400, 400);
        setVisible(true);

        analyzePath();
    }


    private File getFile() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.CANCEL_OPTION)
            System.exit(1);

        File fileName = fileChooser.getSelectedFile();

        if ((fileName == null) || (fileName.getName().equals(""))) {
            JOptionPane.showMessageDialog(this, "Invalid File Name", "Invalid File Name", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        return fileName;
    }

    public void analyzePath() {

        File name = getFile();

        if (name.exists()) {
            outputArea.setText(String.format("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s", name.getName(), " exists",
                    (name.isFile() ? "is a file" : "is not a file"),
                    (name.isDirectory() ? "is a directory" :
                            "is not a directory"),
                    (name.isAbsolute() ? "is absolute path" :
                            "is not absolute path"), "Last modified: ",
                    name.lastModified(), "Length: ", name.length(),
                    "Path: ", name.getPath(), "Absolute path: ",
                    name.getAbsolutePath(), "Parent: ", name.getParent()));

            if (name.isDirectory()) {
                String directory[] = name.list();
                outputArea.append("\n\nDirectory contents:\n");

                for (String directoryName : directory)
                    outputArea.append(directoryName + "\n");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, name +
                    " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
