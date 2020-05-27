package org.mc.sorting.base.multithread;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author machao
 * @date 2020/5/27
 */
public class NonAtomicDemo implements Runnable {

    static long value = 0;
    private final long valueToSet;

    public NonAtomicDemo(long valueToSet) {
        this.valueToSet = valueToSet;
    }



    public static void main(String[] args) {
        Thread thread1 = new Thread(new NonAtomicDemo(0L));
        Thread thread2 = new Thread(new NonAtomicDemo(-1L));

        PrintStream printStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        });

        thread1.start();
        thread2.start();

        long snapshot;
        while (0 == (snapshot = value) || -1 == snapshot) {
            printStream.print(snapshot);
        }
        System.err.printf("data: %d(0x%016x)", snapshot, snapshot);
        printStream.close();
        System.exit(0);
    }

    @Override
    public void run() {
        for (; ; ) {
            value = valueToSet;
        }
    }
}
