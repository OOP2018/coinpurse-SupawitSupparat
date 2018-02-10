package coinpurse;
/**
 * BankNote represent banknote (money) with a fixed value and currency.
 * @author Supawit Supparat
 */
public class BankNote extends Money implements Valuable{

	private static long nextSerialNumber = 1000000;
	private long serialNumber;


	/**
	 * Create a new Banknote.
	 * @param value is the value of the Banknote.
	 * @param currency is the currency of the Banknote.
	 */
	BankNote(double value, String currency) {
		super(value,currency);
		this.nextSerialNumber++;
	}

	/** 
	 * Get the serial number of Banknote
	 * @return serial of this banknote.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * @return the string describing banknote
	 */
	public String toString() {
		return getValue() + " " + getCurrency() + " Serial Number : " + serialNumber;
	}
}
