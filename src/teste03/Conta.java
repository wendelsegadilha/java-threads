package teste03;

public class Conta {

    private Integer saldo;

    public Conta(Integer saldo){
        this.saldo = saldo;
    }

    public Integer getSaldo() {
        return saldo;
    }
    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public void sacar(Integer valor){
         this.saldo -= valor;
    }

}
