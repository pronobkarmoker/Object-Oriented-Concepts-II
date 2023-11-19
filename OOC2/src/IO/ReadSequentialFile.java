package IO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import IO.AccountRecordSerializable;

public class ReadSequentialFile
{
    private ObjectInputStream input;

    public void openFile()
    {
        try
        {
            input = new ObjectInputStream(new FileInputStream( "clients.ser" ) );
        }
        catch ( IOException ioException )
        {
            System.err.println( "Error opening file." );
        }
    }
    public void readRecords()
    {
        AccountRecordSerializable record;
        System.out.printf( "%-10s%-12s%-12s%10s\n", "Account", "First Name", "Last Name", "Balance" );

        try
        {
            while ( true )
            {
                record = ( AccountRecordSerializable ) input.readObject();

                System.out.printf( "%-10d%-12s%-12s%10.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance() );
            }
        }
        catch ( EOFException endOfFileException )
        {
            return;
        }
        catch ( ClassNotFoundException classNotFoundException )
        {
            System.err.println( "Unable to create object." );
        }
        catch ( IOException ioException )
        {
            System.err.println( "Error during read from file." );
        }
    }


    public void closeFile()
    {
        try
        {
            if ( input != null )
                input.close();
        }
        catch ( IOException ioException )
        {
            System.err.println( "Error closing file." );
            System.exit( 1 );
        }
    }
}
