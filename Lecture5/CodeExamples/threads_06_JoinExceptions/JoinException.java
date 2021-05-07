public class JoinException {

    public static void main(String[] args) {

    	// Default exception handler for all threads
        //MyUncaughtExceptionHandler forAllThreads = new MyUncaughtExceptionHandler("for all threads");
        // static "registry-like" method
        //Thread.setDefaultUncaughtExceptionHandler(forAllThreads);
       

        Thread threadA = new Thread(new RunnableCorrect());
        threadA.setName("Thread A");
        
        MyUncaughtExceptionHandler forThreadB = new MyUncaughtExceptionHandler("for Thread B");
        Thread threadB = new Thread(new RunnableCorrect());
        threadB.setName("Thread B");
        threadB.setUncaughtExceptionHandler(forThreadB);
        
        Thread threadC = new Thread(new RunnableCorrect());
        threadC.setName("Thread C");

/*
        // UncaughtExceptionHandlers on threads take precedence
        MyUncaughtExceptionHandler forThreadB = new MyUncaughtExceptionHandler("for Thread B");
        Thread threadB = new Thread(new RunnableWithoutCatch());
        threadB.setName("Thread B");
        threadB.setUncaughtExceptionHandler(forThreadB);
*/
                
/*      
        // UncaughtExceptionHandler is never invoked: The code (i.e. the Runnable) has a catch method
        MyUncaughtExceptionHandler forThreadB = new MyUncaughtExceptionHandler("for Thread B");
        Thread threadB = new Thread(new RunnableWithCatch());
        threadB.setName("Thread B");
        threadB.setUncaughtExceptionHandler(forThreadB);        
*/
        
        threadA.start();
        threadB.start();
        threadC.start();

        // Join threads, i.e. wait until both terminated
 
			try {
				threadA.join();
				System.out.printf("A joined! ");
				threadB.join();
				System.out.printf("B joined! ");
				threadC.join();
				System.out.printf("C joined! ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


    
    
    }

    
    private static class RunnableCorrect implements Runnable {
        @Override
        public void run() {
        	
        }
    }
    
    private static class RunnableWithoutCatch implements Runnable {
        @Override
        public void run() {
            throw new RuntimeException("Exception triggered in RunnableWithoutCatch");
        }
    }
    
    private static class RunnableWithCatch implements Runnable {
        @Override
        public void run() {
            try {
               throw new RuntimeException("Exception triggered in RunnableWithCatch");
            } catch (Exception e) {
                System.err.println("Catch block");
                e.printStackTrace(System.err);
            }
        }
    }

   

    private static class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        private final String name;

        public MyUncaughtExceptionHandler(String name) {
            this.name = name;
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.err.printf("Handler %s: Thread %s threw exception: %s%n", name, t.getName(), e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}
