import java.util.Random;
/** 
 * Author:  Roderick Vogel
   Creation date:  10/14/15
   
  Purpose: generates  random numbers 
   **/
public class MyRandom {
	private int randumNumber;
	Random rand;

	public MyRandom()
	{
		  rand= new Random();
		
	}
	public int intRand(int i)
	{
		return randumNumber = rand.nextInt(i);
	}

}
