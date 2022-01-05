package jordi_estelles_navarro_AE3_SYP;

public class Ventilador 
{
	int tiempoParada = 1000;
	boolean encendido = false;
	boolean stop = false;
	
	public void EncenderVentilador() throws InterruptedException
	{
		while(!stop)
		{
			synchronized(this)
			{
				while(!this.encendido) wait();
				
				this.encendido = !this.encendido;
				System.out.println(">>>  VENTILADOR ENCENDIDO");
				Thread.sleep(tiempoParada);
				
				notify();
			}
		}		
	}
	
	public void ApagarVentilador() throws InterruptedException
	{
		while(!stop) 
		{
			synchronized(this)
			{
				while(this.encendido) wait();
				
				this.encendido = !this.encendido;
				System.out.println(">>> VENTILADOR APAGADO");
				Thread.sleep(tiempoParada);
				
				notify();
			}
		}		
	}
}
