package com.pb.bazeluk.hw13;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
        private final Lock writeLock;
        private final List<String> buffer;

        public Producer(Lock writeLock, List<String> buffer) {
            this.buffer = buffer;
            this.writeLock = writeLock;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (true) {
                String s = String.valueOf(new Random().nextInt(10000));
                System.out.println(threadName + " try write lock");
                writeLock.lock();
                System.out.println(threadName + " write lock");
                if (buffer.size() < 5) {
                    buffer.add(s);
                    System.out.println(threadName + " buffer recorded - " + s + " in buffer" + buffer.toString());
                } else {
                    try {
                        int seconds = new Random().nextInt(30);
                        Thread.sleep( seconds * 1000);
                        System.out.println(threadName + " wait proofreading"+seconds+"sec");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                writeLock.unlock();
                System.out.println(threadName + " write unlock");
            }
        }
}
