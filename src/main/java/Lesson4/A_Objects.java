package main.java.Lesson4;

public class A_Objects {
    public static void main(String[] args) {

        Cat barsik = new Cat("Barsik");
        barsik.name = "Barsik";
        Cat barsik2 = new Cat("Barsik2", 20);
        barsik.setAge(-30);
        System.out.println(barsik.getAge());
        barsik.sayHello();
        barsik.sayBy();
        System.out.println("Default age is: " + Cat.getDefaultAge()); // не создавая экземпляр класса обращаюсь к переменной этого класса, т.к.она статическая
        System.out.println("Total amount: " + barsik.totalAmount); //можно Cat.totalAmount
        System.out.println(barsik.name);


//        Cat barsik3 = barsik;
//
//        System.out.println(barsik == barsik2); //переменные не равны,т.к. ссылаются на разные участки памяти и созданы через New
//        System.out.println(barsik == barsik3); //переменные равны, т.к. не создается экзкмпляр класса, ссылка на один и тодже адрес

//        barsik.age = 50;
//        barsik2.name = "Barsik2";
//        System.out.println(barsik.age);
//        System.out.println(barsik2.age);

//        barsik.sayHello();
//        barsik2.sayHello();


    }
}
