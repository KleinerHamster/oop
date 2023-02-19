package com.company;

import java.util.Random;


//класс для рандомного числа
public class MyRandom{

    //метод получения случайного числа с плавающей  точкой
    public static double getRandomNumber(){
        double x = Math.random();
        return x;
    }

    //метод получения случайного целого числа с методом Math.random()
    public static int getRandomDoubleBetweenRange(int min, int max){
        return (int) ((Math.random()*((max-min)+1))+min);
    }

    //метод получения случайного целого числа с методом random.ints
    public static int getRandomNumberInts(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }

}
