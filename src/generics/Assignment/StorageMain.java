package generics.Assignment;


class Storage<T>{

    T[] arr ;
    int size ;
    int length ;

    Storage(){
        size = 100 ;
        length = 0 ;
        arr =  (T[]) new Object[size] ;
    }

    public void addItem(T item) {

        arr[length] = item ;

        length ++ ;
    }

    public T getItem(int i) {

        return arr[i] ;
    }

    public int getCount() {

        return length;
    }

    public T removeItem(int i) {

        // 1 2 3 4 , length = 4
        // removing 2 : 1 3 4

        T item = arr[i] ;

        for(int j=i+1;j<length;j++){
            arr[j-1] = arr[j];
        }

        length -- ;

        return item ;

    }

    public void print() {

        for(int i=0;i<length;i++){
            System.out.println(arr[i]);
        }
    }
}

public class StorageMain {

    public static void main(String[] args) {
        Storage<String> stringStorage = new Storage<>();
        stringStorage.addItem("Hello");
        stringStorage.addItem("World");
        System.out.println("Stored String: " + stringStorage.getItem(0));

        Storage<Integer> intStorage = new Storage<>();
        intStorage.addItem(123);
        System.out.println("Stored Integer: " + intStorage.getItem(0));

        Storage<Double> doubleStorage = new Storage<>();
        doubleStorage.addItem(45.67);
        System.out.println("Stored Double: " + doubleStorage.getItem(0));

        System.out.println("Count of items in stringStorage: " + stringStorage.getCount());
        System.out.println("Removing item from stringStorage: " + stringStorage.removeItem(0));
        System.out.println("Count of items in stringStorage after removal: " + stringStorage.getCount());
        stringStorage.print();
    }

}
