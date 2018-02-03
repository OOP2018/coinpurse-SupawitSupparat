package coinpurse;
/**
* Coin represents coin (money) with a fixed value and currency.
* @author Supawit Supparat
*/

public class Coin implements Comparable<Coin> , Valuable{

	double value;
	String currency;
	
	Coin(double value, String currency)
	{
		this.value = value;
		this.currency = currency;
	}
	
	public double getValue( )
	{
		return this.value;
	}
	
	public String getCurrency() 
	{
		return this.currency;
	}
	
	public boolean equals(Object arg) 
	{
		if (arg == null) return false;
		if (arg.getClass() != this.getClass() )
			return false;
		Coin other = (Coin) arg;
		if ( currency.equalsIgnoreCase( other.currency ) && value==other.value )
			return true;
		return false; 
		
	}
	
	
	public int compareTo(Coin coin) 
	{
		
		if(coin.getValue()- this.getValue() <0)
		{
			return  -1;
		}
		else if(coin.getValue()- this.getValue() > 0)	
		{
			return 1;
		}
		else return 0;
	}
	
	public String toString()
	{
		return value + " " + currency;
	}
}
