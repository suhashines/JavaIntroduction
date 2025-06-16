package Thread.Synchronization;

class SharedCounter {
    private int counter;

    SharedCounter() {
        this.counter = 0;
    }

    public synchronized void increment() {


            // this statement is the root of all evils
             this.counter++ ;
    }

    public int get() {
        return this.counter;
    }

    void count() {
        for (int i = 0; i < 1000; i++) {
            increment();
        }
    }
}

class ThreadCounterNoSync implements Runnable {
    SharedCounter sharedCounter;
    Thread t;

    public ThreadCounterNoSync(SharedCounter s, String name) {
        sharedCounter = s;
        t = new Thread(this, name);
        t.start();
    }

    public void run() {
        // statements
        sharedCounter.count();
        // statements
    }
}

public class NonSynchronizedCounter {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();
        ThreadCounterNoSync ob1 = new ThreadCounterNoSync(sharedCounter, "T1");
        // t1 will try to increment the counter 1000 times
        ThreadCounterNoSync ob2 = new ThreadCounterNoSync(sharedCounter, "T2");
        // t2 will try to increment the counter 1000 times
        ThreadCounterNoSync ob3 = new ThreadCounterNoSync(sharedCounter, "T3");
        // t3 will try to increment the counter 1000 times

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch(Exception e) {
            System.out.println(e);
        }

        System.out.println(sharedCounter.get());

        // counter = read
        // counter = update
        // t1 , counter =0 , read
        // t2, counter = 0, read
        // t1,update , counter = 1
        // t2, update , counter=1   // 2

        // t1 reads something, everything else should be paused until t1 updates or writes back

        // synchronization will help us achieve the task
    }
}
