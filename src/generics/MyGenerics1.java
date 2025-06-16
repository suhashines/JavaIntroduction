package generics;

public class MyGenerics1<T> {
    private T a;

    public void setObj(T a) {
        this.a = a;
    }

    public T getObj() {
        return this.a;
    }

    public static void main(String[] args) {

        MyGenerics1<Integer> myGenerics = new MyGenerics1<>();
        myGenerics.setObj(10);
        int i = myGenerics.getObj() ;
        System.out.println(i);

        MyGenerics1<String> myGenerics1 = new MyGenerics1<>();
        myGenerics1.setObj("Hello");
        String str = myGenerics1.getObj(); // no need of explicit casting
        System.out.println(str);


        //This part works as Object class

        MyGenerics1 noGenerics = new MyGenerics1(); // still possible

        noGenerics.setObj("World");

        str = (String) noGenerics.getObj();

        System.out.println(noGenerics.getObj());
    }
}


