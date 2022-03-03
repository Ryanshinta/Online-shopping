package dao;

import java.util.Iterator;

public interface announcementMapper<T> {
    public boolean add(T newElement);

    public boolean remove(T anElement);

    // public boolean checkSubset(SetInterface anotherSet);

    // public void union(SetInterface anotherSet);

    // public SetInterface intersection(SetInterface anotherSet);

    public boolean isEmpty();

    // ** */ include the iterator operation -> create a runner / traveler
    public Iterator<T> getIterator();
}
