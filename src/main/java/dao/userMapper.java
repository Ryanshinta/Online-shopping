/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author YoonEn
 */
public interface userMapper<T> {
    
    public boolean add(T newEntry);
    
    public void clear();
    
    public int getNumberOfEntries();
    
    public T getEntry(int givenPosition);
    
    public boolean contains(T anEntry);
    
    public boolean isEmpty();

    public boolean isFull();
    
}
