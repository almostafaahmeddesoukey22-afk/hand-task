
// Handling Exceptions inside a Thread using try–catch

class Worker extends Thread {
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " started.");
            int result = 10 / 0;
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " caught " + e);
        }
        System.out.println(Thread.currentThread().getName() + " finished.");
    }
}

public class MultiThreadExceptionExample {
    public static void main(String[] args) {
        Worker t1 = new Worker();
        Worker t2 = new Worker();
        Worker t3 = new Worker();

        t1.start();
        t2.start();
        t3.start();
    }
}



class WorkerThread extends Thread {
    public void run() {
        System.out.println("Thread started: " + getName());
        int x = 10 / 0; 
    }
}

public class Example_UncaughtHandler {
    public static void main(String[] args) {
        WorkerThread t1 = new WorkerThread();

        t1.setUncaughtExceptionHandler((thread, exception) -> {
            System.out.println("Exception in " + thread.getName() + ": " + exception.getMessage());
        });

        t1.start();
    }
}





public class DefaultHandlerExample {
    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            System.out.println("Global handler caught exception in " + thread.getName());
            System.out.println("Error: " + exception.getMessage());
        });

        Thread t1 = new Thread(() -> {
            throw new RuntimeException("Thread crashed");
        });

        Thread t2 = new Thread(() -> {
            throw new ArithmeticException("Division by zero");
        });

        t1.start();
        t2.start();
    }
}
