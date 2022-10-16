package teste04;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Membros {

    private Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean aberto = true;

    public boolean isAberto(){
        return this.aberto;
    }

    public int emailsPendentes(){
        synchronized (this.emails){
            return this.emails.size();
        }
    }

    public void addEmailsMembros(String email){
        synchronized (this.emails){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " adicionou email na lista");
            this.emails.add(email);
            this.emails.notifyAll(); //quando add emails, notofica as threads que estao aguardando
        }
    }

    public String pegarEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checando se tem emails");
        synchronized (this.emails){
            while (this.emails.size() == 0){
                if (!aberto) return null;
                System.out.println(Thread.currentThread().getName() + " não tem email disponivel na lista, entrando em modo de espera.");
                this.emails.wait(); //todas as threads aguardam
            }
            return this.emails.poll();
        }
    }

    public void close(){
        this.aberto = false;
        synchronized (this.emails){
            System.out.println(Thread.currentThread().getName() + " notificando todo mundo que não estamos mais pegando emails.");
        }
    }

}
