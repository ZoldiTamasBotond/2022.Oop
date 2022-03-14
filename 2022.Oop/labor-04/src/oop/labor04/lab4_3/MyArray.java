package oop.labor04.lab4_3;

import java.util.Arrays;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.arraycopy;

public class MyArray {
    private int length;
    private double[] elements;

    public MyArray(int length){
        this.length=length;
    }
    public MyArray(double[] elements){
        this.length=elements.length;
        this.elements=new double[length];
        arraycopy(elements,0,this.elements,0,length);
    }
    public MyArray(MyArray myArray){
        this.length=myArray.elements.length;
        this.elements=new double[length];
        arraycopy(myArray.elements,0,this.elements,0,length);
    }
    public MyArray(String fileName){
        try (Scanner scanner = new Scanner(new File(fileName))) {
            if(scanner.hasNextLine())
            {
                this.length=Integer.parseInt(scanner.nextLine());
            }
            if(scanner.hasNextLine()) {
                String[] numbers = scanner.nextLine().split(" ");
                elements=new double[numbers.length];
                for (int i=0;i<numbers.length;i++)
                {
                    this.elements[i]=Double.parseDouble(numbers[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void fillRandom(double a,double b){
        elements=new double[length];
        Random rand = new Random();
        for (int i=0;i<this.length;i++){
            this.elements[i]= rand.nextDouble(a,b);
        }
    }
    public double mean(){
        double mean=0;
        for(int i=0;i<this.length;i++)
        {
            mean+=this.elements[i];
        }
        mean/=this.length;
        return mean;
    }
    public double stddev(){
        double mean=mean();
        double stddev=0;
        for (int i = 0; i < this.length; i++) {
            stddev+=Math.pow((elements[i] - mean), 2);
        }
        stddev/=length;
        stddev=Math.sqrt(stddev);
        return stddev;
    }
    public void sort(){
        Arrays.sort(elements);
    }
    public void print(String name){
        if(this.elements!=null) {
            System.out.print(name + ": ");
            for (int i = 0; i < this.length; i++) {
                System.out.printf("%10.2f ", elements[i]);
            }
            System.out.println();
        }
    }
}
