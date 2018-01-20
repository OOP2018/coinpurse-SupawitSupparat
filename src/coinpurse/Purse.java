package coinpurse;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// You will use Collections.sort() to sort the coins

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author SuapwitSupparat5810545483
 */
public class Purse {
	/** Collection of objects in the purse. */
	//TODO declare a List of Coins named "money".
	List<Coin> money = new ArrayList<Coin>( );
	/** Capacity is maximum number of items the purse can hold.
	 *  Capacity is set when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/** 
	 *  Create a purse with a specified capacity.
	 *  @param capacity is maximum number of coins you can put in purse.
	 */
	public Purse( int capacity ) {
		this.capacity=capacity;
	}

	/**
	 * Count and return the number of coins in the purse.
	 * This is the number of coins, not their value.
	 * @return the number of coins in the purse
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
	 * Return the capacity of the coin purse.
	 * @return the capacity
	 */
	//TODO write accessor method for capacity. Use Java naming convention.
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
	 * Insert a coin into the purse.
	 * The coin is only inserted if the purse has space for it
	 * and the coin has positive value.  No worthless coins!
	 * @param coin is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert( Coin coin ) {
		// if the purse is already full then can't insert anything.
		//TODO complete the insert method
		if(isFull()||coin.getValue()<=0)
		{
			return false;
		}
		money.add(coin);
		return true;
	}

	/**  
	 *  Withdraw the requested amount of money.
	 *  Return an array of Coins withdrawn from purse,
	 *  or return null if cannot withdraw the amount requested.
	 *  @param amount is the amount to withdraw
	 *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
	 */
	public Coin[] withdraw( double amount ) {
		List<Coin> withdrawcoin = new ArrayList<Coin>( ); 
		double amountNeededToWithdraw = amount;
		
		//return null when amount <= 0
		if(amount<=0)
		{
			return null;
		}
		
		/*
		 * See lab sheet for outline of a solution, 
		 * or devise your own solution.
		 * The idea is to be greedy.
		 * Try to withdraw the largest coins possible.
		 * Each time you choose a coin as a candidate for
		 * withdraw, add it to a temporary list and
		 * decrease the amount (remainder) to withdraw.
		 * 
		 * If you reach a point where amountNeededToWithdraw == 0
		 * then you found a solution!
		 * Now, use the temporary list to remove coins
		 * from the money list, and return the temporary
		 * list (as an array).
		 */

		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
		// Your code might use some other variable for the remaining amount to withdraw.
		
		Collections.sort(this.money);
		
		
		if(amountNeededToWithdraw!=0) {	
			if(amountNeededToWithdraw <= this.getBalance())
			{
				for (Coin coin: this.money)
				{
					if(amountNeededToWithdraw >= coin.getValue())
					{
						amountNeededToWithdraw -= coin.getValue();
						withdrawcoin.add(coin);
					}
				}
			}
		
	
		
		if(amountNeededToWithdraw==0)
		{
			for(Coin c : withdrawcoin)
			{
				money.remove(c);
			}
		}
		else if ( amountNeededToWithdraw != 0 )
		{	
			return null;
		}
		Coin[] array = new Coin[withdrawcoin.size()];
		withdrawcoin.toArray(array);
		// Success.
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		return array; //TODO replace this with real code
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
//TODO When you finish, there should not be any TODO comments, including this one!
