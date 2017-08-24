

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.lang.reflect.Array;
// Import statements go here.  For example,
// import java.awt.Color;
// import java.util.ArrayList;
// import java.util.Random;

/* Knapsack

 *
This class presents three different method for 
finding the maximum price possible with an array of weights with corresponding array of prices 
from this it finds the combination of items that have the highest 
possible value of a collection of items that are under a the weight capacity given
 *  

Dynamic solution was based on code from: http://www.sanfoundry.com/java-program-solve-knapsack-problem-using-dp/
 *  Created:  [3/2/16], [Roderick Vogel]





 *
 *  @author Roderick Vogel  
 */
public class Knapsack {

final int[] w;//array of weights
final int[] p; //array of coresponding prices
final int c;//weight capacity 
int []x; //used for binary counter
int []h;// place holder for binary counter
int tPrice = 0; //total value of items collected
int tWeight = 0;//total weight of value collected
int LPrice = 0; //largest price
int LWeight =0;// total weight of collection of items with the maximum value
int [][] K;
/**
 * 
 * @param weight array of weights of items(int)
 * @param price array of the price of items correspond with same index as
 * @param capacity max weight that can be carried
 */
	public Knapsack(int[] weight, int[] price , int capacity)
	{
		w = weight;
		p = price;
		c = capacity;
		x = new int[w.length];
		h = new int[w.length];
	}
	/**
	 * precondition: take an array of weights and prices with the same index
	 * post condition: has a list of weights and corresponding prices that give the maximum
	 * that have gives the most value for the price
	 * Goes through every possible combination of items and obtains 
	 * the combination of items that will remain under the weight capacity 
	 * and have the maximum possible total price
	 * @return int max total price
	 */
	public int BruteForce()
	{
		//assert precondition which arrays are integers comes with constructor so it is given
		//grab binary counter to keep track of items used
		BinaryCounter bC = new BinaryCounter();
		tWeight = 0;
		tPrice =0;
		LPrice =0;
		LWeight = 0; 
		bC.Reset(x);
		bC.Bump(x);
		//end while loop after going through all possible combination of items
		while(!bC.overflow)
		{
			//go through all items 
			for(int i = 0; i<p.length;i++)
			{
				//only add to possibilities if x[i] =1 in binary counter
				//stay under the maximum capacity 
				if((tWeight +(w[i]*x[i]))<= c)
				{
					tPrice = tPrice + (p[i]*x[i]);
					tWeight = tWeight + (w[i]*x[i]);
					//Lprice largest combination of prices under the capacity
					if(tPrice>LPrice)
					{
						LPrice = tPrice;
						//System.out.println("max price: " + LPrice);
						for( int s =0; s<p.length; s++)
						{
							h[s] = x[s];
						}
						//System.out.println("x"+Arrays.toString(x));
						//System.out.println("h"+Arrays.toString(h));

						LWeight =tWeight;
					}
					
				}
				
			}
			tPrice = 0;
			tWeight =0;

			bC.Bump(x);
		}
//		System.out.println("h"+Arrays.toString(h));
//
//		System.out.println("Weight   "+"Price");
//		for(int u =0; u<p.length; u++)
//		{
//			if(h[u]==1)
//			{
//				System.out.println(w[u]+"     "+p[u]);
//			}
//		}
		//System.out.println("max price Brute Force: " + LPrice);
		//System.out.println("max Weight Brute Force: " + LWeight);
		return LPrice;
	}
	/**
	 * precondition: take objects with a weight,density and price
	 * post condition: make a list of items with the top price density thats total weight is under the capacity
	 * create an array of objects with a price and weight and a price density(price/weight)
	 * sorts the array from largest to smallest based on price density. 
	 * then it takes off the top of the list until the weight reaches capacity
	 * 
	 * @return max total price
	 */
	public int Greedy()
	{
		//assert precondition which arrays in object are integers comes with constructor so it is given
		tWeight = 0;
		tPrice = 0;
		HeapSort hs = new HeapSort();
		GreedyObj gO;
		GreedyObj [] gArray = new GreedyObj[p.length];

		for (int i = 0; i<p.length;i++)
		{
			 gO = new GreedyObj(w[i],p[i]);
			 gArray[i] =  gO;
		}
		hs.Sort( gArray);
		//System.out.println("Weight   "+"Price   "+"Density");
		for(int s = 0; s<p.length; s++)
		{
			gO= gArray[s]; 
			if((tWeight+ gO.weight)<=c)
			{
				tWeight = (int) (tWeight + gO.weight);
				tPrice = tPrice + gO.price;
				//gO.toString();
				
			}
		}
		//System.out.println("Greedy Total Weight: "+ tWeight);
		//System.out.println("Greedy Total Price: "+ tPrice);
		return tPrice;
	}
	/**
	 * precondition: obtain two integers
	 * post condition returns the largest integers
	 * takes to integers a and b
	 * if a is greater then b it returns a else it returns b
	 * @param a
	 * @param b
	 * @return int
	 */
	 public static int max(int a, int b) 
	    { 
	        return (a > b)? a : b; 
	    }
	 /**
	  * precondition: take an array of weights and prices with the same index
	  * post condition: has a list of weights and corresponding prices that give the maximum
	  * that have gives the most value for the price
	  * return int max total price
	  */
	   public int Dynamic()
	    {
		   //assert precondition which arrays are integers comes with constructor so it is given
	        int i, j;
	        int[][]K = new int[p.length+1][c+1];
	 
		   // Build table K[][] in bottom up manner
	        for (i = 0; i <= p.length; i++)
	        {
	            for (j = 0; j <= c; j++)
	            {
	                if (i==0 || j==0)
	                    K[i][j] = 0;
	                else if (w[i-1] <= j)
	                    K[i][j] = max(p[i-1] + K[i-1][j-w[i-1]],  K[i-1][j]);
	                else
	                    K[i][j] = K[i-1][j];
	            }
	        }
	       // Traceback(K);
	        return K[p.length][c];
	    }
	   /**
	    * precondition recieves a table of ints
	    * postcondition findout the weights and prices used based on a binary type method
	    * @param takes in a table of ints
	    */
	   public void Traceback( int f[][])
	   {
		   //assert precondition which its a table of int already in method so does not need to be asserted

		   for ( int i = 1; i<p.length; i++)
		   {
			   if(f[i][c] == f[i+1][c])
			   {
				   x[i] = 0;
				  
			   }
			   else
			   {
				   x[i] =1;
			   }
		   }
		   //System.out.println("x"+Arrays.toString(x));
			//System.out.println("Weight   "+"Price");
//			for(int u =0; u<p.length; u++)
//			{
//				if(x[u]==1)
//				{
//					System.out.println(w[u]+"     "+p[u]);
//				}
//			}
	   }
}