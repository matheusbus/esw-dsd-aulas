
public class Processo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Processo que cria Threads");
		
		MeuThread t1 = new MeuThread();
		t1.start();		
		
		MeuThread t2 = new MeuThread();
		t2.start();		
		
		System.out.println("Processo Finalizado");
	}
}
