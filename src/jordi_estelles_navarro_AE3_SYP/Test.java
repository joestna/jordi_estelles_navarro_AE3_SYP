package jordi_estelles_navarro_AE3_SYP;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws InterruptedException 
	{
		/*
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
		
		while(ventiladorEncender.isAlive() || ventiladorApagar.isAlive())
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.err.println("llega hasta el final");
		
		*/
		
		Mina mina = new Mina( 50 );
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
		
		System.out.println("Fin de la extraccion");		
	}
}
