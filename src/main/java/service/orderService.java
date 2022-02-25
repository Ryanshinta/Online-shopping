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

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {  // going to insert the very first node to the queue
            newNode.next = newNode;
        } else { //queue not empty
            newNode.next = lastNode.next;    //lastnode.next = first inserted node
            lastNode.next = newNode;
        }
        lastNode = newNode;

    }

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

    public T getFront() {
        T topValue = null;

        if (!isEmpty()) {
            topValue = lastNode.next.data;

        }
        return topValue;
    }

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

    public boolean isEmpty() {
        return lastNode == null;
    }

    public void clear() {
        lastNode = null;
    }

    public T getEntry(int index) {
        T output = null;
        Node curNode = lastNode;

        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
            output = curNode.data;
        }

        return output;
    }

    public void swap(int index1, int index2) {
        Node curNode1 = lastNode;
        Node curNode2 = lastNode;
        T temp = null;

        for (int i = 0; i < index1; i++) {
            curNode1 = curNode1.next;
        }
        for (int i = 0; i < index2; i++) {
            curNode2 = curNode2.next;
        }

        temp = curNode1.data;
        curNode1.data = curNode2.data;
        curNode2.data = temp;

    }

    public void update(T newEntry, int index) {
        Node curNode = lastNode;

        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }

        curNode.data = newEntry;
    }

    public boolean bringFront(int index) {
        Node beforeNode = lastNode;
        Node afterNode = lastNode;
        boolean proceed = false;

        if (!isEmpty()) {
            if (index == 1) {
                return true;
            }

            for (int i = 0; i < index - 1; i++) {
                beforeNode = beforeNode.next;
            }
            for (int i = 0; i < index + 1; i++) {
                afterNode = afterNode.next;
            }

            if (index == getSize()) {
                lastNode = beforeNode;
                proceed = true;
            } else {
                beforeNode.next.next = lastNode.next;
                lastNode.next = beforeNode.next;
                beforeNode.next = afterNode;

                proceed = true;

            }
        }

        return proceed;
    }

    public boolean contains(T entry) {
        boolean found = false;
        Node curNode = lastNode;
        
        if (!isEmpty()) {
            for (int i = 0; !found && (i < getSize()); i++) {
                curNode = curNode.next;
                if (curNode.data.equals(entry)) {
                    found = true;
                }
            }
        }
        return found;
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

