package Thread.SumThread;


class SumThread extends Thread{

    int[]arr ;
    int low,high;
    int sum;

    SumThread(int[]arr,int low,int high){
        this.arr = arr ;
        this.low = low;
        this.high = high;
        sum = 0 ;
    }

    @Override
    public void run() {
        // 0th thread : low =0,high = 100
        // 1st thread : low=100, high = 200

        int n = low/(high-low) ;

        System.out.println("Thread "+n+" has been started");

        for(int i=low;i<high;i++){
            sum+= arr[i];
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread "+n+" ended");
    }
}

public class MultipleThreadSum {

    public static final int NUMBER_OF_THREADS = 10 ;

    public static void main(String[] args) throws InterruptedException {

        /* suppose you're tasked to calculate sum of the elements
        of an array. Pretty easy using a loop right?
        But what if the array is too large, maybe containing more than millions elements?


        Instead of delegating the task to one function,
        can we break the task into separate parts
        and simultaneously compute the sum of those little parts
        and then add those sub-operations to get our final results?
         */

        /* following code generates an array of random 10000 elements
        The array can be fetched using the getRandomArray method
        Your task is to create NUMBER_OF_THREADS and calculate the sum
         */

        RandomArray ra = new RandomArray(10000);

        /* add necessary codes here */

        /* start_time */
        System.out.println("Final Sum "+calculateSum(ra.getRandomArray()));

        //end_time

        System.out.println("Without Thread "+ra.calculateSum());
    }


    private static int calculateSum(int[] arr) throws InterruptedException {


        int sum = 0 ;

        /*add your code here */

        SumThread[] threads = new SumThread[NUMBER_OF_THREADS];

        // how many numbers do I actually have = arr.length

        // threads[0] = 0- ( 0 + work_per_thread) -> arr.length/NUMBER_OF_Threads

        int low = 0 ;

        for(int i=0;i<NUMBER_OF_THREADS;i++){

            int high = low + arr.length/NUMBER_OF_THREADS ;
            threads[i] = new SumThread(arr,low,high);
            // 1st iteration : low = 0 , high = 100
            // 2nd iteration: low = 100, high = 200
            low = high ;
            threads[i].start();
        }

         // Thread class has a join method
        // it suspends the program

        for(int i=0;i<NUMBER_OF_THREADS;i++){
            threads[i].join();
        }
        // finally summation is done -> sum

        for(int i=0;i<NUMBER_OF_THREADS;i++){
            sum += threads[i].sum ;
        }


        return sum ;

    }
}
