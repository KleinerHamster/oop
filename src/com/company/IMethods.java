package com.company;

import java.util.ArrayList;

public interface IMethods {

    //метод удаления повторяющихся эл-тов
    default ArrayList<Item> removeDuplicate(ArrayList<Item> items) {
        for (int i = 0; i < items.size() - 1; i++) {
            //начинаем переход вперед из списка с индексом list.size () - 1
            for (int j = items.size() - 1; j > i; j--) {
                //сравнение эл-тов
                if (items.get(j).getItem().equals(items.get(i).getItem())) {
                    //удалем дублирующий эл-т
                    items.remove(j);
                }
            }
        }
        return items;
    }

    //метод для проверки остатка от 4
    default ArrayList<Item> remainderOfDivision(ArrayList<Item> items) {
        ArrayList<Item> items1 = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (isNumeric(items.get(i).getItem()) && Integer.parseInt(items.get(i).getItem()) % 4 == 3) {
                items1.add(items.get(i));
            } else if (items.get(i).getItem().length() % 4 == 3) {
                items1.add(items.get(i));
            }
        }
        return items1;
    }

    //метод проверка строки на число
    static boolean isNumeric(final String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}