package csc143.data_structures;

/**
 * @author Vita Wiebe
 * @version LA6
 * Used to create an exception object in the event the bounded 
 * stack in question is full.
 */
public class StackIsFull extends DataStructureException {
    
    
    /**
     * Our class constructor.
     * @param String msg
     */
    public StackIsFull(String msg) {
        super("Stack is full.");

    }
}