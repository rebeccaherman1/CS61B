package Synthesizer;

public class ArrayRingBuffer extends AbstractBoundedQueue {
  /* Index for the next dequeue or peek. */
  private int first;           
  /* Index for the next enqueue. */
  private int last;             
  /* Array for storing the buffer data. */
  private double[] rb;

  /** Create a new ArrayRingBuffer with the given capacity. */
  public ArrayRingBuffer(int capacity) {
    // TODO: Create new array with capacity elements.
    rb= new double[capacity]; 
    //       first, last, and fillCount should all be set to 0. 
    first, last, fillCount= 0, 0, 0; 
    //       this.capacity should be set appropriately. Note that the local variable here shadows the field we inherit from AbstractBoundedQueue.
    this.capacity= capacity; 
  }

  /** Adds x to the end of the ring buffer. If there is no room, then
    * throw new RuntimeException("Ring buffer overflow") 
    */
  public void enqueue(double x) {
    // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
    try {
      rb[last]= x; 
      fillCount++;
      last++; 
    }
    // is there room?
    catch (this.isFull()) {

    }
  }

  private void 

  /** Dequeue oldest item in the ring buffer. If the buffer is empty, then
    * throw new RuntimeException("Ring buffer underflow");
    */
  public double dequeue() {
    // TODO: Dequeue the first item. Don't forget to decrease fillCount and update first.
  }

  /** Return oldest item, but don't remove it. */
  public double peek() {
    // TODO: Return the first item. None of your instance variables should change.
  }

}
