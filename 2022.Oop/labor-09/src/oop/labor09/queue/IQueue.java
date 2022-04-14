package oop.labor09.queue;

public interface IQueue {
    void enQueue(Object newobj);
    Object deQueue();
    void printQueue();
    boolean isEmpty();
    boolean isFull();
}
