package teste03.threadsafe;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafe {

    private List<String> nomes = new ArrayList<>();

    public synchronized void add(String nome){
        this.nomes.add(nome);
    }

    public synchronized void removeFrist(){
        if (this.nomes.size() > 0){
            System.out.println(Thread.currentThread().getName());
            System.out.println(this.nomes.remove(0));
        }
    }

}
