package csc143.data_structures;

/**
 * @author Vita Wiebe
 * @version LA6
 * An interface for interacting with a bounded queue data type.
 */
public interface BoundedQueue {

    /**
     * Add adds the object, o, in question to the queue.
     * @param Object o
     * @throws IllegalArgumentException
     */
    public void add(Object o);
    
    /**
     * Remove removes first object added to the queue.
     * (Elements are removed in the order they are added).
     * @throws NullPointerException
     */
    public Object remove();
    
    /**
     * @return The first element added to the queue; null if empty.
     */
    public Object peek();
    
    /**
     * Checks to see whether the queue has capacity to add more elements.
     * @param None
     * @return boolean
     */
    public boolean hasSpace();
    
    /**
     * Checks to see whether the queue has had any elements added to it.
     * @param None
     * @return boolean
     */
    public boolean hasContents();
    
    /**
     * @param None
     * @return The number of elements that are currently stored in the structure.
     */
    public int size();
    
    /**
     * @param None
     * @return A string representation of the structure.
     */
    public String toString();
    
    /**
     * @param None
     * @return The maximum value of size for a structure.
     */
    public int capacity();
}