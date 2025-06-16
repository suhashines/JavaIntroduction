package Thread;

class ImplementedThread implements Runnable {    // run()

    Thread t ;

    ImplementedThread(){
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

public class ImplementsThreadDemo {
    public static void main(String[] args) {

//      Thread(String name) , Thread(Runnable r) -> class Abul implements Runnable
//        Runnable r = new Abul();
//      Thread(new Abul());

      //  new ImplementedThread();

//        Runnable r = new ImplementedThread();
//        Thread t = new Thread(r) ;
//        t.setName("abul");
//        t.start();

        // lamda expression -> run(){}   run = () -> { }

        Thread lambda = new Thread(()->{
            try {
                for(int i = 5; i > 0; i--) {
                    System.out.println("Child Thread: " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("Child interrupted.");
            }
            System.out.println("Exiting child thread.");
        },"abul");

        lambda.start();

    }
}