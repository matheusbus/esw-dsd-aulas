
public class MeuThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("Sou a Thread "+this.getId()+". Tchau");
	}

}
