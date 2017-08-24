/*
   Class: Heap Sort
   Author:  Roderick Vogel
        with assistance from:  people who helped (including instructor/TAs)
   Creation date:  02/08/16

   Modifications:
        Date    Name    reason
        ----    ----    ------
*/

// Package declaration goes here.
// package Package_Name;

// Import statements go here.
// import java.io.*;
// import java.util.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


/**
   This class sorts an array of  random objects by first building a max heap and then sorting it
   through max heapifying each index of the array starting at the end of the array.


   @author Roderick Vogel
*/
public class HeapSort
{
	Comparable[] a; //array used through out sort
	//create the left and right variable to be the children of a node
	int left; 
	int right;
	int largest;
	int aHeapSize;//create a heap size variable



		/**
		 * This is used to check if the invariant is true for the sort method.
		 * does so by making seeing if each integer is larger then one thats next in the index if it is it returns false
		 * precondition:  an array that may be sorted
		 * post condition: if it is sorted return true else false
		 * @return boolean
		 * @param Comparable
		 * @param int //index of comparable array
		 */
		 private boolean elementIsSorted(Comparable A[], int i)
		{
			 int s = i;
			Comparable e[] = A;
			// loop through the array from the sort
			for( s = 1; s<e.length; s++)
			{
				int a = s-1;
				//compares index seeing if a is smaller then then one after it s
				if (e[a].compareTo(e[s])>0)
				{
					return false;
				}
			}
			return true;
		}
		 /**
			 * This is used to check if the invariant is true for a heap by checking if the left and right children
			 * are less then the parent
			 * precondition:  an index with a left and right child
			 * post condition: if they are greater then parent return false else return true 
			 * @return boolean
			 * @param Comparable
			 * @param int //L lowest index of array
			 *  @param int //u max index of array
			 */
		private boolean isHeap(Comparable A[], int L, int u)
		{
			//set left and right and based on index

			left = 2*u + 1;
	    	right = L*2 +2;
			Comparable e[] = A;
			// check to see if left or right are greater then their parent node
			for(int q= L; L<=u ;L++)
			{
				if(e[left].compareTo(e[u])>0 || e[right].compareTo(e[u])>0)
				{
					return false;
				}
			}
			return true;
			}
	    /** 
	     * This takes an array of comparable makes a max heap from them
	     * pre-condition: have an array of comparable objects
	     * post condition: the array is a max heap
	     * @return Comparable[] an array that is a max heap
	       @param   Comparable[] the array from the main
	    */
		public Comparable[] BuildMaxHeap(Comparable array[])
		{
			a = array;//set array to array used throughout class
			aHeapSize = a.length -1;//set heapsize to a length - 1
			//loop through array compare index to left and right and swap it so it is a heap
			for(  int i= (aHeapSize/2); i>=0; i--)
			{
				// the invariant is it is a heap from a heapSize/2 to i
				MaxHeapify(a,i);
				assert(isHeap(a,i,aHeapSize/2));// checks to see if it is a heap from i to heapsize/2
				//System.out.println("Max: " + Arrays.toString(MaxHeapify(a,i)));
			}
			assert(isHeap(a,0,aHeapSize));// checks to see if it is a heap from 0 to heapsize
			return a;
		}
    /** 
     * This takes a[i] and makes it a heap
     * pre-condition: has a comparable array with an index i
     * post condition: left and right are smaller then a[i]
     * @return comparable[] to be used in build heap
       @param   Comparable[] array   This is a list of comparable objects.
       @param	int the index of array that is being used
    */
    public Comparable[] MaxHeapify(Comparable[] array, int i)
    {
    	//set up left and right based 2* parent index plus one for left 
    	// and 2 *index + 2 for right
    	a = array;
    	left = 2*i + 1;
    	right = i*2 +2;
    	Comparable temp = 0;
    	//check which is the largest value in each index 
    	//if it is the largest set it to largest 
    	if(left<=aHeapSize && a[left].compareTo(a[i])>0)
    	{
    		largest = left;
    	}
    	else
    	{
    		largest = i;
    	}
    	if(right<=aHeapSize && a[right].compareTo(a[largest])>0)
    	{
    		largest = right;
    	}
    	if(largest!=i )
    	{ //swap index i with largest if largest isn't i
    		
    		temp = a[largest];
    		a[largest]=a[i];
    		a[i] =temp;
    		assert(isHeap(a,i,largest));//check to see if it is a heap at index i
    		MaxHeapify(a,largest);//max heapify(recursion) the largest result 
    	}
    	return a; //return an array
    }
    /** 
     * This takes an array of comparable objects and puts them in order.
     * pre-condition: an array of comparable objects
     * post condition: the array is sorted
     * @return comparable[] to be used in build heap
       @param   Comparable[] array   This is a list of comparable objects.
    */
   public Comparable[] Sort(Comparable[] array)
   {
	   a = array; //bring in an array from main to be sorted
	   Comparable temp =0; //used for a placeholder for a swap
	   BuildMaxHeap(a); //build a max heap that will be sorted
	   //loop through array starting by moving largest element to the end of the array and the second and so on
	   while(aHeapSize>=0)
	   {
		   // the invariant is a sorted array [0 to heap size)
		   assert(elementIsSorted(a,aHeapSize));// checks to see if array is sorted from heap size to length
		   //System.out.println("heap size: " + aHeapSize);
		   //System.out.println("array: " + Arrays.toString(a));
		   //swapping a[0] for a[heap size to move down the array
		   temp = a[0];
		   a[0]=a[aHeapSize];
		   a[aHeapSize] = temp;
		   aHeapSize= aHeapSize -1;//take away one every time to the maxheapify the second largest item in the list
		   MaxHeapify(a,0);
		   
	   }
	   assert(elementIsSorted(a,0));// checks to see if array is sorted
	   return a;
	   
   }
}