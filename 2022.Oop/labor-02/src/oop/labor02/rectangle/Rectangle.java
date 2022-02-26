package oop.labor02.rectangle;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle (double length, double width){
        this.length=length;
        this.width=width;
    }
    public double getLength(){
        return this.length;
    }
    public double getWidth(){
        return this.width;
    }
    public double area()
    {
        return length*width;
    }
    public double perimeter()
    {
        return length*2+width*2;
    }
}
