import java.util.concurrent.TimeUnit;

public class StopThread {
    public static void main(String[] args) throws InterruptedException {
        MoonRunner runnable = new MoonRunner();
        Thread thread = new Thread(runnable,"MoonThread");
        thread.start();
        TimeUnit.MILLISECONDS.sleep(10);
        thread.interrupt();
    }

    public static class MoonRunner implements Runnable {
        private long i;
        @Override
        public void run(){
            while (!Thread.currentThread().isInterrupted()) {
                i++;
                System.out.println("i=" + i);
            }
            System.out.println("stop");
        }
    }
}
