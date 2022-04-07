package oop.labor08.lab8_2;

import java.util.ArrayList;

public class StackInheritance extends ArrayList<Object> {

    private int capacity;

    public StackInheritance( int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean isEmpty() {
        return this.size()==0;
    }


    public void push(Object newObj){
        if(!isFull()){
            this.add(newObj);
        }
    }

    public void pop(){
        if(!isEmpty()){
            remove(size()-1);
        }
    }

    public Object top(){
        return this.get(this.size()-1);
    }

    public boolean isFull(){
        return this.size()==capacity;
    }

    public int getSize(){
        return this.size();
    }

}
