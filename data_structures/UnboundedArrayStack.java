package csc143.data_structures;

/**
 * @author Vita Wiebe
 * @version PA5
 */
public class UnboundedArrayStack implements UnboundedStack {

   // Fields:
   
   // UnbAStack is our underlying array object.
   // O(n)
   Object[] unbAStack;
   
   // Capacity is the number of elements that can be 
   // contained in bStack.
   // zero time op
   private int capacity;
   
   /**
    * O(n)
    * A default constructor, creates underlying array
    * with 10 elements.
    * @param None
    */
   public UnboundedArrayStack() {
      capacity = 10;
      unbAStack = new Object[capacity];
   }
   
   /**
    * A 0-param constructor for custom-sized UAS
    */
   public UnboundedArrayStack(int capacity) {
      unbAStack = new Object[capacity];
   }
   
   /**
    * Push adds the object in question, o, to the top of the stack.
    * O(n^2)
    * @param Object o
    */     
   public void push(Object o){
      
      if(hasSpace()) {     
         
         // Place new object at the top of the stack
         // i.e. the last position.
         unbAStack[size()] = o;
         
      }else{       
         // If it doesn't have enough room for addition,
         // creates a new array with twice as many elements.
         Object[] newStack = new Object[size() * 2];
         for(int i = 0; i < size() - 1; i++) {
            newStack[i] = unbAStack[i];
         }
         // Place new object at the top of the stack.
         newStack[size()] = o;
         unbAStack = newStack;         
      }    
    }
    
    /**
     * Pop removes the last object added to the stack
     * i.e. the index after index of last element.
     * O(n^2)
     * @param None
     * @throws NullPointerException
     */
    public Object pop(){
      
      Object popped;
      try {
         // Remove element on the "top" of the stack (i.e. last element).
         // (the last element).
         popped = unbAStack[size() - 1];
         unbAStack[size() - 1] = null;               
      }catch(NullPointerException e){
         throw new NullPointerException("Stack contains no elements.");   
      }
      return popped;
    }
    
    /**
     * Peek lets the user see what the most-recently-added element in the stack is.
     * O(n)
     * @param None
     * @throws NullPointerException
     * @return Last object added to the stack.
     */
    public Object peek() {
    
      if (unbAStack.length == 0) {
         return null;
      }else{
         return unbAStack[size() - 1];
      }
    }
    
    /**
     * Checks to see whether the current version
     * of the stack has capacity to add more elements.
     * O(n^2)
     * @param None
     * @return boolean
     */
    public boolean hasSpace() {
    
      for (int i=0; i < unbAStack.length; i++){
         if (unbAStack[i] == null) {
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
    
      for (int i = 0; i < unbAStack.length; i++){
         if(unbAStack[i] != null) {
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
      
      for(int i = 0; i < unbAStack.length; i++) {
         if(unbAStack[i] != null){
            count++;
         }
      }
      return count;
   }
   
   /**
     * O(n^2)
     * @param None
     * @return A string representation of the structure.
     */
    public String toString() {
    
      String stringVersion = new String("");
      
      for (int i = 0; unbAStack[i] != null; i++){
         stringVersion += unbAStack[i].toString() + " ";
      }
      return stringVersion;               
    }
    
    /**
     * An overload of toString to return only
     * a String representation of the top item on stack.
     * @param Object current, the object on top of
     * the stack.
     */
    public String toString(Object current) {
      
      String stringVersion = new String("" + current + " ");
      return stringVersion;
    }
}