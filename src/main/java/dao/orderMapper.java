package dao;

/**
 *
 * @author Gan
 */
public interface orderMapper<T> {
    public boolean enqueue(T newEntry);

    public T dequeue();
    
    public T getFront();
    
    public int getSize();
    
    public boolean isEmpty();

    public void clear();
    
    public T getEntry(int index);
    
    public void update(T newEntry, int index);
}
