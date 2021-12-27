package com.pb.bazeluk.hw11;

import java.time.LocalDate;
import java.util.*;


public class mains {
    public static void main(String[] args)  throws Exception  {

        Scanner scanner = new Scanner(System.in);
        Phonebook phonebook = new Phonebook();
        while (true) {
            System.out.println("====================Телефонная книга====================");
            System.out.println(" ______________________________________________________");
            System.out.println("| Commands |                  Actions                  |");
            System.out.println("|__________|___________________________________________|");
            System.out.println("|  new     | Создание нового контакта                  |");
            System.out.println("|  del     | Удаление контакта                         |");
            System.out.println("|  search  | Поиск контакта                            |");
            System.out.println("|  print   | Вывод всех контактов                      |");
            System.out.println("|  change  | Изменение контакта                        |");
            System.out.println("|  read    | Чтение контактов                          |");
            System.out.println("|  write   | Запись контактов                          |");
            System.out.println("|  exit    | Выход                                     |");
            System.out.println("|______________________________________________________|");
            System.out.print(  "Введите команду:");
        switch (scanner.nextLine()){
            case "new" :
                System.out.println("==============Создание нового контакта=============");
                phonebook.newUser();
                break;
            case "del" :
                String s;
                while (true) {
                    System.out.println("=================Удаление контакта=================");
                    ArrayList<User> usersDel = phonebook.searchUser();
                    System.out.println("==============Контакты на удаление=================");
                    phonebook.print(usersDel);
                    System.out.println("Подтвердите удаление контактов(Y - удалить/N - отмена(Выход)/R - повторить поиск)");
                    do {
                        s = scanner.nextLine();
                    } while (!Objects.equals(s, "Y") && !Objects.equals(s, "N") && !Objects.equals(s, "R"));
                    if (Objects.equals(s,"Y")){
                       phonebook.deleteUser(usersDel);
                    }else if(Objects.equals(s,"N"))  break;
                }
                break;
            case "search" :
                System.out.println("===================Поиск контакта==================");
               phonebook.print(phonebook.searchUser());
                break;
            case "print" :
                while (true) {
                    System.out.println("====================Выберите поле для фильтрации====================");
                    System.out.println(" ______________________________________________________");
                    System.out.println("|  Field   |              Description                  |");
                    System.out.println("|__________|___________________________________________|");
                    System.out.println("|  FIO     | ФИО пользователей                         |");
                    System.out.println("|  BDate   | Дата рождения пользователей               |");
                    System.out.println("|  exit    | Выход                                     |");
                    System.out.println("|______________________________________________________|");
                    System.out.print("Введите поле для поиска:");
                    String in = scanner.nextLine();
                    switch (in) {
                        case "FIO":
                            System.out.println("=================Вывод всех контактов по FIO==============");
                            phonebook.getUsers().sort(new Comparator<User>() {
                                @Override
                                public int compare(User a, User b) {
                                    return a.getFio().compareTo(b.getFio());
                                }
                            });
                            phonebook.print(phonebook.getUsers());
                            break;
                        case "BDate":
                            System.out.println("=================Вывод всех контактов по BDate==============");
                            phonebook.getUsers().sort(new Comparator<User>() {
                                @Override
                                public int compare(User a, User b) {
                                    return a.getbDay().compareTo(b.getbDay());
                                }
                            });
                            phonebook.print(phonebook.getUsers());
                            break;
                        case "exit":
                            break;
                        default:
                            System.out.println("Команда не распознана!");
                            break;
                    }
                    if (Objects.equals(in,"exit")) break;
                }
                break;
            case "change" :
                System.out.println("=================Изменение контакта================");
                while (true){
                    ArrayList<User> user = phonebook.searchUser();
                    System.out.println("Выберите поле для редактирования fio|bDay|phones|address\nExit - выход");
                    String in = scanner.nextLine();
                    boolean exit = false;
                    switch (in){
                        case "fio":
                            System.out.println("Введите новое FIO");
                            user.stream().forEach(x-> x.setFio(scanner.nextLine()));
                            break;
                        case "bDay":
                            System.out.println("Введите дату рождения:");
                            int YYYY,MM,DD;
                            System.out.print("Год рождения: ");
                            YYYY = scanner.nextInt();
                            System.out.print("Месяц рождения: ");
                            MM = scanner.nextInt();
                            System.out.print("День рождения: ");
                            DD = scanner.nextInt();
                            user.stream().forEach(x->x.setbDay(LocalDate.of(YYYY, MM, DD)));
                            break;

                        case "phones":
                            user.stream().forEach(x->x.setPhones(x.getPhones()));
                            break;
                        case "address":
                            user.stream().forEach(x->x.setAddress(x.getAddress()));
                            break;
                        case "exit":
                            exit = true;
                            break;
                        default:
                            System.out.println("Не верный ввод!");
                            break;
                    }
                    if (exit) break;
                }
                break;
            case "read" :
                System.out.println("=================Чтение контактов==================");
                phonebook.fromFile();
                System.out.println(phonebook.getUsers().toString());
                phonebook.print(phonebook.getUsers());
                System.out.println("=================Чтение контактов==================");
                break;
            case "write" :
                System.out.println("==================Запись контактов=================");
                phonebook.toFile();
                break;
            case "exit" :
                System.out.println("========================Выход=======================");
                System. exit(0);
                break;
            default: break;
        }
        }


    }
}
