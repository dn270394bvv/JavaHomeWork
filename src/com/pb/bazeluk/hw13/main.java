package com.pb.bazeluk.hw13;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class main {
    public static void main(String[] args) {


    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    List<String> buffer = new ArrayList<String>();

    Thread producer1 = new Thread(new Producer(writeLock,buffer));
    producer1.setName("producer");

    Thread client1 = new Thread(new Client(readLock,buffer));
    client1.setName("client1");

    producer1.start();

    client1.start();
    }
}
