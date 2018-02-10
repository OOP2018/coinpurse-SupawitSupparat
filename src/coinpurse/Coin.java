package coinpurse;
/**
* Coin represents coin (money) with a fixed value and currency.
* @author Supawit Supparat
*/

public class Coin extends Money{
	/**
	 * Create a new Coin.
	 * @param value is the value of the Coin.
	 * @param currency is the currency of the Coin.
	 */
	Coin(double value, String currency)
	{
		super(value,currency);
	}
	
	
	/**
	 * @return the string describing Coin
	 */
	public String toString()
	{
		return getValue() + " " + getCurrency();
	}
}
