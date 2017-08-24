import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

// Import statements go here.  For example,
// import java.awt.Color;
// import java.util.ArrayList;
// import java.util.Random;

/**
 this is meant to give abunch of different type of arrays that then can be sorted
 *Created
 *2/10/16 by Roderick Vogel
 *
 *  @author Roderick Vogel

 */
public class MyArray
{
	MyRandom rand = new MyRandom();
	/**
	 * This is used to check if the invariant is true for the fillArray method.
	 * does so by filling making sure there is a number at every spot in the array
	 * @return boolean
	 * @param Comparable
	 * @param int //index of comparable array
	 */
	 private boolean elementHaveValues(Comparable A[], int i)
	{
		 int s = i;
		 Comparable e[] = A;
		for( s = 0; s<e.length; s++)
		{
			if (e[s]== null)
			{
				return false;
			}
		}
		return true;
	}

    private int length;                // how many objects in array list

  // Constructors

    /**
     * Creates an array of weights randomly selected between 1 and 100
     *      @param   number of objects that can be put into knap sack
     *		@return  int[] array list of weights
     */
    public int[] Array(int numObj)
    {
    	//testArray one test to see if dynamic solution is true for both situations
//    	int[] testArray1 = new int [5];
//    	testArray1[0] = 2;
//    	testArray1[1] = 2;
//    	testArray1[2] = 6;
//    	testArray1[3] = 5;
//    	testArray1[4] = 4;
    	//test array 2 is a known set of weights prices thats greedy ratio algorithm 
    	//that does not give optimal value
//    	int[] testArray2 = new int [3];
//    	testArray2[0] = 5;
//    	testArray2[1] = 20;
//    	testArray2[2] = 10;
    	int[] sArray = new int[numObj];
    	for( Integer i =0 ; i<numObj; i++ )
    	{
    		Integer weight = rand.intRand(40);
    		sArray[i] =i+weight;
    		
    		
    	}
    	length = numObj;
    	
    	//return testArray2;
    	//return testArray1;
    	return sArray;
    }
    
    /**
     * Creates an array of prices randomly selected between 1 and 100
     *      @return  int[] array list of prices correspond with weights
     */
    public int[] Price()
    {
//    	int[] testArray1 = new int [5];
//    	testArray1[0] = 6;
//    	testArray1[1] = 3;
//    	testArray1[2] = 5;
//    	testArray1[3] = 4;
//    	testArray1[4] = 6;
//    	int[] testArray2 = new int [3];
//    	testArray2[0] = 50;
//    	testArray2[1] = 140;
//    	testArray2[2] = 60;
    	int[] rArray = new int[length];
    	for( Integer i = 0; i<length; i++ )
    	{
    		Integer cost = rand.intRand(100);
    		rArray[i] = i + cost;
    	}
    	//return testArray1;
    	//return testArray2;
    	return rArray;
    }
 

  }