// Starts a new thread that prints the message "Hello from me to my friend" at runtime.

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("welcome my friend! how are you today ???");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread(); 
        t.start();
    }
}


--------------------------------------------------

// The task (Runnable) is executed within a new thread that prints "Hello sasa"

public class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from Myfather ! where are you now?");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyTask()); 
        t.start();
    }
}
