package jordi_estelles_navarro_AE3_SYP;

public class Minero 
{
	public String nombre = "minero";
	int bolsaRecoleccion = 0;
	int tiempoExtraccion = 1000;
	Mina mina; // Guardar una mina (paso por referencia para que todos los mineros actuen sobre la misma mina)
	
	public Minero( Mina mina )
	{
		this.bolsaRecoleccion = 0;
		this.mina = mina;
	}
	
	public void extraerRecurso() throws InterruptedException
	{	
		while(mina.ComprobarStock())
		{
			System.out.println( "> " + nombre + " : Extrayendo ...");
			
			try
			{
				Thread.sleep( tiempoExtraccion );
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			mina.extract();
			bolsaRecoleccion++;
			
			System.err.println( "> " + nombre + "| Stock en mina : " + mina.GetStock());
		}		
	}

	/*
	@Override
	public void run()
	{
		try {
			extraerRecurso();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	*/
}
