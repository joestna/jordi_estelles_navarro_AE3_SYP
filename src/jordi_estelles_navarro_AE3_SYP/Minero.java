package jordi_estelles_navarro_AE3_SYP;

public class Minero implements Runnable
{
	public String nombre = "minero";
	int bolsaRecoleccion = 0;
	int tiempoExtraccion = 1000; 
	public int numeroJornada = 0;
	Mina mina; // Guardar una mina (paso por referencia para que todos los mineros actuen sobre la misma mina)
	
	public Minero( Mina mina )
	{
		this.bolsaRecoleccion = 0;
		this.mina = mina;
	}
	
	public int GetBolsaRecoleccion()
	{
		return this.bolsaRecoleccion;
	}
	
	public void extraerRecurso() throws InterruptedException
	{	
		synchronized(Thread.class) {
			while(mina.ComprobarStock()) 
			{ 

					numeroJornada++;
					System.out.println( "> Extrayendo | " + this.nombre + " | Jornada : " + this.numeroJornada + " | Stock en mina : " + mina.GetStock() + " | " + mina.ComprobarStock());
					int extraido = 0;
					
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
					extraido++;
					
					/*
					if(mina.ComprobarStock())
					{
						mina.extract();
						bolsaRecoleccion++;
						extraido++;
						
					}
					*/
							
					System.err.println( "> Extraido  : " + extraido + " | "  + this.nombre + " | Jornada : " + this.numeroJornada + " | Stock en mina : " + mina.GetStock());
				}
			
		}
		
			
		}
			


	public void run() {

			try {
				extraerRecurso();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
