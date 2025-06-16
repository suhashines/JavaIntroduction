package Thread;

class ExtendedThread extends Thread{

    ExtendedThread(String name){
        // Thread(String name) -> name -> this.name = name ;

        super(name) ;

        // Thread -> start(){run();}
        start();
    }

    @Override
    public void run() {
        System.out.println(super.getName()+ " thread started");

        for(int i=0;i<25;i++){
            System.out.println(super.getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(super.getName()+" thread exiting");
    }
}

public class ExtendsThread {
    public static void main(String[] args) {

        new ExtendedThread("Child");
        System.out.println("main thread starting");

        for(int i=0;i<5;i++){
            System.out.println("main"+":"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("main thread exiting");
    }
}
