
public class CFil extends Thread{
	
	protected  String Proceso;
	protected int Temporizador;
	public CFil (String Proceso) {
		
		this.Proceso= Proceso;
		this.Temporizador= 0 ;
	}

	public String getProceso() {
		return Proceso + " ";
	}

	public void setTemp(int temp ) {
		this.Temporizador = temp;
	}
	
	@Override
public void run () {
		System.out.println("Proceso en ejecución: "  + getProceso());
		try {
		    sleep(Temporizador);
		} catch (Exception e) {
		    System.out.println("Error: " + e);
		}
		System.out.println("Proceso Terminado " + getProceso());
		}

}
