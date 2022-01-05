package jordi_estelles_navarro_AE3_SYP;

import java.util.ArrayList;
import java.util.List;

public class App 
{
	public static void main(String[] args) throws InterruptedException
	{	
		// El ventilador se inicia al inciar la aplicacion
		// Creo un ventilador y dos threads, uno para apagarlo y otro para encenderlo que funcioaran en paralelo pero sinergicamente
		Ventilador ventilador = new Ventilador();
		
		Thread ventiladorEncender = new Thread( new Runnable () 
		{
			@Override
			public void run()
			{
				try
				{
					ventilador.EncenderVentilador();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		Thread ventiladorApagar = new Thread( new Runnable () 
		{
			@Override
			public void run()
			{
				try
				{
					ventilador.ApagarVentilador();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		ventiladorEncender.start();
		ventiladorApagar.start();
		
		
		// Creo una mina, le asigno los recursos y creo un grupo de mineros con un hilo cada uno que minaran recursos evitando la condicion de carrera
		Mina mina = new Mina( 100 );
		List<Minero> mineros = new ArrayList<Minero>();
		List<Thread> hilos = new ArrayList<Thread>();
		
		for( int i = 0; i < 10; i++ )
		{
			Minero minero = new Minero(mina);
			minero.nombre += i+1;
			
			mineros.add(minero);
		}
		
		Thread thread;		
		for( Minero minero : mineros)
		{
			thread = new Thread(minero);			
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
		
		for( Minero minero : mineros )
		{
			System.out.println(">> " + minero.nombre + " | Bolsa de extraccion : " + minero.GetBolsaRecoleccion());
		}
		
		System.out.println("\nFin de la extraccion | Desconectando ventilacion ... \n");	
		
		// Me aseguro de que el ultimo hilo en terminar sera el que apaga el ventilador
		ventilador.stopE = true;
		ventiladorEncender.join();
		
		ventilador.stopA = true;
		ventiladorApagar.join();
		
		System.err.println("> Ventilacion desconectada");	
	}
}
