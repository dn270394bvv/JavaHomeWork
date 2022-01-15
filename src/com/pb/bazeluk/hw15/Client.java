package com.pb.bazeluk.hw15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;

public class Client {

    public static void main(String[] args) throws IOException {
        System.out.println("Старт клиента!");
        String ipServer = "127.0.0.1";
        int portServer = 48654;
        System.out.println("Начало связи с сервером-чатом "+ipServer+ ':'+portServer);
            Socket server  = new Socket(ipServer,portServer);

        BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(),true);
        BufferedReader  scanner = new BufferedReader(new InputStreamReader(System.in));

        String dataFromUser;


        System.out.println("Связь установлена!");
        while(true){
            System.out.print("Введите сообщение:");
            dataFromUser = scanner.readLine();
            outServer.println(dataFromUser);
            Iterator<String> iterator = inServer.lines().iterator();
            String s;
            while (iterator.hasNext()){
               s=iterator.next();
                System.out.println(s);
            }
            System.out.println("история чата напечатана");
            if ("exit".equalsIgnoreCase(dataFromUser)){
                break;
            }
        }
        outServer.close();
        inServer.close();
        server.close();
    /*Chat chat1 = new Chat();
        System.out.println(chat1);
        chat1.setMessages(new Message("user1","Hi"));
        System.out.println(chat1);
        Thread.sleep(1000);
        chat1.setMessages(new Message("user2","FU"));
        System.out.println(chat1);

     */
    }

}
