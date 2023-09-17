import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileDemonstrations extends JFrame {
    private JTextArea outputArea; // used for output
    private JScrollPane scrollPane; // used to provide scrolling to output

    // set up GUI
    public FileDemonstrations() {
        super("Testing class File");

        outputArea = new JTextArea();

        // add outputArea to scrollPane
        scrollPane = new JScrollPane(outputArea);

        add(scrollPane, BorderLayout.CENTER); // add scrollPane to GUI

        setSize(400, 400); // set GUI size
        setVisible(true); // display GUI

        analyzePath(); // create and analyze File object
    } // end FileDemonstration constructor

    // allow the user to specify the file name
    private File getFile() {
        // display file dialog, so the user can choose a file to open
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int result = fileChooser.showOpenDialog(this);

        // if the user clicked Cancel button on the dialog, return
        if (result == JFileChooser.CANCEL_OPTION)
            System.exit(1);

        File fileName = fileChooser.getSelectedFile(); // get selected file

        // display an error if it's invalid
        if ((fileName == null) || (fileName.getName().equals(""))) {
            JOptionPane.showMessageDialog(this, "Invalid File Name", "Invalid File Name",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // end if

        return fileName;
    } // end method getFile

    // display information about the file the user specifies
    public void analyzePath() {
        // create File object based on user input
        File name = getFile();

        if (name.exists()) { // if the name exists, output information about it
            // display file (or directory) information
            outputArea.setText(String.format(
                    "%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
                    name.getName(), " exists",
                    (name.isFile() ? "is a file" : "is not a file"),
                    (name.isDirectory() ? "is a directory" : "is not a directory"),
                    (name.isAbsolute() ? "is absolute path" : "is not absolute path"),
                    "Last modified: ", name.lastModified(),
                    "Length: ", name.length(),
                    "Path: ", name.getPath(),
                    "Absolute path: ", name.getAbsolutePath(),
                    "Parent: ", name.getParent()));

            if (name.isDirectory()) { // output directory listing
                String directory[] = name.list();
                outputArea.append("\n\nDirectory contents:\n");

                for (String directoryName : directory)
                    outputArea.append(directoryName + "\n");
            } // end else
        } // end outer if
        else { // not a file or directory, output an error message
            JOptionPane.showMessageDialog(this, name + " does not exist.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } // end else
    } // end method analyzePath
} // end class FileDemonstration
