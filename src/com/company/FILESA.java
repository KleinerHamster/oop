package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class FILESA implements IMethods {

    private String path;

    //геттеры и сеттеры
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //конструктор
    public FILESA(String path) {
        setPath(path);
    }

    //метод заполнения файла входными данными
    public void fillFile(){
        MyRandom random = new MyRandom();
        int amountOfFiles= random.getRandomDoubleBetweenRange(2, 5);//генерируем кол-во файлов

        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);//создаем многопоточность

        for(int j=0;j<amountOfFiles;j++) {
            MultithreadingWritingFile w = new MultithreadingWritingFile(path+"/Input"+String.valueOf(j));
            Thread t = new Thread(w);
            t.setPriority(Thread.MAX_PRIORITY);
            t.start();
        }
        System.out.println("Количество записанных файлов: "+String.valueOf(amountOfFiles));
    }

    //метод чтения из файлов
    public ArrayList<Item>  readTheFile(){
        File[] filesArray = new File(path).listFiles();
        List<Item> ig=new ArrayList<>();
        List<File> files = Arrays.asList(filesArray);
        files.parallelStream()
                .forEachOrdered(x -> {
                    try(BufferedReader br1 = new BufferedReader(new FileReader(x.getPath()))){
                        String str="";//чтение построчно
                        while((str= br1.readLine())!=null){
                            ig.add(new Item(str));
                        }
                        //обработки ошибки
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("");
                });
        //удаляем поврторные эл-ты
        ArrayList<Item> items = (ArrayList<Item>) ig.stream().distinct().collect(Collectors.toList());
        items=remainderOfDivision(items);//и оставляем эл-ты с остатком отделяния 3 от 4
        Collections.sort(items, new MyComparator());//сортируем в порядке убыванию
        return items;
    }

    //метод для записи ответа
    public void writeAnswer(ArrayList<Item> items){
        try(BufferedWriter br=new BufferedWriter(new FileWriter(path+"/result.txt"))) {
            for(int i=0; i<items.size();i++){
                //записываем
                br.write(items.get(i).getItem()+"\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Результат находится в файле result в каталоге: "+getPath());
    }
}