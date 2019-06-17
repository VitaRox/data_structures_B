package csc143.data_structures;

import java.lang.Throwable;

/**
 * @author Vita Wiebe
 * @version PA5
 */
public class UnboundedArrayQueue<E extends Object> implements UnboundedQueue<E> {

   // Fields:
   
   // unbAQueue is our underlying array object.
   // O(n)
   //E[] unbAQueue;

   // dataType is String storing data type for
   // later resizing.
   private String dataType;
   
   // Capacity is the number of elements that can be 
   // contained in UnbAQueue in its current incarnation.
   private int capacity;

   /**
    * O(n)
    * A default constructor, creates underlying array
    * with 10 elements.
    * @param Int capacity, how many elements it should
    * initially be able to contain.
    * @param String dataType, the type of data each instance
    * can work with in its underlying array.
    * Here we have a number of constructors allowing this
    * be instantiated for use by any data type.
    */
   public UnboundedArrayQueue(int capacity, String dataType) throws QueueIsEmpty {
      if(this.dataType.equals("Object")) {
        Object[] unbAQueue = new Object[capacity];
      } else if(this.dataType.equals("String")) {
         String[] unbAQueue = new String[capacity];
      } else if(this.dataType.equals("float")) {
         float[] unbAQueue = new float[capacity];
      } else if(this.dataType.equals("double")) {
         double[] unbAQueue = new double[capacity];
      } else if(this.dataType.equals("int")) {
         int[] unbAQueue = new int[capacity];
      } else if(this.dataType.equals("long")) {
         long[] unbAQueue = new long[capacity];
      } else if(this.dataType.equals("short")) {
         short[] unbAQueue = new short[capacity];
      }
   }

   
   public UnboundedArrayQueue() throws QueueIsEmpty {
       if(this.dataType.equals("Object")) {
           Object[] unbAQueue = new Object[100];
       } else if(this.dataType.equals("String")) {
           String[] unbAQueue = new String[100];
       } else if(this.dataType.equals("float")) {
           float[] unbAQueue = new float[100];
       } else if(this.dataType.equals("double")) {
           double[] unbAQueue = new double[100];
       } else if(this.dataType.equals("int")) {
           int[] unbAQueue = new int[100];
       } else if(this.dataType.equals("long")) {
           long[] unbAQueue = new long[100];
       } else if(this.dataType.equals("short")) {
           short[] unbAQueue = new short[100];
       }
   }

   public UnboundedArrayQueue(int capacity) throws QueueIsEmpty {
       unbAQueue = new String[capacity];
       this.dataType = "String";
   }

   public UnboundedArrayQueue(int capacity) throws QueueIsEmpty {
       unbAQueue = new int[capacity];
       this.dataType = "int";
   }

   public UnboundedArrayQueue(int capacity) throws QueueIsEmpty {
       unbAQueue = new float[capacity];
       this.dataType = "float";
   }

   public UnboundedArrayQueue(int capacity) throws QueueIsEmpty {
       unbAQueue = new double[capacity];
       this.dataType = "double";
   }


    /**
     * Add adds the object in question, o, to the
     * end of the queue.
     * O(n^2)
     * @param E e
     */
    public void add(E e) {
      
      if(hasSpace()) {
         unbAQueue[size()] = (Object)e;
      } else {
         Object[] tempQueue = new Object[unbAQueue.length * 2];
         // New array with an additional storage.
         for(int i = 0; i < unbAQueue.length - 1; i++) {
            tempQueue[i] = unbAQueue[i];
         }
         tempQueue[size()] = (Object)e;
         
         // Set the new array to the inital array while disposing 
         // of the initial array.
         unbAQueue = tempQueue;
      }    
    }
    
    /**
     * Remove removes first object added to the queue.
     * O(n^2)
     * (Elements are removed in the order they are added, FIFO).
     * @throws NullPointerException
     */
    public E remove() throws NullPointerException {
    
      // New array with one less element.
      Object[] tempQueue = new Object[unbAQueue.length];
      
      // "removed" is the Object taken from the head
      // of the queue.
      Object removed = null;
      
      if(hasContents()) {
         removed = (E)unbAQueue[0];
         // Copy all the elements from the initial array
         // to new array.
         for(int i = 0; i < size(); i++){
            tempQueue[i] = unbAQueue[i + 1];
            }
      }
   
      // Set the new array to the inital array while disposing 
      // of the inital array.
      unbAQueue = tempQueue;        
 
      return (E)removed;
    }
    
    /**
     * O(k)
     * @param None
     * @return The first element added to the queue (
     * 
     */
    public E peek() {
      
      try {
          if (size() == 0) {
              throw new QueueIsEmpty();
          }
      }catch(QueueIsEmpty q) {
          System.out.println(q.getMessage());
      }
      return (E)unbAQueue[0];        
    }
    
    /**
     * O(n^2)
     * Checks to see whether the queue has capacity to add more elements.
     * @param None
     * @return boolean
     */
    public boolean hasSpace() {
    
      for (int i=0; i < unbAQueue.length; i++){
         if (unbAQueue[i] == null) {
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
    
      for (int i = 0; i < unbAQueue.length; i++){
         if(unbAQueue[i] != null) {
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
      if(hasContents()) {
         for(int i = 0; i < unbAQueue.length - 1; i++) {
            if(unbAQueue[i] != null){
               count++;
            }
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
      
      for (int i = 0; i < size(); i++){
         stringVersion += (String)(unbAQueue[i] + " ");
      }
      return stringVersion;               
    }
    
    /**
     * An overload of toString to return only
     * a String representation of the first item in queue.
     * @param Object current, the object at head of
     * the queue.
     */
    public String toString(Object current) {
      
      String stringVersion = (String)current;
      return stringVersion;
    }
    
    /**
     * Where I am at: examine why 5 nulls.
     * See if using generics in overloaded toString method will help
     * (issue at hand is convertin E to String).
     * I think add() method of queue and maybe stack is wrong.
     */
    public static void main(String[] args) throws QueueIsEmpty {
    
      UnboundedArrayQueue<String> ourQueue1 = new UnboundedArrayQueue<String>();
      ourQueue1.add("Miser");
      ourQueue1.add("Dinge");
      ourQueue1.add("Schoopat");
      ourQueue1.add("Biffwaff");
      System.out.println(ourQueue1.size());
      System.out.println(ourQueue1.toString());
      System.out.println(ourQueue1.toString(ourQueue1.peek()));
    }
   

}