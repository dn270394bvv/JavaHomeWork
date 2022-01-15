package com.pb.bazeluk.hw15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws Exception {
        System.out.println("Стартовал сервер-чат!");
        int port = 48654;

        ServerSocket server = null;
        Socket clientSocket = null;


        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Ошибка связывания с портом 1234");
            System.exit(-1);
        }

        try {
            System.out.println("Ждем соединения");
            clientSocket = server.accept();
            System.out.println("Клиент подключился");
        } catch (IOException e) {
            System.out.println("Не могу установить соединение");
            System.exit(-1);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));;
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String clientMessage;
        String clientName = "Client_N";
        // цикл ожидания сообщений от клиента

        System.out.println("Ожидаем сообщений");
        Chat chat1 = new Chat();
        while ((clientMessage = in.readLine()) != null) {
            chat1.setMessages(new Message(clientName,clientMessage));
            System.out.println(clientMessage);
            out.println("Сервер: " + chat1);
            if ("exit".equalsIgnoreCase(clientMessage)) {
                break;
            }
        }

        // Закрываем все соединения
        out.close();
        in.close();
        clientSocket.close();
        server.close();


    }
}
