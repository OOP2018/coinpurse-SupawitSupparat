package coinpurse;
/**
 * BankNote represent banknote (money) with a fixed value and currency.
 * @author Supawit Supparat
 */
public class BankNote implements Valuable{

	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency;
	private long serialNumber;


	BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}

	/** 
	 * Get the value of Banknote
	 * @return value of this banknote.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/** 
	 * Get the currency of Banknote
	 * @return currency of this banknote.
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/** 
	 * Get the serial number of Banknote
	 * @return serial of this banknote.
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * @param obj is a object use to compare
	 * @return true if value and currency are the same otherwise return false
	 */
	public boolean equals( Object obj ){

		if(obj == null){
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		BankNote banknote = (BankNote) obj;
		if( this.value == banknote.getValue() && this.currency.equals(banknote.getCurrency())){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @return the string describing banknote
	 */
	public String toString() {
		return value + " " + currency + " Serial Number : " + serialNumber;
	}
}
