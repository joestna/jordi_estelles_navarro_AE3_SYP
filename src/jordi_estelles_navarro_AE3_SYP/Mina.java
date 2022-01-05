package jordi_estelles_navarro_AE3_SYP;

public class Mina 
{
	private int stock;
	
	public Mina( int stock )
	{
		this.stock = stock;
	}
	
	synchronized public void extract() throws InterruptedException
	{

	
			if(ComprobarStock()) this.stock--;
		
			
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
