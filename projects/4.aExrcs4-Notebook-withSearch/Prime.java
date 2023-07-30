 
import java.util.ArrayList;

/**
 * Write a description of class prime here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Prime
{
    ArrayList<Integer> li;
    public boolean isPrime(int a){
    int x = 2;
    boolean test = true; 
    while ( x<=a/2)
     { 
      if (a%x == 0 ) {
      test = false;}
      ++x;
     }
    if (test)
      System.out.println(a + " is a prime number.");
    else
      System.out.println(a + " is not a prime number.");
      return test;
    }
    public void addPrimes()
    {
        li = new ArrayList<>();
     for (int i = 0; i <= 1000; i += 1)
     {
      if (isPrime(i))
      {li.add((i));}
    }
     System.out.println(li.size());
    
    }
}