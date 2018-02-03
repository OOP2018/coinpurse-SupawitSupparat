package coinpurse;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *  A purse contains coins and banknote.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Suapwit Supparat
 */

public class Purse {
	/** Collection of objects in the purse. */

	List<Valuable> money = new ArrayList<Valuable>( );
	/** Capacity is maximum number of items the purse can hold.
	 *  Capacity is set when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/** 
	 *  Create a purse with a specified capacity.
	 *  @param capacity is maximum number of capacity you can put in purse.
	 */
	public Purse( int capacity ) {
		this.capacity=capacity;
	}

	/**
	 * Count and return the number of money in the purse.
	 * This is the number of money, not their value.
	 * @return the number of money in the purse
	 */
	public int count() {
		return money.size(); 
	}

	/** 
	 *  Get the total value of all items in the purse.
	 *  @return the total value of items in the purse.
	 */
	public double getBalance() {
		int i;
		double sum = 0;
		for(i = 0; i < money.size(); i++)
			sum += money.get(i).getValue();
		return sum;
	}

	/**
	 * Return the capacity of the money purse.
	 * @return the capacity
	 */

	public int getCapacity() { 
		return capacity; 
	}

	/** 
	 *  Test whether the purse is full.
	 *  The purse is full if number of items in purse equals
	 *  or greater than the purse capacity.
	 *  @return true if purse is full.
	 */
	public boolean isFull() {
		if(money.size()==capacity)
		{
			return true;
		}
		else return false;
	}

	/** 
	 * Insert a value into the purse.
	 * The value is only inserted if the purse has space for it
	 * and the value has positive value.  No worthless value!
	 * @param Valuable is a value object to insert into purse
	 * @return true if value inserted, false if can't insert
	 */
	public boolean insert( Valuable value ) {
		// if the purse is already full then can't insert anything.
		if(isFull()||value.getValue()<=0)
		{
			return false;
		}
		money.add(value);
		return true;
	}

	/**  
	 *  Withdraw the requested amount of money.
	 *  Return an array of value withdrawn from purse,
	 *  or return null if cannot withdraw the amount requested.
	 *  @param amount is the amount to withdraw
	 *  @return array of value objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
	 */
	public Valuable[] withdraw( double amount ) {
		//create a temporary list to keep the withdraw coin
		List<Valuable> list = new ArrayList<Valuable>();
		Comparator<Valuable> comp = new ValueComparator();

		double amountNeededToWithdraw = amount;

		//return null when amount <= 0
		if(amount<=0)
		{
			return null;
		}

		Collections.sort(money , comp);

		if(amountNeededToWithdraw!=0) {	
			if(amountNeededToWithdraw <= this.getBalance())
			{
				for (Valuable values : this.money)
				{
					if(amountNeededToWithdraw >= values.getValue())
					{
						amountNeededToWithdraw -= values.getValue();
						list.add(values);
					}
				}
			}

			if(amountNeededToWithdraw==0)
			{
				for(Valuable values: list)
				{
					money.remove(values);
				}
			}
			else if ( amountNeededToWithdraw != 0 )
			{	
				return null;
			}
			
			Valuable[] withdraw = new Valuable[list.size()];
			 return list.toArray(withdraw);
		}
		return null;
	}

	/** 
	 * toString returns a string description of the purse contents.
	 * It can return whatever is a useful description.
	 */
	public String toString() {
		return "purse have" + this.count() + "with balance" + this.getBalance();
	}
}
