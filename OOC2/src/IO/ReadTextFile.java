package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {
    private Scanner input;

    public void openFile(){
        try{
            input=new Scanner(new File("C:\\Users\\Shuvo\\IdeaProjects\\OOC2\\src\\IO\\IO.txt"));
        }catch (FileNotFoundException fileNotFoundException){
            System.err.println("Error Opening File");
            System.exit(1);
        }
    }

    public void readRecords(){
        AccountRecord record=new AccountRecord();
        System.out.println("Account\t\t\tFirst Name\t\t\tLastName\t\t\tBalance");

        try{
            while(input.hasNext()){
                record.setAccount(input.nextInt());
                record.setFirstName(input.next());
                record.setLastName(input.next());
                record.setBalance(input.nextDouble());

                System.out.println(record.getAccount()+"\t\t\t\t"+ record.getFirstName()+"\t\t\t"+record.getLastName()+"\t\t\t\t"+ record.getBalance());
            }
        }catch (NoSuchElementException elementException){
            System.err.println("File improperly formed");
            input.close();
            System.exit(1);
        }catch (IllegalStateException stateException){
            System.err.println("Error Reading From FIle");
            System.exit(1);
        }
    }

    public void closeFile(){
        if(input!=null) input.close();
    }
}