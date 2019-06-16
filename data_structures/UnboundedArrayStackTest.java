package csc143.data_structures;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class UnboundedArrayStackTest {


   public enum TestElems {DETROIT, CHICAGO, ST_LOUIS, NEW_YORK_CITY, SEATTLE, 
      NEW_ORLEANS, ATLANTA};
   
   UnboundedArrayStack unBAS;
    
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      unBAS = new UnboundedArrayStack(5);
      for (TestElems elem : TestElems.values()) {
         unBAS.push(elem);
      }
      
   }


   @Test public void test1() {
      if(unBAS.hasContents()) {
         System.out.println(unBAS.toString());
      }
            
   }
   
   @Test public void test2() {
      if(unBAS.hasContents()) {
         System.out.println(unBAS.toString(unBAS.peek()));
      }
            
   }
   
   // To test that pop() method is working properly
   // Should be returning the last element, the one after, and so on.
   @Test public void test3() {
      if(unBAS.hasContents()) {
         System.out.println(unBAS.toString(unBAS.pop()));
         System.out.println(unBAS.toString(unBAS.pop()));
         System.out.println(unBAS.toString(unBAS.pop()));
         System.out.println(unBAS.toString(unBAS.pop()));
         System.out.println(unBAS.toString(unBAS.pop()));
      }
            
   }
}
