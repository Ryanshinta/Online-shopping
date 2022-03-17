package service;

import dao.orderMapper;

/**
 *
 * @author Gan
 */
public class orderService<T> implements orderMapper<T> {
    private Node lastNode;

    public orderService() {
        lastNode = null;
    }
    @Override
    public boolean enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {  // going to insert the very first node to the queue
            newNode.next = newNode;
        } else { //queue not empty
            newNode.next = lastNode.next;    //lastnode.next = first inserted node
            lastNode.next = newNode;
        }
        lastNode = newNode;
        return true;

    }
    
    @Override
    public T dequeue() {
        T topValue = getFront();

        if (!isEmpty()) {

            topValue = lastNode.next.data;

            if (lastNode.next == lastNode) {
                lastNode = null;
            } else {
                lastNode.next = lastNode.next.next;
            }
        }

        return topValue;
    }
    
    @Override
    public T getFront() {
        T topValue = null;

        if (!isEmpty()) {
            topValue = lastNode.next.data;

        }
        return topValue;
    }
    @Override
    public int getSize() {
        int size = 1;
        Node curNode = lastNode;
        if (isEmpty()) {
            return 0;
        } else {
            while (curNode.next != lastNode) {
                curNode = curNode.next;
                size++;
            }
        }
        return size;
    }
    @Override
    public boolean isEmpty() {
        return lastNode == null;
    }
    @Override
    public void clear() {
        lastNode = null;
    }
    @Override
    public T getEntry(int index) {
        T output = null;
        Node curNode = lastNode;

        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
            output = curNode.data;
        }

        return output;
    }
    @Override
    public void update(T newEntry, int index) {
        Node curNode = lastNode;

        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }

        curNode.data = newEntry;
    }
    
    private class Node {

        private T data;
        private Node next; // pointer
        //both constructor is for node creation 
        // mean when user want to add a new item to the link collection
        // it need to trigger either one of this constructor

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}

