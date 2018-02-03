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
     * Initialize a new Purse dialog.
     * @return value of this banknote.
     */
	@Override
	public double getValue() {
		return this.value;
	}
	
	/** 
     * Initialize a new Purse dialog.
     * @return currency of this banknote.
     */
	@Override
	public String getCurrency() {
		return this.currency;
	}
	
	/** 
     * Initialize a new Purse dialog.
     * @return serial of this banknote.
     */
	public long getSerial() {
		return serialNumber;
	}

	/**
	 * @param obj is a object use to compare
	 * @return true if value and currency are the same otherwise return false
	 */
	public boolean equals( Object obj ){

		if(obj == null){
			return false;
		}

		BankNote banknote = (BankNote) obj;
		if( obj instanceof BankNote)  {
			if( this.value == banknote.value && this.currency.equals(banknote.currency)){
				return true;
			}
			else{
				return false;
			}
		}
		else return false;
	}
}
