package Inheritance;

class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
	
    public boolean isLethalToAdultHumans() {
        return false;
    }

    public String getInfo() {
        return name + " is a " + this.getClass().getSimpleName()+", aged "+age ;
    }


    // your code


} 

// your code

class Bird extends Animal{

    public Bird(String name, int age) {
        super(name, age);
    }
}

class Albatross extends Bird{

    public Albatross(String name, int age) {
        super(name, age);
    }
}

class Mammal extends Animal{

    public Mammal(String name, int age) {
        super(name, age);
    }


    public void printBloodType() {
        System.out.print(", Warm-Blooded!");
    }
}

class Dog extends Mammal{

    public Dog(String name, int age) {
        super(name, age);
    }
}

class FruitBat extends Mammal{

    public FruitBat(String name, int age) {
        super(name, age);
    }
}

class Platypus extends Mammal{

    public Platypus(String name, int age) {
        super(name, age);
    }
}

class Human extends Mammal{

    public Human(String name, int age) {
        super(name, age);
    }
}

class Reptile extends Animal{

    public Reptile(String name, int age) {
        super(name, age);
    }
}
class EasternBrownSnake extends Reptile{

    public EasternBrownSnake(String name, int age) {
        super(name, age);
    }
}

class Fish extends Animal{

    public Fish(String name, int age) {
        super(name, age);
    }
}
class GreatWhiteShark extends Fish{

    public GreatWhiteShark(String name, int age) {
        super(name, age);
    }
}

class Arachnid extends Animal{

    public Arachnid(String name, int age) {
        super(name, age);
    }
}
class RedBlackSpider extends Arachnid{

    public RedBlackSpider(String name, int age) {
        super(name, age);
    }
}



class TestAnimal {
    public static void main(String[] args) {

        Bird alex = new Albatross("Alex", 39);  // Bird class refers Albatross
                                                 // Albatross is a subclass of Bird

        Mammal spot = new Dog("Spot", 7);
        Mammal fred = new FruitBat("Fred", 10);  // Mammal -> Dog, Fruitbat, Platypus, Human

        Reptile steph = new EasternBrownSnake("Steph", 12);

        Fish bruce = new GreatWhiteShark("Bruce", 40);
        Arachnid charlotte = new RedBlackSpider("Charlotte", 1);

        Mammal perry = new Platypus("Perry", 5);
        Mammal bob = new Human("Bob", 20);

        Animal[] animals = {alex, spot, fred, steph, bruce, charlotte, perry, bob};

        // Animal is the superclass of everyone -> Bird, Mammal, Fish, Arachnid , Reptile

        for (Animal a : animals) {

            System.out.print(a.getInfo());
            // Animal class should have a getInfo method

            if (a instanceof Mammal) {
                ((Mammal) a).printBloodType(); // type cast to Mammal
            }
            System.out.println(a.isLethalToAdultHumans() ? ", it's lethal!" : ", fortunately non-lethal");
        }
    }
}
