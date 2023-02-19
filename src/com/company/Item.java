package com.company;

//класс элемент для заполнения файла
public class Item {

    private String item;

    //геттеры и сеттеры
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    //конструкторы
    public Item(String item) {
        setItem(item);
    }

    public Item(){}

    //метод для генерации случайных чисел
    public String randomItem(){
        MyRandom random = new MyRandom();
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        StringBuilder salt = new StringBuilder();

        while (salt.length() < random.getRandomDoubleBetweenRange(1, 10)) {
            int index = (int) (random.getRandomNumber() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        return String.valueOf(salt);
    }
}
