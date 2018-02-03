package coinpurse;

import java.util.Comparator;

/**
* To compare a value between each currency.
* @author Supawit Supparat
* 
*/
public class ValueComparator implements Comparator<Valuable> {
	/**
	 * Compare two objects that implement Valuable.
	 * First compare them by currency, so that "Baht" < "Dollar".
	 * If both objects have the same currency, order them by value.
	 * 
	 * @param a is valuable object use to compare with b 
	 * @param b is valuable object use to compare with b
	 * @return 1 if the value and currency of a is more than b
	 * 		   0 if the value and currency of a and b is equal
	 *        -1 if the value and currency of a is less than b
	 */
	public int compare(Valuable a, Valuable b) {
		if(a.getCurrency().equals(b.getCurrency())) {
			if(a.getValue()>b.getValue()){
				return 1;
			}
			else  if(a.getValue()<b.getValue()){
				return -1;
			}
			else{
				return 0;
			}
		}
		else{
			if(a.getCurrency().charAt(0) > b.getCurrency().charAt(0)) { 
				return 1;
			}
			else if (a.getCurrency().charAt(0) < b.getCurrency().charAt(0)) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}

