/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ghowser
 */
public class BinaryCounterTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
      {
        // TODO code application logic here
        BinaryCounter counter = new BinaryCounter();
        int[] x = new int[5];
        x = counter.Reset(x);
        System.out.println("String of all zero:  " + counter.toString(x));
        x = counter.Bump(x);
        System.out.println("String is binary 1:  " + counter.toString(x));
        x = counter.Reset(x);
        System.out.println("\nNow count from zero to overflow by 1");
        while (!counter.overflow)
          {
            System.out.print("x is now:  " + counter.toString(x) + "\t");
            if (counter.overflow)
              {
                System.out.print("overflow is true.\n");
              }
            else
              {
                System.out.print("Overflow is false.\n");
                x = counter.Bump(x);
              }
          }
        if (counter.overflow)
          {
            System.out.print("overflow is true.\n");
          }
        else
          {
            System.out.print("Overflow is false.\n");
          }
      }
}

