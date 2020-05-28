package org.mc.sorting.base.multithread;

/**
 * @author machao
 * @date 2020/5/27
 */
public class ThreadStartVisibility {

    static int data = 0;

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000;i++){
            Thread thread = new Thread() {
                @Override
                public void run() {
                    System.out.println("子线程：" + data);
                }
            };
            data=1;
            thread.start();
            data = 2;
        }

    }

}
