package com.pb.bazeluk.hw9;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileNumbers {

    public static Path createNumbersFile() {
        Path path = Paths.get("TestFiles", "numbers.txt");
        try {
            Files.createFile(path);
            System.out.println("Файл " + path.toAbsolutePath() + " успешно создан!");
        } catch (FileAlreadyExistsException e) {
            System.out.println("Файл " + path.toAbsolutePath() + " уже существует, и будет перезаписан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Random random = new Random();
        StringBuilder s= new StringBuilder();
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            for (int i = 0; i < 10; i++) {

                for (int j = 0; j < 10; j++) {
                    s.append((random.nextInt(100)));
                    s.append(" ");
                }
                s.append("\n");
                writer.write(s.toString());
                s.delete(0,s.length());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return path;
    }

    public static Path createOddNumbersFile(Path path){
        Path pathOdd = Paths.get(String.valueOf(path.getParent()), "odd-numbers.txt");
        try(BufferedReader reader = Files.newBufferedReader(path)){
           String string;
            StringBuilder forFiles = new StringBuilder();
           String [][] strings = new String[10][10];
           int i =0;

           //запись в файл
            try (BufferedWriter writer = Files.newBufferedWriter(pathOdd)) {
            while((string = reader.readLine())!= null){
                forFiles.setLength(0);
                strings[i] = string.split("\\s");
                for (int j=0; j<strings[i].length; j++){
                    if (Integer.parseInt(strings[i][j])%2 == 0) forFiles.append("0 ");
                    else {
                        forFiles.append(strings[i][j]);
                        forFiles.append(" ");
                    }
                }
                System.out.println(forFiles);
                forFiles.append("\n");
                writer.write(forFiles.toString());
                i++;
            }
            }catch (Exception e){
                e.printStackTrace();
            }

        }catch(Exception e){
        e.printStackTrace();
        }
        return pathOdd;
    }



    public static void main(String[] args) {

    Path path=createNumbersFile();
        System.out.println("Исходный файл лежит в "+path.toAbsolutePath());
    Path pathOdd = createOddNumbersFile(path);
        System.out.println("Результирующий файл лежит в "+pathOdd.toAbsolutePath());

    }
}
