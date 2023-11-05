package animals;

abstract class Animal{
    abstract void  who();

    public static void main(String[] args) {

        Animal a = new Animal() {
            @Override
            void who() {
                System.out.println("Overrided animal");
            }
        };
        Animal dog = new Dog();
        Animal cat = new Cat();
        a.who();
        dog.who();
        cat.who();

    }
}

class Dog extends Animal{
    @Override
    void who() {
        System.out.println("Dog");
    }
    void name(){
        System.out.println("bob");
    }
}

class Cat extends Animal{
    @Override
    void who() {
        System.out.println("Cat");
    }
}