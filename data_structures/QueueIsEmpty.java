package csc143.data_structures;

/**
 * @author Vita Wiebe
 * @version LA6
 * Used to create an exception object in the event the queue
 * in question is empty when a method which requires non-null
 * elements is called.
 */
public class QueueIsEmpty extends DataStructureException {

    /**
     * Our class constructor.
     * @param String msg
     */
    public QueueIsEmpty(String msg) {
        super("Queue is empty.");
    }
}