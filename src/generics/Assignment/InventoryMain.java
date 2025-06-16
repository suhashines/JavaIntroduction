package generics.Assignment;

import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
       return "name : "+name + " , price: "+price ;
    }
}

class Electronics extends Product {

    String model ;

    public Electronics(String name,double price,String model){
        super(name,price);
        this.model = model ;
    }

    @Override

    public String toString(){
        return super.toString() + " , model : "+model ;
    }
}

class Sports extends Product {

    String material ;

    public Sports(String name,double price,String material){
        super(name,price);
        this.material = material;
    }

    public String toString(){
        return super.toString() + " , material : "+material ;
    }
}


public class InventoryMain {
    public static void main(String[] args) {

        Inventory<Product> inventory = new Inventory<>();

        inventory.addItem(new Electronics("Laptop", 999.99,"HP"));
        inventory.addItem(new Sports("Bat", 499.99,"Willow"));
        inventory.addItem(new Product("Accessories", 299.99));

        System.out.println("Inventory Details:");
        printInventoryDetails(inventory);

        double totalPrice = calculateTotalPrice(inventory);
        System.out.println("Total Price: $" + totalPrice);
    }

    private static double calculateTotalPrice(Inventory<?> inventory) {
             // Product p = inventory.getItem(i) ;
        double sum = 0 ;

        for(int i=0;i<inventory.itemCount();i++){

            sum += inventory.getItem(i).price ;
        }

        return sum ;
    }

    private static void printInventoryDetails(Inventory<?> inventory) {

        for(int i=0;i<inventory.itemCount();i++){

            System.out.println(inventory.getItem(i));
        }

    }

}

class Inventory<T extends Product> {
    private List<T> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.remove(index);
        }
        throw new IndexOutOfBoundsException("Index out of bounds.");
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        throw new IndexOutOfBoundsException("Index out of bounds.");
    }

    public int itemCount(){
        return items.size();
    }
}
