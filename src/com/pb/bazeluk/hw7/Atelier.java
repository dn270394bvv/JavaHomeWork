package com.pb.bazeluk.hw7;

/**
 * @author Vasiliy
 * Домашнее задание к лекции 7
 */
public class Atelier {

    /**
     * Перечисление для размеров одежды
     */
    public enum Size {
        XXS(32,"Детский размер"),
        XS(34,"Взрослый размер"),
        S(36,"Взрослый размер"),
        M(38,"Взрослый размер") ,
        L(40,"Взрослый размер");

        private final int euroSize;
        private final String description;

        /**
         * Констрруктор размеров
         * @param euroSize - размер в евро формате
         * @param description - описание размера
         */
        Size(int euroSize,String description) {
            this.description = description;
            this.euroSize = euroSize;
        }

        /**
         * Получение описания размера
         * @param size - размер типа Size
         */
        public void getDescription(Size size){
            System.out.println(size.description);
        }
        public int getEuroSize(Size size){
            return size.euroSize;
        }
    }

    /**
     * Класс Clothes - абстракция для будущих классов Tshirt, Pants, Skirt, Tie
     */
    //Абстрактный класс
   public abstract class  Clothes{
        Size size;
        double price;
        String color;
    }

    /**
     * Интерфейс ManClothes  для будущих классов мужской одежды
     */
    // Интерфейс для одеть мужчину
    public interface ManClothes {
        void dressMan();
    }
    /**
     * Интерфейс WomenClothes для будущих классов женской одежды
     */
    // Интерфейс для одеть женщину
    public interface WomenClothes {
        void dressWomen();
    }

    /**
     * Реализация абстракции Clothes, WomenClothes, ManClothes
     */
    // футболка
    public class Tshirt extends  Clothes implements ManClothes,WomenClothes {
        // конструктор

        /**
         * Конструктор футболок
         * @param size - размер типа Size
         * @param price - цена
         * @param color - цвет
         */
        public Tshirt (Size size, double price, String color){
            super.color =  color;
            super.size = size;
            super.price = Math.abs(price);
        }

        @Override
        public void dressMan() {
            System.out.println("Мужская футболка\nРазмер: " + this.size + "("+this.size.getEuroSize(size)+")" + "\nЦвет: "+this.color+"\nЦена: "+ this.price);
        }
        @Override
        public void dressWomen(){
            System.out.println("Женская футболка\nРазмер: " + this.size + "("+this.size.getEuroSize(size)+")" +  "\nЦвет: "+this.color+"\nЦена: "+ this.price);
        }
    }
    /**
     * Реализация абстракции Clothes, WomenClothes, ManClothes
     */
    //штаны
  public class Pants extends  Clothes implements ManClothes,WomenClothes {
        /**
         * Конструктор штанов
         * @param size - размер типа Size
         * @param price - цена
         * @param color - цвет
         */
        public Pants (Size size, double price, String color){
            super.color =  color;
            super.size = size;
            super.price = Math.abs(price);
        }

        @Override
        public void dressMan() {
            System.out.println("Мужские штаны\nРазмер: " + this.size + "("+this.size.getEuroSize(size)+")" + "\nЦвет: "+this.color+"\nЦена: "+ this.price);
        }
        @Override
        public void dressWomen(){
            System.out.println("Женские штаны\nРазмер: " + this.size + "("+this.size.getEuroSize(size)+")" + "\nЦвет: "+this.color+"\nЦена: "+ this.price);
        }
    }
    /**
     * Реализация абстракции Clothes, WomenClothes
     */
    //юбка
    public class Skirt extends  Clothes implements WomenClothes {
        /**
         * Конструктор юбок
         * @param size - размер типа Size
         * @param price - цена
         * @param color - цвет
         */
        public Skirt (Size size, double price, String color){
            super.color =  color;
            super.size = size;
            super.price = Math.abs(price);
        }

        @Override
        public void dressWomen(){
            System.out.println("Женская юбка\nРазмер: " + this.size + "("+this.size.getEuroSize(size)+")" + "\nЦвет: "+this.color+"\nЦена: "+ this.price);
        }
    }
    /**
     * Реализация абстракции Clothes, ManClothes
     */
    //галстук
    public class Tie extends  Clothes implements ManClothes {
        /**
         * Конструктор галстуков
         * @param size - размер типа Size
         * @param price - цена
         * @param color - цвет
         */
        public Tie (Size size, double price, String color){
            super.color =  color;
            super.size = size;
            super.price = Math.abs(price);
        }

        @Override
        public void dressMan() {
            System.out.println("Мужской галстук\nРазмер: " + this.size + "("+this.size.getEuroSize(size)+")" + "\nЦвет: "+this.color+"\nЦена: "+ this.price);
        }
    }

    /**
     * реализация статического метода для вывода информации о мужской одежде
     * @param clothes - массив одежды
     */
    public static void dressMan(Atelier.Clothes[] clothes){
        System.out.println("Демонстрация мужской одежды:");
        for (Atelier.Clothes clothes1:clothes){
            if (clothes1 instanceof Atelier.ManClothes){
                ((ManClothes) clothes1).dressMan();
            }
        }
    }
    /**
     * реализация статического метода для вывода информации о женской одежде
     * @param clothes - массив одежды
     */
    public static void dressWomen(Clothes[] clothes){
        System.out.println("Демонстрация женской одежды:");
        for (Atelier.Clothes clothes1:clothes){
            if (clothes1 instanceof Atelier.WomenClothes){
                ((WomenClothes) clothes1).dressWomen();
            }
        }
    }

        public static void main(String[] args) {
        Clothes[] clothes = {new Atelier().new Pants(Size.XXS,100.50,"red")
                            ,new Atelier().new Tshirt (Size.XS,100,"white")
                            ,new Atelier().new Skirt (Size.L,34.50,"blue")
                            ,new Atelier().new Tie (Size.S,15.96,"black")
                            ,new Atelier().new Tie (Size.M,20.96,"yellow")
                            };
        Atelier.dressMan(clothes);
        System.out.println("---------------------------------");
        Atelier.dressWomen(clothes);
    }
}
