package teste04;

public class EntregaEmailService implements Runnable {

    private final Membros membros;

    public EntregaEmailService(Membros membros) {
        this.membros = membros;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " iniciando envio de emails...");
        while (membros.isAberto() || membros.emailsPendentes() > 0){
            try {
                String email = membros.pegarEmail();
                if (email == null) continue;
                System.out.println(threadName + " enviando email para " + email);
                Thread.sleep(2000);
                System.out.println(threadName + " enviou email com sucesso para " + email);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Todos os emails foram enviados com sucesso!");
    }

}
