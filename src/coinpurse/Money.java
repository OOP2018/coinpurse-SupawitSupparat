package coinpurse;

public class Money implements Valuable{

	protected double value;
	protected String currency;


	/**
	 * Create a new money.
	 * @param value is value of money.
	 * @param currency is currency of money.
	 */
	public Money(Double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * @return the values of money
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * @return the values of currency
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Compare this Money with m money are equal or not.
	 * @param obj is a object to compare.
	 * @return true if fraction are equal, otherwise return false.
	 */	
	public boolean equals( Object obj ){
		if(obj == null){
			return false;
		}	
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		Money m = (Money) obj;
		if( this.value == m.getValue() && this.currency.equals(m.getCurrency())){
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Compare this Valuable with v Valuable.
	 * @param v is the Valuable to compare by this fraction.
	 * @return a number after compare Valuable 1 for this Valuable > v Valuable , 0 for equal and -1 for this Valuable < v Valuable.
	 */	
	@Override
	public int compareTo(Valuable v) {
		if(currency.equals(v.getCurrency())) {
			if(value>v.getValue()){
				return 1;
			}
			else  if(value<v.getValue()){
				return -1;
			}
			else{
				return 0;
			}
		}
		else{
			if(currency.charAt(0) > v.getCurrency().charAt(0)) { 
				return 1;
			}
			else if (currency.charAt(0) < v.getCurrency().charAt(0)) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}