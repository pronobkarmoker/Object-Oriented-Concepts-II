package IO;
import java.io.File;
public class FileDemonstration {
    public void analyzePath(String path){
        File name=new File(path);
        if(name.exists()){
            System.out.println(name.getName()+" exist");
            System.out.println((name.isFile())? "is a file":"is not a file");
            System.out.println((name.isDirectory())? "is a directory":"is not a directory");
            System.out.println((name.isAbsolute())? "is absolute path":"is not absolute path");
            System.out.println("Last Modified:"+name.lastModified());
            System.out.println("Length:"+name.length());
            System.out.println("Absolute Path:"+name.getAbsolutePath());
            System.out.println("Parent:"+name.getParent());

            if(name.isDirectory()){
                String[] directory = name.list();
                System.out.println("\n\nDirectory Contains:\n");

                for(String directoryName:directory){
                    System.out.println(directoryName);
                }
            }
        }else{
            System.out.println("File doesn't exist");
        }
    }
}