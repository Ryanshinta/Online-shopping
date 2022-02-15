/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.userMapper;

/**
 *
 * @author YoonEn
 */
public class UserService<T> implements userMapper<T> {
    
    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 100;

    public UserService() {
        this(DEFAULT_CAPACITY);
    }
    
    public UserService(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Object[initialCapacity];
    }
  
    @Override
    public boolean add(T newEntry) {
        array[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }
    
    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++) {
          if (anEntry.equals(array[index])) {
            found = true;
          }
        }
        return found;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == array.length;
    }
    
}
