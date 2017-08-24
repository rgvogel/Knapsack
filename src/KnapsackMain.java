import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.io.*;
import java.lang.reflect.Array;
// Import statements go here.  For example,
// import java.awt.Color;
// import java.util.ArrayList;
// import java.util.Random;

/* KnapsackMain

 *
This class simply creates a timer variable and runs the class
 *  


 *  Created: 

 *     [3/2/16], [Roderick Vogel]





 *
 *  @author Roderick Vogel  
 */
public class KnapsackMain {
	/**
	 * The main function initiates execution of this program.
	 * 
	 * @param String
	 *            [] args not used in this program
	 * @throws IOException 
	 **/
	public static void main(String[] args) throws IOException {
		int capacity = 100;//maximum amount of weight that can be carried in knap sack
		//when run test arrray1 of capacity =10 it gives the expected result of 15 for all situations not just dynamic
		// when run test array2 capacity= 30. shows that greedy algo. gets smaller then other solutions. which can be shown by hand
		MyArray array = new MyArray();
		//when dueing the test arrays number of objects does not matter it will print out the 
		//same value
		long tTime = (long) 0;
		long eTime = (long) 0;
		long sTime = (long) 0;
		System.out.println("Price   "+ "Time");
		for (int numObj = 0; numObj<20; numObj++ )
		{
			int[] weight = array.Array(numObj);//weight of objects
			int[] price = array.Price();//price of objects
			Knapsack kN = new Knapsack(weight,price,capacity);
			sTime = System.nanoTime();
			kN.BruteForce();
			eTime = System.nanoTime();
			tTime = eTime - sTime;
			System.out.println("Brute"+ kN.BruteForce()+ "    "+tTime);
			tTime = (long) 0;
			eTime = (long) 0;
			sTime = (long) 0;
			sTime = System.nanoTime();
			kN.Greedy();
			 eTime = System.nanoTime();
			 tTime = eTime - sTime;
			System.out.println("Greedy"+kN.Greedy()+ "  "+tTime);
			tTime = (long) 0;
			eTime = (long) 0;
			sTime = (long) 0;
			sTime = System.nanoTime();
			kN.Dynamic();
			eTime = System.nanoTime();
			tTime = eTime - sTime;
			System.out.println("Dyn"+kN.Dynamic()+ "  "+tTime);
			tTime = (long) 0;
			eTime = (long) 0;
			sTime = (long) 0;

	}
		
	}
}// end class

