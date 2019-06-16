package csc143.data_structures;

/**
 * @author Vita Wiebe
 * @version LA6
 * An interface for interacting with an unbounded queue data type.
 */
public interface UnboundedQueue<E> {

    /**
     * Add adds the object, o, in question to the queue.
     * @param E o
     */
    public void add(E o);
    
    /**
     * Remove removes first object added to the queue.
     * (Elements are removed in the order they are added).
     */
    public E remove();
    
    /**
     * @return The first element added to the queue; null if empty.
     */
    public E peek();
    
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
     * @return The number of elements that are currently stored in the structure.
     */
    public String toString();

}