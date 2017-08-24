/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Gerry Howser
 * @date March 3, 2016
 * @Pre-conditions: The input array must be an integer array with length > 0.
 * @Purpose: This class provides methods to set an array of integers to all
 * zeros and a method to "bump" the array up by one as a binary counter for use
 * in a brute force method. When bumping the array causes the binary counter to
 * overflow, the boolean overflow is set to true; i.e., the boolean overflow
 * should be checked each time "bump" is called. While the length of the integer
 * array does not matter, this class will halt the program if an array is
 * "bumped" that contains any other values than "0" or "1".
 *
 */
public class BinaryCounter {

    public boolean overflow = false;

    //Constructors
    public BinaryCounter()
      {
      }

    //methods
    //Pre-condition:  Array has a length > 0
    //Post condition:  The returned array is filled with integer "0" and
    //                 overflow is set to "false".
    public int[] Reset(int[] x)
      {
        assert (x.length > 0);
        int i = 0;
        overflow = false;
        while (i < x.length)
          {
            x[i] = 0;
            i++;
          }
        return x;
      }

    //Pre-condition:  Array contains only "0" and "1" and length > 0
    //Post condition:  The returned array is "bumpped" by 1 as a binary counter
    //                 If the binary counter overflows, overflow is set to 
    //                 "true" otherwise overflow is set to "false"
    public int[] Bump(int[] x)
      {
        assert (x.length > 0);
        assert (isBinary(x));
        int i = x.length - 1;
        overflow = true;
        while ((i >= 0) && (overflow))
          {
            if (x[i] == 1)
              {
                x[i] = 0;
              }
            else
              {
                x[i] = 1;
                overflow = false;
              }
            i--;
          }
        return x;
      }

    public String toString(int[] x)
      {
        String result = " ";
        int i = 0;
        while (i < x.length)
          {
            result = result + x[i];
            i++;
          }
        return result;
      }

    //assert methods
    public boolean isBinary(int[] x)
      {
        boolean result = true;
        int i = 0;
        while ((i <= x.length) && (result))
          {
            if ((x[i] != 0) && (x[i] != 1))
              {
                result = false;
              }
            i++;
          }
        return result;
      }
}
