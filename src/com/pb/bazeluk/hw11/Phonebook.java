package com.pb.bazeluk.hw11;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;


public class Phonebook {
    /*---------------------------------------
    Создание
     ----------------------------------------*/
    public static ResidenceAddress newAddr(){
       Scanner scanner = new Scanner(System.in);
         String country;
         String town;
         String street;
         short nHouse;
         String entrance;
        short apartment;

        System.out.println("Ввод адреса проживания пользователя.");
        System.out.print("Страна: ");
        country = scanner.nextLine();
        System.out.print("Горорд: ");
        town = scanner.nextLine();
        System.out.print("Улица: ");
        street = scanner.nextLine();
        System.out.print("дом: ");
        nHouse = scanner.nextShort();
        System.out.print("Подъезд: ");
        entrance = scanner.next();
        System.out.print("Квартира: ");
        apartment = scanner.nextShort();

       return new ResidenceAddress(country,town,street,nHouse,entrance,apartment);
    }

    public static HashMap<PhoneType,String> newPhones(){
        Scanner scanner = new Scanner(System.in);
        HashMap<PhoneType,String> phone = new HashMap<>();
        while (true){

            System.out.println("Введите тип телефона: MOB, HOME, WORK!");
            if (phone.size()>0) System.out.println("Что бы завершить ввод введите EXIT!");
            String s =scanner.nextLine() ;
            switch (s) {
                case "MOB": {
                    System.out.print("Введите мобильный номер телефона: ");
                    phone.put(PhoneType.MOB,scanner.nextLine());
                    break;
                            }

                case "HOME": {
                    System.out.print("Введите домашний номер телефона: ");
                    phone.put(PhoneType.HOME,scanner.nextLine());
                    break;
                            }
                case "WORK": {
                    System.out.print("Введите рабочий номер телефона: ");
                    phone.put(PhoneType.WORK,scanner.nextLine());
                    break;
                             }
                default:{
                    System.out.println("Тип телефона введен не коректно!");
                    break;
                         }
            }
            if ((Objects.equals(s,"EXIT"))&&phone.size()>0) break;
        }
        return phone;
    }
    public static void newUser(ArrayList<User> phonebook){
        Scanner scanner = new Scanner(System.in);
        String fio;
        int YYYY,MM,DD;
        System.out.println("Добавление нового пользователя в Телефонную книгу:");
        System.out.print("Введите ФИО: ");
        fio= scanner.nextLine();
        System.out.print("Год рождения: ");
        YYYY = scanner.nextInt();
        System.out.print("Месяц рождения: ");
        MM = scanner.nextInt();
        System.out.print("День рождения: ");
        DD = scanner.nextInt();
        phonebook.add(new User(fio, LocalDate.of(YYYY, MM, DD),newPhones(),newAddr()));
    }

    /*---------------------------------------
    Поиск
    ----------------------------------------*/

    public static ArrayList<User> searchUserFIO(ArrayList<User> phonebooks){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО для поиска:");
        String fio= scanner.nextLine();
        ArrayList<User> searchUsers=new ArrayList<>();
        phonebooks.stream()
                .filter(x -> Objects.equals(fio,x.getFio()))
                .forEach(searchUsers::add);
        return searchUsers;
    }


    public static ArrayList<User> searchUserPhone(ArrayList<User> phonebooks){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите Phone для поиска:");
        String phone= scanner.nextLine();
        ArrayList<User> searchUsers=new ArrayList<>();
        phonebooks.stream()
                .filter(x -> x.getPhones().containsValue(phone))
                .forEach(searchUsers::add);
        return searchUsers;
    }

     /*---------------------------------------
    Удаление
    ----------------------------------------*/

    public static void deleteUser(ArrayList<User> phonebooks,ArrayList<User> delete){
        delete.stream().forEach(phonebooks::remove);
        System.out.println("Удалены элементы: \n" + delete.toString());
    }

     /*---------------------------------------
    Сортировкой
    ----------------------------------------*/
     static class UserFIOComparator implements Comparator<User> {

         public int compare(User a, User b) {
             return a.getFio().substring(0,1).compareTo(b.getFio().substring(0,1));
         }
     }

    static class UserAgeComparator implements Comparator<User> {

