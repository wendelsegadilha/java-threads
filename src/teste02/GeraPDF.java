package teste02;

public class GeraPDF implements Runnable {

	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void run() {
		
		for(int i = 1; i <= 100; i++) {
			System.out.println("Documento " + getNome() + " está " + i + "% concluído...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
