package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.*;
import java.sql.DriverManager;

public class WorkDB implements IMethods{//класс для работы с БД

    //конструктор
    public WorkDB() {
    }

    //метод для создания данных
    private List<Item> createData(){
        List<Item> items=new ArrayList<>();
        MyRandom random = new MyRandom();
        int amountOfOfItems = random.getRandomDoubleBetweenRange(100, 1000);//генерируем число эл-тов в файле

        for(int i=0; i<amountOfOfItems;i++){
            Item item = new Item();
            item.setItem((item.randomItem()));
            items.add(item);
        }

        items=remainderOfDivision((ArrayList<Item>) items);//и оставляем эл-ты с остатком отделяния 3 от 4
        Collections.sort(items, new MyComparator());//сортируем в порядке убыванию

        return items;
    }

    public void insertDB(){
        List<Item> items=createData();

        try{

            //соединяемся с БД
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to the database");

            Connection connection=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dataoop","root","victoria"
            );
            System.out.println("You are now connected to the database");

            Statement query = connection.createStatement();

            query.executeUpdate("DELETE FROM dataoop.new");//удаление страрых данных
            //запись в БД
            for (int i=0; i< items.size();i++){
                query.executeUpdate("INSERT INTO dataoop.new"+"(dt)"+ "VALUES('"+items.get(i).getItem()+"')");
            }
            System.out.println("Ответ записан в БД!!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
