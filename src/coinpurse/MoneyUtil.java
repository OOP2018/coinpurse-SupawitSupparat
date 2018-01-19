package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {

		public static void main(String[] arg)
		{
			List<Coin> coins = new ArrayList<Coin>( );
			
			coins.add( new Coin(500.0, "Baht") );
			coins.add( new Coin(150.0, "Baht") );
			coins.add( new Coin(100.0, "Baht") );
			coins.add( new Coin(10.0, "Baht") );
			coins.add( new Coin(1000.0, "Baht") );
			coins.add( new Coin(0.5, "Baht") );
			coins.add( new Coin(2.0, "Baht") ); // the most hated coin
			coins.add( new Coin(1.0, "Baht") );
			
			printCoins( coins ); 
			// This static method sorts any list of Comparable objects
			java.util.Collections.sort( coins );
			printCoins( coins ); // the coins should be sorted by value now
			
		}
		
		public static void printCoins(List coins)
		{
			coins.forEach(System.out::println);
		}
}
