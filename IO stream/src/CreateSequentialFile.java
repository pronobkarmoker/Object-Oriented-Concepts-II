import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import com.deitel.jhtp7.ch14.AccountRecordSerializable;

public class CreateSequentialFile {
    private ObjectOutputStream output; // outputs data to file

    // allow the user to specify the file name
    public void openFile() {
        try // open the file
        {
            output = new ObjectOutputStream(new FileOutputStream("clients.ser"));
        } // end try
        catch (IOException ioException) {
            System.err.println("Error opening file.");
        } // end catch
    } // end method openFile

    // add records to the file
    public void addRecords() {
        AccountRecordSerializable record; // object to be written to the file
        int accountNumber = 0; // account number for the record object
        String firstName; // first name for the record object
        String lastName; // last name for the record object
        double balance; // balance for the record object

        Scanner input = new Scanner(System.in);

        System.out.printf("%s\n%s\n%s\n%s\n\n", "To terminate input, type the end-of-file indicator ",
                "when you are prompted to enter input.", "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
                "On Windows type <ctrl> z then press Enter");

        System.out.printf("%s\n%s", "Enter account number (> 0), first name, last name, and balance.", "? ");

        while (input.hasNext()) // loop until the end-of-file indicator
        {
            try // output values to the file
            {
                accountNumber = input.nextInt(); // read account number
                firstName = input.next(); // read first name
                lastName = input.next(); // read last name
                balance = input.nextDouble(); // read balance

                if (accountNumber > 0) {
                    // create a new record
                    record = new AccountRecordSerializable(accountNumber, firstName, lastName, balance);
                    output.writeObject(record); // output record
                } // end if
                else {
                    System.out.println("Account number must be greater than 0.");
                } // end else
            } // end try
            catch (IOException ioException) {
                System.err.println("Error writing to file.");
                return;
            } // end catch
            catch (NoSuchElementException elementException) {
                System.err.println("Invalid input. Please try again.");
                input.nextLine(); // discard input so the user can try again
            } // end catch

            System.out.printf("%s %s\n%s", "Enter account number (>0),", "first name, last name, and balance.", "? ");
        } // end while
    } // end method addRecords

    // close the file and terminate the application
    public void closeFile() {
        try // close the file
        {
            if (output != null)
                output.close();
        } // end try
        catch (IOException ioException) {
            System.err.println("Error closing file.");
            System.exit(1);
        } // end catch
    } // end method closeFile
} // end class CreateSequentialFile
