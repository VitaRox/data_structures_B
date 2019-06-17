package csc143.data_structures;

/**
 * @author Vita Wiebe
 * @version PA5, CSC143
 */
public class BoundedArrayStack implements BoundedStack {

   // Fields:
   
   // bStack is our underlying array object.
   // O(n)
   Object[] bAStack;
   
   // Capacity is the number of elements that can be 
   // contained in bStack.
   // zero time op
   private int capacity;
   
   /**
    * Our class constructor.
    * O(n)
    * @param int bound, the maximum number of elements the 
    * underlying array object can hold.
    */
   public BoundedArrayStack(int bound) {
      
      capacity = bound;
      bAStack = new Object[bound];      
   }
      
   
   /**
    * Push adds the object in question, o, to the top of the stack.
    * O(n^2)
    * @param Object o
    * @throws IndexOutOfBoundsException
    */     
   public void push(Object o) {
    
      if(hasSpace()) {
      
         // Creates a new array with twice as many elements.
         Object[] newStack = new Object[capacity * 2];
         
         // Populates new array with elements of bStack, 
         // beginning with second element (index 1) of newStack.
         for (int i = 1; i < bAStack.length - 1; i++) {
            newStack[i] = bAStack[i - 1];
         }
         // Place new object at the top of the stack.
         newStack[0] = o;
         bAStack = newStack;
      }else{
         throw new IndexOutOfBoundsException("Stack is full.");
      }    
    }
    
    /**
     * Pop removes the last object added to the stack.
     * O(n^2)
     * @param None
     * @throws NullPointerException
     */
    public Object pop() {
    
      try {
         // Remove element on the "top" of the stack (i.e. LIFO).
         bAStack[bAStack.length] = null;
      }catch(NullPointerException e){
         throw new NullPointerException("Stack contains no elements.");   
      }
      return bAStack;
    }
    
    /**
     * Peek lets the user see what the most-recently-added element in the stack is.
     * O(n)
     * @param None
     * @throws NullPointerException
     * @return Last object added to the stack.
     */
    public Object peek() {
    
      if (bAStack.length == 0) {
         return null;
      }else{
         return bAStack[0];
      }
    }
    
    /**
     * Checks to see whether the stack has capacity to add more elements.
     * O(n^2)
     * @param None
     * @return boolean
     */
    public boolean hasSpace() {
    
      for (int i=0; i < bAStack.length; i++){
         if (bAStack[i] == null) {
            return true;
         }
      }   
      return false;
    }
    
    /**
     * Checks to see whether the stack has had any elements added to it.
     * O(n^2)
     * @param None
     * @return boolean
     */
    public boolean hasContents() {
    
      for (int i = 0; i < bAStack.length; i++){
         if(bAStack[i] != null) {
            return true;
         }
      }
      return false;
    }
    
    /**
     * O(k)
     * @param None
     * @return The number of elements that are currently stored in the structure
     */
    public int size() {
    
      // Tracks the number of elements that aren't null (empty).
      int count = 0;
      
      for(int i = 0; i < bAStack.length; i++) {
         if(bAStack[i] != null){
            count++;
         }
      }
      return count;
    }
    
    /**
     * O(n^2)
     * @param None
     * @return A string representation of the stack.
     */
    public String toString() {
    
      String stringVersion = new String("");
      
      for (int i = 0; i < bAStack.length - 1; i++){
         stringVersion += bAStack[i].toString();
      }
      return stringVersion;
    }
    
    /**
     * O(k)
     * @param None
     * @return The maximum value of size for a structure.
     */
    public int capacity() {
    
      if (bAStack == null){
         System.out.println("The stack has not been properly initialized.");
      }
      return bAStack.length;      
    }
}