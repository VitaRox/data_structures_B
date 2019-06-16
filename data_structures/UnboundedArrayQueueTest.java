package csc143.data_structures;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/*
Where I'm at: evaluate whether enum best way to provide test elements.
There seems to be an issue with that, not with the classes being tested.
*/
public class UnboundedArrayQueueTest {

   public enum TestElems {DETROIT, CHICAGO, ST_LOUIS, NEW_YORK_CITY, SEATTLE, 
      NEW_ORLEANS, ATLANTA};
   
   UnboundedArrayQueue unBAQ;
    
   /** Fixture initialization (common initialization
       for all tests). **/
   @Before public void setUp() throws QueueIsEmpty {
      unBAQ = new UnboundedArrayQueue(10);
      for (TestElems elem : TestElems.values()) {
         unBAQ.add(elem);
      }
      
   }

   // Test the general toString method
   @Test public void test1() {
         System.out.println(unBAQ.toString());  
   }
   
   // Test overloaded toString method on "peeked" item
   @Test public void test2() {
         System.out.println(unBAQ.toString(unBAQ.peek()));        
   }
   
   // To test that pop() method is working properly
   // Should be returning the last element, the one after, and so on.
   @Test public void test3() {
      if(unBAQ.hasContents()) {
         System.out.println(unBAQ.toString(unBAQ.remove()));
         System.out.println(unBAQ.toString(unBAQ.remove()));
         System.out.println(unBAQ.toString(unBAQ.remove()));
         System.out.println(unBAQ.toString(unBAQ.remove()));
         System.out.println(unBAQ.toString(unBAQ.remove()));
      }
   }
   
   @Test public void test4() {
      unBAQ.add("HelloTest");
         System.out.println(unBAQ.toString(unBAQ.peek()));
   }
            
}
