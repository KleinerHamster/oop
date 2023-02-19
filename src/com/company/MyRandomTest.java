package com.company;

class MyRandomTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    //тест на проверку метода getRandomDoubleBetweenRange
    @org.junit.jupiter.api.Test
    void getRandomDoubleBetweenRange() {
        MyRandom rnd = new MyRandom();
        int k = rnd.getRandomDoubleBetweenRange(1,100);
        int x=rnd.getRandomDoubleBetweenRange(1,100);
        if (k==x) {
            System.out.println("Первое число: "+ k+"\nВторое число: "+x);
            System.out.println("Не успешно");
        }
        else{
            System.out.println("Первое число: "+ k+"\nВторое число: "+x);
            System.out.println("Успешно");
        }
    }

    //тест на проверку метода
    @org.junit.jupiter.api.Test
    void getRandomNumberInts() {
        MyRandom rnd = new MyRandom();
        int k = rnd.getRandomNumberInts(1,100);
        int x=rnd.getRandomNumberInts(1,100);
        if (k==x) {
            System.out.println("Первое число: "+ k+"\nВторое число: "+x);
            System.out.println("Не успешно");
        }
        else{
            System.out.println("Первое число: "+ k+"\nВторое число: "+x);
            System.out.println("Успешно");
        }
    }

    //тест на проверку двух методов
    @org.junit.jupiter.api.Test
    void comparisonOfNumber() {
        MyRandom rnd = new MyRandom();
        int k = rnd.getRandomDoubleBetweenRange(1,100);
        int x=rnd.getRandomNumberInts(1,100);
        if (k==x) {
            System.out.println("Первое число: "+ k+"\nВторое число: "+x);
            System.out.println("Не успешно");
        }
        else{
            System.out.println("Первое число: "+ k+"\nВторое число: "+x);
            System.out.println("Успешно");
        }
    }
}