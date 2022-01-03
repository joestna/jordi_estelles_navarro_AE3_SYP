package jordi_estelles_navarro_AE3_SYP;

import java.util.ArrayList;
import java.util.List;

public class App 
{
	public static void main(String[] args) throws InterruptedException
	{	
		Mina mina = new Mina( 10000 );
		List<Minero> mineros = new ArrayList<Minero>();
		List<Thread> hilos = new ArrayList<Thread>();
		
		for( int i = 0; i < 10; i++ )
		{
			Minero minero = new Minero(mina);
			minero.nombre += i+1;
			
			mineros.add(minero);
		}
		
		for( Minero minero : mineros)
		{
			Thread thread = new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					try
					{
						minero.extraerRecurso();
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();						
					}
				}
			});
			
			hilos.add(thread);
		}
		
		for( Thread hilo : hilos)
		{
			hilo.start();
		}
		
		
		while( mina.ComprobarStock() )
		{
			// Si no pongo este Thread sleep el while nunca termina -> preguntar
			Thread.sleep(1000);
		}
		
		System.out.println("Fin de la extraccion");		
	}
}
