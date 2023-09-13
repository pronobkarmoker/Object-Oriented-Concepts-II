class printer{
    synchronized void print(int num, String name){
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(">> printing "+ name + " " +i);
        }
    }
}

class mythread extends Thread{
    printer pref;

    mythread(printer pr){
        pref = pr;
    }
    @Override
    public void run(){
        pref.print(10 , " ^^ pronob.pdf");
    }
}

class yourthread extends Thread{
    printer pref;

    yourthread(printer pr){
        pref = pr;
    }
    @Override
    public void run(){
        pref.print(10 , " ** engineer shuvo.pdf");
    }
}


public class synApp {
    public static void main(String[] args) {
        System.out.println("==app start==");

        // we have only one object
        printer p = new printer();
        p.print(10, "## shuvo.pdf");


// we have multiple thread working on the same printer object
        mythread mref = new mythread(p);// reference to the printer object
        yourthread yref = new yourthread(p);// reference to the printer object
        mref.start();
//        try {
//            mref.join(); // syncronization
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        yref.start();

        System.out.println("FINISHED");
    }
}
