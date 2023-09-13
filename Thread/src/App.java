//class mytask extends Thread{
//    @Override
//    public void run(){
//        for (int i = 0; i < 11; i++) {
//            System.out.println("another printing document #"+ i);
//        }
//    }
//}

//class myTask {
//    void executeTask(){
//        for (int i = 0; i < 11; i++) {
//            System.out.println("@@ printing document #"+ i);
//        }
//    }
//}

class CA{

}

class Task extends CA implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.println("^^printing document #"+ i);
        }
    }
}



public class App {
    //main method represents main thread
    public static void main(String[] args) {
        // threads always execute the jobs in a sequence
        //execution context

        System.out.println("application started");

//        mytask task = new mytask();
//        task.start();
//
//        myTask t = new myTask();
//        t.executeTask();

        Runnable r = new Task();
        Thread ta = new Thread(r);
        ta.start();

        for (int i = 0; i < 11; i++) {
            System.out.println("printing document #"+ i);
        }

        System.out.println("application finished");
    }
}
