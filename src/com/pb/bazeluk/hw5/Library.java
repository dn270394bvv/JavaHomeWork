package com.pb.bazeluk.hw5;


public class Library {
    public static void main(String[] args) {
        Book[] books = {new Book("Приключения", "Иванов И. И.", 2000)
                , new Book("Словарь", "Сидоров А. В", 1980)
                , new Book("Энциклопедия", "Гусев К. В.", 2010)};

        Reader[] readers = {new Reader("Серчук И.И", "2000-01-25")
                , new Reader("Савин И.И", "2000-01-25", "+380977503107")
                , new Reader("Кобчек И.И", "2000-01-25", "+380674650105", "МЭО")};
        readers[1].setFaculty("Автоматизация");
        readers[0].setPhone("+0234211231");
        print(books);
        print(readers);

        //тест методов методов takeBook
        readers[0].takeBook(books.length);
        readers[1].takeBook(getName(books));
        readers[2].takeBook(books);

        //тест методов returnBook
        readers[0].returnBook(books.length);
        readers[1].returnBook(getName(books));
        readers[2].returnBook(books);

    }
    private static String[] getName(Book... books){
        String[] result = new String[books.length];
        for (int i=0;i< books.length;i++) result[i]=books[i].getName();
    return result;
    }

    private static void print(Book... books){
        System.out.println("Информация о книгах:");
        for (Book book:books) System.out.println(book.getName() + "(" + book.getAuthor() + " " + book.getAuthor() + book.getYear() + " г.)");
    }
    private static void print(Reader... readers){
        System.out.println("Данные о пользователям:");
        for (Reader reader:readers) System.out.println("Читательский билет номер: "+ reader.getLibraryTicket()
                + ", ФИО: " + reader.getFullName()
                + ", контактный номер: " + reader.getPhone()
                + ", дата рождения: " + reader.getDateBirth()
                + ", факультет: " + reader.getFaculty());
    }
}
