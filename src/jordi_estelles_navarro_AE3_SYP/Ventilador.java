package jordi_estelles_navarro_AE3_SYP;

public class Ventilador 
{
	int tiempoParada = 1000;
	boolean encendido = false;
	boolean stopE = false;
	boolean stopA = false;
	
	public void EncenderVentilador() throws InterruptedException
	{
		synchronized(this)
		{
			while(!stopE)
			{
				while(this.encendido) wait();
				
				this.encendido = true;
				System.out.println(">>>  VENTILADOR ENCENDIDO");
				Thread.sleep(tiempoParada);
				
				notify();
			}
		}		
	}
	
	public void ApagarVentilador() throws InterruptedException
	{
		synchronized(this)
		{
			while(!stopA) 
			{
				while(!this.encendido) wait();
				
				this.encendido = false;
				System.out.println(">>>  VENTILADOR APAGADO");
				Thread.sleep(tiempoParada);
				
				notify();
			}
		}		
	}
}
