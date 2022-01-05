package jordi_estelles_navarro_AE3_SYP;

public class Ventilador 
{
	int tiempoParada = 1000;
	boolean encendido = false;
	
	public void EncenderVentilador() throws InterruptedException
	{
		while(true)
		{
			synchronized(this)
			{
				while(!this.encendido) wait();
				
				this.encendido = !this.encendido;
				System.out.println(" Ventilador encendido");
				Thread.sleep(tiempoParada);
				
				notify();
			}
		}		
	}
	
	public void ApagarVentilador() throws InterruptedException
	{
		while(true) 
		{
			synchronized(this)
			{
				while(this.encendido) wait();
				
				this.encendido = !this.encendido;
				System.out.println(" Ventilador apagado");
				Thread.sleep(tiempoParada);
				
				notify();
			}
		}		
	}
}
