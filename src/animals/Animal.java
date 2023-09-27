package animals;

class Animal{
    void  who(){
        System.out.println("animal");
    }
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.who();
        Animal dog = new Dog();
        dog.who();
    }
}

class Dog extends Animal{
    //@Override
    void who() {
        System.out.println("Dog");
    }
    void name(){
        System.out.println("bob");
    }
}