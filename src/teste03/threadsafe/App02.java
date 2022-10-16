package teste03.threadsafe;

public class App02 {

    public static void main(String[] args) {

        ThreadSafe threadSafe = new ThreadSafe();
        threadSafe.add("Wendel");

        Runnable r = () -> {
          threadSafe.removeFrist();
        };

        new Thread(r).start();
        new Thread(r).start();
    }

}
