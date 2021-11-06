package com.pb.bazeluk.hw6;

import java.util.Locale;
import java.util.Objects;

public class Cat extends Animal{
    private int lifeСount = 9;
    private boolean purity;

    public Cat(String food){
        super(food);
    }
    public Cat(String food, Locale locale){
        super(food,locale);
    }

    //переопределенные методы класса "Animal"
    @Override
    public void makeNoise(){
        System.out.println("Кот шумит в " + this.getLocation().getDisplayCountry() + " на языке " + this.getLocation().getDisplayLanguage());

    }
    @Override
    public void eat(){
        System.out.println("Кот ест " + this.getFood());
    }
    @Override
    public void sleep(){
        System.out.println("Кот спит в " + this.getLocation().getDisplayCountry());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return    Objects.equals(getFood(),cat.getFood())
                && Objects.equals(getLocation(),cat.getLocation())
                && lifeСount== lifeСount
                && purity == cat.purity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lifeСount,purity,getFood(),getLocation());
    }

    @Override
    public String toString() {
        return "dog {" +
                "lifeСount='" + lifeСount + '\'' +
                ", purity=" + purity + '\'' +
                ", food=" + getFood() + '\'' +
                ", location=" + getLocation()  +
                '}';
    }
    // новый метод класса Cat
    public void highFalling(int high) {
        if (this.lifeСount <= 0){
            System.out.println("Хватит мучить кошку! Она мертва...");
            return;
        }
        this.lifeСount -= (int) (Math.random() * high);
        if (this.lifeСount > 0) {
            System.out.println("Кошка упала с высоты " + high + " метров и выжила. Осталось " + this.lifeСount + " жизней.");
        } else {
            System.out.println("Кошке не повезло, жизни закончились");
        }
    }

    //геттеры сеттеры
    public int getLifeСount() {
        return lifeСount;
    }

    public boolean getPurity() {
        return purity;
    }

    public void setPurity(boolean purity) {
        this.purity = purity;
    }
}
