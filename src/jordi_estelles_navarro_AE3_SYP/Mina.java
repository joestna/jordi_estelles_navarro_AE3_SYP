package jordi_estelles_navarro_AE3_SYP;

public class Mina 
{
	private int stock;
	
	public Mina( int stock )
	{
		this.stock = stock;
	}
	
	public void extract() throws InterruptedException
	{
		synchronized(this)
		{
			if(ComprobarStock()) this.stock--;
			
			notify();
		}
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
