package teste04;

import javax.swing.*;

public class App04 {

    public static void main(String[] args) {

        Membros membros = new Membros();

        Thread api01 = new Thread(new EntregaEmailService(membros), "API-01");
        Thread api02 = new Thread(new EntregaEmailService(membros), "API-02");

        api01.start();
        api02.start();

        while (true) {
            String email = JOptionPane.showInputDialog("Entre com seu e-mail:");

            if (email == null || email.isEmpty()){
                membros.close();
                api02.stop();
                api01.stop();
                break;
            }
            membros.addEmailsMembros(email);
        }

    }

}
