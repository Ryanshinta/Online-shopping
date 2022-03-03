package service;

import java.util.Iterator;

import dao.announcementMapper;

public class announcementService<T> implements announcementMapper<T> {

    // array based implementation//
    private T[] setArray;
    int numberOfElements;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int NOT_FOUND = -1;

    // 2 constructors
    public announcementService() {
        this(DEFAULT_CAPACITY);
    }

    public announcementService(int capacity) {
        numberOfElements = 0;
        setArray = (T[]) new Object[capacity];
    }

    public boolean add(T newElement) {
        // check the duplication
        for (int i = 0; i < numberOfElements; i++) {
            if (setArray[i].equals(newElement)) {
                return false;
            }
        }
        // check the array size , if is full double array
        if (isArrayFull()) {
            doubleArray();
        }
        // insert into
        setArray[numberOfElements] = newElement;
        numberOfElements++;

        return false;
    }

    public boolean contains(T target) {
        int search = NOT_FOUND;

        for (int index = 0; index < numberOfElements && search == NOT_FOUND; index++)
            if (setArray[index].equals(target))
                search = index;

        return (search != NOT_FOUND);
    }

    public boolean remove(T anElement) {
        for (int i = 0; i < numberOfElements; i++) {
            if (setArray[i].equals(anElement)) {
                removeGap(i);
                numberOfElements--;
                return true;
            }
        }
        return false;
    }

    public boolean checkSubset(announcementMapper anotherSet) {
        if (anotherSet instanceof announcementService) {
            announcementService passInSet = (announcementService) anotherSet; // casting

            // size
            if (passInSet.numberOfElements > this.numberOfElements) {
                return false;
            }

            // checking
            for (int i = 0; i < passInSet.numberOfElements; i++) {
                boolean isFound = false;
                for (int j = 0; j < this.numberOfElements && !isFound; j++) {
                    if (passInSet.setArray[i].equals(this.setArray[j])) {
                        isFound = true;
                    }
                }
                if (!isFound) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(announcementMapper anotherSet) {// call the add function
        // checking the instanceof and converting - casting from Interface type to
        // announcementService
        if (anotherSet instanceof announcementService) {
            announcementService aSet = (announcementService) anotherSet;
            for (int i = 0; i < aSet.numberOfElements; i++) {
                add((T) aSet.setArray[i]);
            }
        }
    }

    public announcementMapper intersection(announcementMapper anotherSet) {
        announcementMapper<T> tempSet = new announcementService<T>();

        if (anotherSet instanceof announcementService) {
            announcementService passInSet = (announcementService) anotherSet; // casting

            // checking
            for (int i = 0; i < passInSet.numberOfElements; i++) {
                boolean isFound = false;
                for (int j = 0; j < this.numberOfElements && !isFound; j++) {
                    if (passInSet.setArray[i].equals(this.setArray[j])) {
                        isFound = true;
                    }
                }
                if (isFound) {
                    tempSet.add((T) passInSet.setArray[i]);
                }
            }
        }
        return tempSet;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;

    }

    public boolean isArrayFull() {
        return numberOfElements == setArray.length;
    }

    public int size() {
        return numberOfElements;
    }

    public void doubleArray() {
        T[] existingArray = setArray;
        setArray = (T[]) new Object[existingArray.length * 2];
        for (int i = 0; i < existingArray.length; i++) {
            setArray[i] = existingArray[i];
        }
    }

    private void removeGap(int givenPosition) {
        int removeIndex = givenPosition;
        int lastIndex = numberOfElements - 1;

        for (int index = removeIndex; index < lastIndex; index++) {
            setArray[index] = setArray[index + 1];
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < numberOfElements; i++) {
            output += setArray[i] + "\n";
        }
        return output;
    }

    @Override
    public Iterator<T> getIterator() {
        return new IteratorForannouncementService();
    }
    // * thus, it is required to implement the Iterator interface that consume by
    // announcementMapper */

    private class IteratorForannouncementService implements Iterator<T> {
        private int nextIndex;

        public IteratorForannouncementService() {
            nextIndex = 0; // ** make the runner start from index 0 */
        }

        // ** 2 compulsory methods to be override -> hasNext and next */
        public boolean hasNext() {
            return nextIndex < numberOfElements;
        }

        public T next() {
            if (hasNext()) {
                T nElement = setArray[nextIndex++]; // ** post increment */
                return nElement;
            } else {
                return null;
            }
        }
    }

}
