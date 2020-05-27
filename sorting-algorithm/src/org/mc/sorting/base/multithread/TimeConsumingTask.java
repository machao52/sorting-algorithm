package org.mc.sorting.base.multithread;

/**
 * @author machao
 * @date 2020/5/27
 */
public class TimeConsumingTask implements Runnable {

    private  boolean toCancel = false;

    public boolean isToCancel() {
        return toCancel;
    }

    public void setToCancel(boolean toCancel) {
        this.toCancel = toCancel;
    }

    @Override
    public void run() {
        while (!toCancel) {
            if (doExecute()) {
                break;
            }
        }
    }

    public boolean doExecute() {
        //有这个打印语句正常退出，没有就死循环
        //System.out.println("executing");
        return false;
    }

    public void cancel() {
        toCancel = true;
        System.out.println(this + "canceled");
    }

    public static void main(String[] args) throws InterruptedException {
       // System.out.println(System.getProperty("java.vm.name"));
        TimeConsumingTask timeConsumingTask=new TimeConsumingTask();
        Thread thread=new Thread(timeConsumingTask);
        thread.start();
        Thread.sleep(1000);
        timeConsumingTask.cancel();


    }
}
