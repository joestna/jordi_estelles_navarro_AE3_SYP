package jordi_estelles_navarro_AE3_SYP;

public class Mina 
{
	private int stock;
	
	public Mina( int stock )
	{
		this.stock = stock;
	}
	
	synchronized public int extract( String nombre, int cantidadExtraccion, int numeroJornada, int bolsaRecoleccion ) throws InterruptedException
	{
		System.out.println( "> Extrayendo | " + nombre + " | Jornada : " + numeroJornada + " | Stock en mina : " + GetStock());
		
	
			if(ComprobarStock())
			{
				this.stock = this.stock - cantidadExtraccion;
				System.err.println( "> Extraido  : " + cantidadExtraccion + " | "  + nombre + " | Jornada : " + numeroJornada + " | Stock en mina : " + GetStock());
				return bolsaRecoleccion + cantidadExtraccion;
			}
			return bolsaRecoleccion;
		
			
			//System.err.println("> Stock en mina : " + this.stock);
			
			//notify();
		
	}
	
	public int GetStock()
	{
		return this.stock;
	}
	
	
	public boolean ComprobarStock()
	{
		if(this.stock <= 0)
		{
			return false;
		}
		
		return true;
	}
}
