package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MultithreadingWritingFile implements Runnable{
    private String path;

    public MultithreadingWritingFile(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        writeToFile(path);
    }

    //метод для записи в файл
    private static void writeToFile(String path) {
        MyRandom random = new MyRandom();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path+".txt",true));

            int amountOfOfItems = random.getRandomDoubleBetweenRange(100, 1000);//генерируем число эл-тов в файле
            writer.write(amountOfOfItems+"\n");//записываем число эл-тов
            for (int i = 0; i < amountOfOfItems-1; i++) {//записываем рандомный эл-т в файл
                Item item = new Item();
                writer.write(item.randomItem() + "\n");
            }
            writer.flush();//чистка буфера
        }
        catch (IOException e) {//обработка ошибки
            e.printStackTrace();
        }
    }
}
