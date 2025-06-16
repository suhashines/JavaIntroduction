package Thread.SumThread;

import java.util.Random;

public class RandomArray {

    int [] arr ;
    public RandomArray(int size){

        arr = new int[size];
        Random random = new Random();
        for(int i=0;i<size;i++){
            arr[i] = random.nextInt(1000);
        }
    }

    int[] getRandomArray(){
        return arr ;
    }

    int calculateSum(){
        int sum = 0 ;

        for(int i:arr){
            sum += i ;
        }
        return sum;
    }
}
