package coinpurse;
/**
 * An interface for objects having a monetary value and currency.
 * @author Supawit Supparat
 */
public interface Valuable {
	/**
	 * Get the monetary value of this object, in its own currency.
	 * @return the value of this object
	 */
	public double getValue(); 
	/**
	 * Get the Currency of the Object.
	 * @return the currency of this object
	 */
	public String getCurrency();
}



