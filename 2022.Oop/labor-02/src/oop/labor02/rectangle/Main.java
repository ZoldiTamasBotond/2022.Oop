package oop.labor02.rectangle;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        Rectangle[] rectangles = new Rectangle[10];

        for (int i=0;i<10;i++)
        {
            double length = 1 + rand.nextInt(10);
            double width = 1 + rand.nextInt(10) ;
            rectangles[ i ] = new Rectangle(length, width);
        }
        for (int i=0;i<10;i++)
        {
            System.out.println(rectangles[i].getLength()+": "+rectangles[i].getWidth()+": "+rectangles[i].area()+": "+rectangles[i].perimeter());
        }

        double sum=0;

        for (int i=0;i<10;i++)
        {
            sum+=rectangles[i].area();
        }
        System.out.println(sum);
    }
}
