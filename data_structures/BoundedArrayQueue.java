package csc143.data_structures;

/**
 * @author Vita Wiebe
 * @version PA5, CSC143
 */
public class BoundedArrayQueue implements BoundedQueue {

   // Fields:
   
   // bAQueue is our underlying array object.
   // O(n)
   Object[] bAQueue;
   
   // Capacity is the number of elements that can be 
   // contained in bAQueue.
   private int capacity;
   
   /**
    * Our class constructor.
    * O(n)
    * @param int bound, the maximum number of elements the 
    * underlying array object can hold.
    */
   public BoundedArrayQueue(int bound) {
      
      capacity = bound;
      bAQueue = new Object[bound];      
   }   
   
   /**
     * Add adds the object in question, o, to the queue
     * in a FIFO manner.
     * O(n^2)
     * @param Object o
     */
    public void add(Object o) {
      if(hasSpace()) {
         Object[] tempQueue = new Object[bAQueue.length];
            
      // Copy all the elements from the initial array
      // to new array, and at 1 index value ahead of original
      // index.
         for(int i = 0; i < bAQueue.length; i++){
            tempQueue[i + 1] = bAQueue[i];
            // Assign the new element to the first index position.
            tempQueue[0] = o;
            // Set the new array to the inital array while disposing 
            // of the inital array.
      bAQueue = tempQueue;
         }
      }else {
         throw new IllegalStateException();
      }               
    }
    
    /**
     * Remove removes first object added to the queue.
     * O(n^2)
     * (Elements are removed in the order they are added, FIFO).
     * @throws NullPointerException
     */
    public Object remove() {
    
      // New array with one less element.
      Object[] tempQueue = new Object[bAQueue.length - 1];
      
      // Copy all the elements from the initial array
      // to new array.
      for(int i = 0; i < bAQueue.length - 1; i++){
         if(bAQueue[i] == null) {
            throw new NullPointerException();
         }else{
            tempQueue[i] = bAQueue[i];
         }
      
       // Remove the element first added to the queue,
       // i.e. the last element in array.
      tempQueue[tempQueue.length - 1] = null;
 
      // Set the new array to the inital array while disposing 
      // of the inital array.
      bAQueue = tempQueue;        
      }
      return bAQueue;
    }
    
    /**
     * O(k)
     * @param None
     * @return The first element added to the queue (
     * i.e. the last element; null if empty.
     */
    public Object peek() {
    
      if (bAQueue.length == 0) {
         return null;
      }else{
         return bAQueue[bAQueue.length - 1];
      }
    }
    
    /**
     * O(n^2)
     * Checks to see whether the queue has capacity to add more elements.
     * @param None
     * @return boolean
     */
    public boolean hasSpace() {
    
      for (int i=0; i < bAQueue.length; i++){
         if (bAQueue[i] == null) {
            return true;
         }
      }   
      return false;
    }
    
    /**
     * O(n^2)
     * Checks to see whether the queue has had any elements added to it.
     * @param None
     * @return boolean
     */
    public boolean hasContents() {
    
      for (int i = 0; i < bAQueue.length; i++){
         if(bAQueue[i] != null) {
            return true;
         }
      }
      return false;
    }
    
    /**
     * O(n^2)
     * @param None
     * @return The number of elements that are currently stored in the structure.
     */
    public int size() {
    
      // Tracks the number of elements that aren't null (empty).
      int count = 0;
      
      for(int i = 0; i < bAQueue.length; i++) {
         if(bAQueue[i] != null){
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
      
      for (int i = 0; i < bAQueue.length - 1; i++){
         stringVersion += bAQueue[i].toString();
      }
      return stringVersion;               
    }
    
    /**
     * O(k)
     * @param None
     * @return The maximum value of size for a structure.
     */
    public int capacity() {
      if (bAQueue == null){
         System.out.println("The queue has not been properly initialized.");
      }
      return bAQueue.length;      
    }
   
   
}





