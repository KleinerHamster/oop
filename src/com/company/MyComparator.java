package com.company;

import java.util.Comparator;

//класс для сравнения эл-тов
class MyComparator implements Comparator<Item> {

    //метод для сортировки по убыванию
    public int compare(Item s1, Item s2)
    {
        return s1.getItem().compareTo(s2.getItem());
    }
}
