package com.pb.bazeluk.hw11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class Phonebook {

    private final  List<User> users = new ArrayList<>();

    public Phonebook() {
    }

    public List<User> getUsers() {
        return users;
    }



    /*---------------------------------------
    Создание (обновлено)
     ----------------------------------------*/
    public ResidenceAddress newAdr(){
       Scanner scanner = new Scanner(System.in);
         String country;
         String town;
         String street;
         short nHouse;
         String entrance;
        short apartment;

        System.out.println("Укажите адрес проживания пользователя:");
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

    public  List<String> newPhones(){
        Scanner scanner = new Scanner(System.in);
        List<String> phone = new ArrayList<>();
        while (true){
            System.out.print("Введите мобильный номер телефона: ");
            if (phone.size()>0) System.out.println("(Для завершения введите exit)");
            else System.out.println();
            String s =scanner.nextLine() ;
            if (Objects.equals(s,"exit")) break;
            phone.add(s);
            }
        return phone;
    }
    public  void newUser(){
        Scanner scanner = new Scanner(System.in);
        String fio;
        int YYYY,MM,DD;
        System.out.print("Введите ФИО: ");
        fio= scanner.nextLine();
        System.out.print("Год рождения: ");
        YYYY = scanner.nextInt();
        System.out.print("Месяц рождения: ");
        MM = scanner.nextInt();
        System.out.print("День рождения: ");
        DD = scanner.nextInt();
        this.users.add(new User(fio, LocalDate.of(YYYY, MM, DD),newAdr(),newPhones()));
    }

    /*---------------------------------------
    Поиск (исправлен)
    ----------------------------------------*/
    public  ArrayList<User> searchUser(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> searchUsers=new ArrayList<>();
        while (true) {
            System.out.println("====================Выберите поле для поиска====================");
            System.out.println(" ______________________________________________________");
            System.out.println("|  Field   |              Description                  |");
            System.out.println("|__________|___________________________________________|");
            System.out.println("|  FIO     | ФИО пользователя                          |");
            System.out.println("|  Phone   | Контакт пользователя                      |");
            System.out.println("|  exit    | Выход                                     |");
            System.out.println("|______________________________________________________|");
            System.out.print("Введите поле для поиска:");
        switch (scanner.nextLine()){
            case "FIO":
                System.out.print("Введите FIO:");
                String fio= scanner.nextLine();
                this.users.stream()
                        .filter(x -> x.getFio().contains(fio))
                        .forEach(searchUsers::add);
                return searchUsers;
            case "Phone":
                System.out.print("Введите Phone:");
                String phone= scanner.nextLine();
                this.users.stream().filter(x->x.getPhones().contains(phone)).forEach(searchUsers::add);
                return searchUsers;
            case "exit":
                System.out.print("====================Поиск завершен====================");
                return searchUsers;
            default:
                System.out.print("=======Поиск по указанному полю не предусмотрен!======");
                break;
        }
        }
    }
        /*---------------------------------------
    Вывод елементов (Исправлено)
     ----------------------------------------*/
    public void print(List<User> users){
        System.out.println("============================================Пользователи============================================");
        System.out.println(" ________________________________________________________________________________________________________________________________");
        System.out.println("|               |               |             |                                                        |        Последнея        |");
        System.out.println("|      ФИО      | Дата рождения |    Номер    |                    Адрес проживания                    |       модификация       |");
        System.out.println("|_______________|_______________|_____________|________________________________________________________|_________________________|");
        for (User userTMP : users) {
            System.out.printf("|%15s|%15s|%13s|%56s|%25s"
                    , userTMP.getFio()
                    , userTMP.getbDay().toString()
                    , userTMP.getPhones().get(0)
                    , userTMP.getAddress()
                    , userTMP.getChange().toString() + "|\n");
                for (String s : userTMP.getPhones().subList(1,userTMP.getPhones().size())) {
                    System.out.printf("|%15s|%15s|%13s|%56s|%25s"
                            , ""
                            , ""
                            , s
                            , ""
                            , "" + "|\n");
                }
            }

        System.out.println(" |___________________________________________________________________________________________________________________________________________|");
    }


     /*---------------------------------------
    Удаление(исправлено)
    ----------------------------------------*/

    public void deleteUser(List<User> delete){

        delete.forEach(users::remove);
        System.out.println("=============Записи успешно удалены==============");
    }



    /*---------------------------------------
    Запись в файл
    ----------------------------------------*/
   // Запись
        public void toFile() throws Exception {
            SimpleModule module = new SimpleModule();
            module.addSerializer(LocalDate.class, new LocalDateSerializer());
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
            module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
            module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
           ObjectMapper objectMapper =new ObjectMapper();
            objectMapper.registerModule(module);
           String json = objectMapper.writeValueAsString(users);
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            // сохраняем в файл
            Files.write(Paths.get("TestFiles/Users.json"), json.getBytes(StandardCharsets.UTF_8));
        }

        //Чтение
        public void fromFile() throws Exception {
            SimpleModule module = new SimpleModule();
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
            module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
            ObjectMapper objectMapper =new ObjectMapper();
            objectMapper.registerModule(module);
            byte[] bytesData = Files.readAllBytes(Paths.get("TestFiles/Users.json"));
            List<User> users1 =objectMapper.readValue(bytesData, new TypeReference<List<User>>() {});
           this.users.clear();
            this.users.addAll(users1);

        }
    }