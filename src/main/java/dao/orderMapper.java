package dao;

/**
 *
 * @author Gan
 */
public interface orderMapper<T> {
    public void enqueue(T newEntry);

    public T dequeue();
    
    public T getFront();
    
    public int getSize();
    
    public boolean isEmpty();

    public void clear();
    
    public T getEntry(int index);
    
    public void swap(int index1, int index2);
    
    public void update(T newEntry, int index);
    
    public boolean bringFront(int index);
}
