package com.pb.bazeluk.hw13;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Client implements Runnable {
        private final Lock readLock;
        private final List<String> buffer;

        public Client(Lock readLock, List<String> buffer) {
            this.buffer = buffer;
            this.readLock = readLock;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            String s;
            while (true) {
                System.out.println(threadName + " try write lock");
                readLock.lock();
                System.out.println(threadName + " reader lock");
                if (!buffer.isEmpty()) {
                    s = buffer.get(buffer.size()-1);
                    System.out.println(threadName + " buffer read - " + s +" from buffer" + buffer.toString());
                    buffer.remove(buffer.size()-1);
                } else {

                    try {
                        int seconds = new Random().nextInt(30);
                        Thread.sleep( seconds * 1000);
                        System.out.println(threadName + " wait data "+seconds+"sec");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                readLock.unlock();
                System.out.println(threadName + " reader unlock");
            }
        }
}

