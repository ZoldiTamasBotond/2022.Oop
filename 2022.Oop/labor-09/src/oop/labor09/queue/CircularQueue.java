package oop.labor09.queue;

import java.util.Arrays;
import java.util.Objects;

public class CircularQueue implements IQueue{

    private final int CAPACITY;
    private Object[] items;
    private int front;
    private int rear;

    public CircularQueue(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        this.items=new Object[CAPACITY];
        this.rear=0;
        this.front=0;
    }

    @Override
    public void enQueue(Object newobj) {
        if(!isFull()){
            items[front%CAPACITY]=newobj;
            front++;
        }
    }

    @Override
    public Object deQueue() {
        if(!isEmpty()){
            Object item=items[rear%CAPACITY];
            items[rear%CAPACITY]=null;
            rear++;
            return item;
        }
        else{
            return null;
        }
    }

    @Override
    public void printQueue() {
        for(int i=0;i<front-rear;i++){
            System.out.print(items[i]+" ");
        }
        System.out.print(front+" "+rear+" ");
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return front==rear;
    }

    @Override
    public boolean isFull() {
        return front-rear == CAPACITY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircularQueue that = (CircularQueue) o;
        if(this.items.length!=that.items.length) return false;
        for(int i=this.rear, j=that.rear;
        i<this.front && j< that.front;
        i++,j++){
            if(!this.items[i%this.CAPACITY].equals(that.items[j% that.CAPACITY]))return false;
        }
        return true;
    }

}
