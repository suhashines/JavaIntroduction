package Thread.InterThreadCommunication;

class Buffer{
    int data ;
    
    // Add necessary codes in this class

    boolean dataset = false;

    public synchronized void write(int data) throws InterruptedException {



        System.out.println(Thread.currentThread().getName()+" enters");


//        if(!dataset) -> producer will change the data

        while(dataset){
            System.out.println(Thread.currentThread().getName()+" waits");
            wait();
        }

        this.data = data ;

        System.out.println(Thread.currentThread().getName()+" writes "+this.data);

        dataset = true ;

        notifyAll();
    }


    public synchronized void read() throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+" enters");

        while(!dataset){
            System.out.println(Thread.currentThread().getName()+" waits");
            wait();
        }

        System.out.println(Thread.currentThread().getName()+" reads "+data);

        dataset = false ;

        notifyAll();
    }
}

class Producer implements Runnable{

    Buffer buffer ;

    Producer(Buffer buffer){
        this.buffer = buffer ;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {

        for(int i=0;i<1000;i++){
            try {
                buffer.write(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class Consumer implements Runnable{

    Buffer buffer ;

    Consumer(Buffer buffer){
        this.buffer = buffer ;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            try {
                buffer.read();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ProducerConsumer {

    public static void main(String[] args) {

        /*
        There is a producer and a consumer that shares a buffer class. After producer has written to
        the buffer only then consumer can read from the buffer. The code aims to do so,but
        fails miserably as the consumer thread is much faster than the Producer.
         So it's your task to implement the desired feature.
         */

        Buffer buffer = new Buffer();
        new Producer(buffer) ;
        new Consumer(buffer);

        /* there should be a communication between producer and consumer ->
        * if producer hasn't produced a value yet, the consumer should wait \
        * after producer has written a value then it will notify the consumer and then
        * consumer can consume / read that value */
    }
}