        public int compare(User a, User b) {
                return a.getbDay().compareTo(b.getbDay());
        }
    /*---------------------------------------
    Запись в файл
    ----------------------------------------*/
   public static String serializationUser(ArrayList<User> phonebooks) throws Exception{
        String rez = new String();
       ObjectMapper mapper = new ObjectMapper();
       // pretty printing (json с отступами)
       mapper.enable(SerializationFeature.INDENT_OUTPUT);

       // для работы с полями типа LocalDate
       SimpleModule module = new SimpleModule();
       module.addSerializer(LocalDate.class, new LocalDateSerializer());
       module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
       mapper.registerModule(module);
       return  mapper.writeValueAsString(phonebooks);
   }

   // Запись
        public static void toFile(ArrayList<User> phonebooks) throws Exception {

            File file = Paths.get("TestFiles/Users.data").toFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            // сохраняем в файл
            objectOutputStream.writeObject(serializationUser(phonebooks));

            //закрываем поток и освобождаем ресурсы
            objectOutputStream.close();
        }

        //Чтение
        public static ArrayList<User> fromFile() throws Exception {
            ObjectMapper mapper = new ObjectMapper();
            // pretty printing (json с отступами)
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            // для работы с полями типа LocalDate
            SimpleModule module = new SimpleModule();
            module.addSerializer(LocalDate.class, new LocalDateSerializer());
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
            mapper.registerModule(module);


            File file = Paths.get("TestFiles/Users.data").toFile();
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            String users = (String) objectInputStream.readObject();
            return mapper.readValue(users,ArrayList.class);
        }


        public static void main(String[] args) throws Exception {
            UserFIOComparator uFIOComp = new UserFIOComparator();
            UserAgeComparator uAgeComp = new UserAgeComparator();
            ArrayList<User> phonebooks = new ArrayList<>();
            //newUser(phonebooks); // ручное создание пользователей


            HashMap<PhoneType, String> phones1 = new HashMap<>();
            phones1.put(PhoneType.MOB, "0977503107");
            phones1.put(PhoneType.HOME, "04450549");
            User user1 = new User("Базелюк В.В"
                    , LocalDate.of(1994, 3, 27)
                    , phones1
                    , new ResidenceAddress("Украина"
                    , "Днепр"
                    , "Ермоловой"
                    , (short) 46
                    , (short) 3)
            );

            HashMap<PhoneType, String> phones2 = new HashMap<>();
            phones2.put(PhoneType.MOB, "0953967105");
            phones2.put(PhoneType.HOME, "04450549");
            User user2 = new User("Базелюк Я.О"
                    , LocalDate.of(1993, 6, 7)
                    , phones2
                    , new ResidenceAddress("Украина"
                    , "Днепр"
                    , "Ермоловой"
                    , (short) 46
                    , (short) 3)
            );

            User user3 = new User("Caльник Я.О"
                    , LocalDate.of(1993, 5, 7)
                    , phones2
                    , new ResidenceAddress("Украина"
                    , "Днепр"
                    , "Ермоловой"
                    , (short) 46
                    , (short) 3)
            );


            phonebooks.add(user1);
            phonebooks.add(user3);
            phonebooks.add(user2);
            System.out.println("Все пользователи");
            System.out.println(phonebooks.toString());
            System.out.println("Запись в файл");
            toFile(phonebooks);
            System.out.println("Файл записан");

            System.out.println("Чтение с файла");
            ArrayList<User> phonebookDeserial = fromFile();
            System.out.println("Файл прочитан");
            System.out.println(phonebookDeserial.toString());

            System.out.println("Сортированные пользователи по ФИО пользователи");
            phonebooks.sort(uFIOComp);
            System.out.println(phonebooks.toString());
            System.out.println("Сортированные пользователи по дате рождения пользователи");
            phonebooks.sort(uAgeComp);
            System.out.println(phonebooks.toString());
            System.out.println("Найденные пользователи");
            System.out.println(searchUserPhone(phonebooks).toString());
            System.out.println("Удаляем елемент");
            deleteUser(phonebooks, searchUserPhone(phonebooks));
            System.out.println("Исходный справочник после удаления");
            System.out.println(phonebooks.toString());

            /*
             */


        }
    }
}
