package jordi_estelles_navarro_AE3_SYP;

public class Minero implements Runnable
{
	public String nombre = "minero";
	int bolsaRecoleccion = 0;
	int tiempoExtraccion = 1000; 
	int numeroJornada = 0;
	public int cantidadExtraccion = 1;
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

				this.numeroJornada++;
				this.bolsaRecoleccion = mina.extract(this.nombre,  this.cantidadExtraccion, this.numeroJornada, this.bolsaRecoleccion);
				Thread.sleep(1000);


			
		}
		
			
		
			


	public void run() {
		while(mina.ComprobarStock()){
			try {
				extraerRecurso();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
