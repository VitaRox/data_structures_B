package csc143.data_structures;

/**
 * @author Vita Wiebe
 * @version LA6
 * An interface for interacting with a bounded stack data type
 */
public interface BoundedStack {
    
    /**
     * Push adds the object, o, in question to the top of the stack.
     * @param Object o
     * @throws IllegalArgumentException
     */     
    public void push(Object o);
    
    /**
     * Pop removes the last object added to the stack.
     * @param None
     * @throws NullPointerException
     */
    public Object pop();
    
    /**
     * Peek lets the user see what the most-recently-added element in the stack is.
     * @param None
     * @throws NullPointerException
     * @return Last object added to the stack.
     */
    public Object peek();
    
    /**
     * Checks to see whether the stack has capacity to add more elements.
     * @param None
     * @return boolean
     */
    public boolean hasSpace();
    
    /**
     * Checks to see whether the stack has had any elements added to it.
     * @param None
     * @return boolean
     */
    public boolean hasContents();
    
    /**
     * @param None
     * @return The number of elements that are currently stored in the structure
     */
    public int size();
    
    /**
     * @param None
     * @return A string representation of the stack.
     */
    public String toString();
    
    /**
     * @param None
     * @return The maximum value of size for a structure.
     */
    public int capacity();
}
