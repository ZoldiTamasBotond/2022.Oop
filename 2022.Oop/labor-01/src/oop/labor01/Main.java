package oop.labor01;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static double[] max2( double array[] ){
        double max[] ={Double.NEGATIVE_INFINITY,
                Double.NEGATIVE_INFINITY};
        if( array.length == 0 ){
            return max;
        }
        if (array.length==1)
        {
            max[0]=array[0];
            max[1]=array[0];
            return max;
        }
        if(array[1]>array[0]) {
            max[0] = array[0];
            max[1] = array[1];
        }
        else
        {
            max[1]=array[0];
            max[0]=array[1];
        }
        for (int i=2;i<array.length;i++)
        {
            if (array[i]>max[1])
            {
                max[0]=max[1];
                max[1]=array[i];
            }
            else if (array[i]>max[0])
            {
                max[0]=array[i];
            }
        }
        return max;
    }

    public static double stddev(double array[]){
        if(array.length==0)
        {
            return Double.NaN;
        }
        double sum=0;
        double avg=mean(array);
        for (int i=0;i<array.length;i++)
        {
            sum+=(array[i]-avg)*(array[i]-avg);
        }
        sum/= array.length;
        sum=Math.sqrt(sum);
        return sum;
    }

    public static double mean(double array[])
    {
        if (array.length==0)
        {
            return Double.NaN;
        }
        double avg=0;
        for (int i=0;i<array.length;i++)
        {
            avg+=array[i];
        }
        avg/= array.length;
        return avg;
    }
    public static int countBits(int number){
        int counter=0;
        while (number>0) {

            counter+=number &1;

            number=number>>1;
        }
        return counter;
    }

    public static byte getBit(int number, int order){
        for (int i=0;i<order;i++)
        {
            number/=2;
        }
        if (number==0){
            return -1;
        }
        return (byte)(number%2);
    }

    public static double maxElement( double array[] ){
        double max = Double.NEGATIVE_INFINITY;
        for( int i=0; i<array.length; ++i ){
            if( array[i] > max){
                max = array[ i ];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        String szo="ALMAFA";
        for (int i=0;i<szo.length()+1;i++)
        {
            for (int j=0;j<i;j++)
            {
                System.out.print(szo.charAt(j));
            }
            System.out.println();
        }

        String nev="Zoldi Tamas Botond";
        String[] splitted =nev.split(" ");
        for (int i=0;i< splitted.length;i++)
        {
            System.out.print(splitted[i].charAt(0));
        }
        System.out.println();
        double x[] ={7, 1, -3, 45, 9};
        System.out.printf("MAX: %6.2f\n", maxElement( x ));
        System.out.println(getBit(13,2));
        System.out.println(countBits(15));
        System.out.println(mean(x));
        System.out.println(stddev(x));
        double max[]=max2(x);
        System.out.println(max[0]+" "+max[1]);
    }
}
