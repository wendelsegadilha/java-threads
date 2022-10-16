package teste02;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Iniciado processo de geração de documentos..");
		System.out.println("=============================================");
		
		GeraPDF pdf1 = new GeraPDF();
		pdf1.setNome("Relatório de Gastos");
		
		GeraPDF pdf2 = new GeraPDF();
		pdf2.setNome("Relatório de Clientes");
		
		GeraPDF pdf3 = new GeraPDF();
		pdf3.setNome("Relatório de Tarefas");
		
		Thread t1 = new Thread(pdf1);
		Thread t2 = new Thread(pdf2);
		Thread t3 = new Thread(pdf3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("=============================================");
		System.out.println("Finalizado processo de geração de documentos..");
		
	}

}
