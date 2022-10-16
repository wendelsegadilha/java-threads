package teste03;

public class App01 implements Runnable{

    private static Conta conta;
    public static void main(String[] args) {
        conta = new Conta(100);

        Runnable app01 = new App01();
        Thread t1 = new Thread(app01, "Wendel");
        Thread t2 = new Thread(app01, "Venes");

        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++){
            if (conta.getSaldo() <= 0){
                System.out.println("Saldo insuficiente.");
                break;
            }
            sacar(25);
        }
    }

    private void sacar(Integer valor){
        if(conta.getSaldo() >= valor){
            System.out.println(Thread.currentThread().getName() + " está indo sacar dinheiro.");
            synchronized (this){
                conta.sacar(valor);
            }
            System.out.println(Thread.currentThread().getName() + " completou o saque. - Saldo atual: " + conta.getSaldo());
        }else{
            System.out.println("Sem dinheiro para " + Thread.currentThread().getName() + " completar o saque.");
        }
    }

}
