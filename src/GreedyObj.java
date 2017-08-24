

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

/* GreedyObj

 *
This class presents Creates an object with a set weight and price density

Dynamic solution was based on code from: http://www.sanfoundry.com/java-program-solve-knapsack-problem-using-dp/
 *  Created:  [3/7/16], [Roderick Vogel]





 *
 *  @author Roderick Vogel  
 */
public class GreedyObj implements Comparable<GreedyObj>{
	float weight;
	int  price;
	float density;
	/**
	 * Constructs a weight price and density based on input
	 * @param weight
	 * @param price
	 */
	public GreedyObj(int w, int p)
	{ 
		weight = (float) w;
		price =p;
		density = p/weight;
	}
	/**
	 * precondition: has a greedy obj. compared to another
	 * post condition: returns result which will determine if its bigger, smaller or same
	 * adjust compare to method which will be used when its sorted
	 * makes it so it sorts by densirt
	 * @param greedy obj x
	 * 
	 */
	public int compareTo(GreedyObj x)
	{
		int result =0;
		if(x.density>this.density)
		{
			result = 1;
		}
		else if(x.density<this.density)
		{
			result = -1;
		}
		else
		{
			result = 0;
		}
		return result;
	}
	/**
	 * prints out the weight price and density of each object called
	 */
	public String toString()
	{
		System.out.println(weight+"      "+price+"      "+ density);
		return "";
	}

}
