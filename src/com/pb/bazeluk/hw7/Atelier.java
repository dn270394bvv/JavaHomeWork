package com.pb.bazeluk.hw7;

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
        Size(int euroSize,String description) {
            this.description = description;
            this.euroSize = euroSize;
        }

        public void getDescription(Size size){
            System.out.println(size.description);
        }
        public int getEuroSize(Size size){
            return this.euroSize;
        }
    }

    /**
     * Абстракция для будущих классов
     */
    //Абстрактный класс
   public abstract class  Clothes{
        Size size;
        double price;
        String color;
    }

    // Интерфейс для одеть мужчину
    public interface ManClothes {
        void dressMan();
    }

    // Интерфейс для одеть женщину
    public interface WomenClothes {
        void dressWomen();
    }

    /**
     * Реализация абстракции
     */

    // футболка
    public class Tshirt extends  Clothes implements ManClothes,WomenClothes {
        // конструктор
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

    //штаны
  public class Pants extends  Clothes implements ManClothes,WomenClothes {

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

    //юбка
    public class Skirt extends  Clothes implements WomenClothes {

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

    //галстук
    public class Tie extends  Clothes implements ManClothes {

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
     * реализация статических методов
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
                            };
        Atelier.dressMan(clothes);
        System.out.println("---------------------------------");
        Atelier.dressWomen(clothes);
    }
}
