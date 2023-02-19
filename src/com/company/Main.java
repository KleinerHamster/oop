package com.company;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        //считывание строки
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вы хотите работать\n1 - с файлами\n2 - c базой данных\n");
        System.out.print("Выбирите:");
        int k=Integer.parseInt(scanner.nextLine());
        if (k!=2) {
            System.out.println("Введите путь к каталогу, в котором находятся текстовые файлы:");
            String path=scanner.nextLine();
            FILESA file = new FILESA(path);
            file.fillFile();//создаем файлы по пути
            TimeUnit.SECONDS.sleep(15);
            file.writeAnswer(file.readTheFile());//считываем из файла и записываем ответ

        }
        else{
            WorkDB dbW= new WorkDB();
            dbW.insertDB();
        }
    }
}
