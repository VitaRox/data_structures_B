package csc143.data_structures;

/**
 * @author Vita Wiebe
 * @version LA6
 * Used to create an exception object in the event the bounded queue
 * in question is full.
 */
public class QueueIsFull extends DataStructureException {
    
      /**
     * Our class constructor.
     * @param String msg
     */
    public QueueIsFull(String msg) {
        super("Queue is full.");
    }
}