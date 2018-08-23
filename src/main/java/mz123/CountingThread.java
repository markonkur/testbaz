package mz123;

public class CountingThread extends Thread{
    public void run(){
        for (int i = 0; i<10; i++){
            System.out.println((Thread.currentThread().getName() + ": " + i));
        }
    }
}
