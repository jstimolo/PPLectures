import java.util.Timer;
import java.util.TimerTask;

public class Interrupt {

    public static void main(String[] args) {
        Timer timer = new Timer(); // constructor of timer starts a thread

        Thread buggyThread = new Thread(new RunnableThatTakesForever());
        buggyThread.start();
        timer.schedule(new MyTimerTask(Thread.currentThread()), 8000);

        // Main thread would be blocked forever by buggy thread
        try {
            System.out.println("Waiting for other thread");
            buggyThread.join();
        } catch (InterruptedException e) {
            // Ignore
        }
        System.out.println("Resume working");

        System.exit(0); // Also force stop buggy thread
    }

    
    private static class RunnableThatTakesForever implements Runnable {
        @Override
        public void run() {
            try {
                // This is a bug: Threads takes forever to finish
                Thread.sleep(10000000000L);
            } catch (Exception e) {
               // Ignore
            }
        }
    }

    
    private static class MyTimerTask extends TimerTask {

        private final Thread thread;

        private MyTimerTask(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            System.out.println("Now interrupting the other thread");
            thread.interrupt();
        }
    }


 
}
