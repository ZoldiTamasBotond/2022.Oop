package oop.labor02.dateutil;

import oop.labor02.rectangle.Rectangle;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println(DateUtil.isValidDate(2000,2,29) == true);
        System.out.println(DateUtil.isValidDate(2000,2, 30) == false);
        System.out.println(DateUtil.isValidDate(1900,2, 29) == false);
        System.out.println(DateUtil.isValidDate(1900,2, 28) == true);
        System.out.println(DateUtil.isValidDate(-1900,2, 28) == false);
        System.out.println(DateUtil.isValidDate(0,2, 28) == false);
        System.out.println(DateUtil.isValidDate(2021,2, 29) == false);
        System.out.println(DateUtil.isValidDate(2020,2, 29) == true);
        System.out.println(DateUtil.isValidDate(2020,1, 32) == false);
        System.out.println(DateUtil.isValidDate(2020,1, 0) == false);
        System.out.println(DateUtil.isValidDate(2020,0, 0) == false);
        System.out.println(DateUtil.isValidDate(2020,4, 31) == false);

        int counter=0;
        for (int i=0;i<1000;i++)
        {
            MyDate date= new MyDate(1 + rand.nextInt(2022),1 + rand.nextInt(12),1+ rand.nextInt(31));
            if (DateUtil.isValidDate(date.getYear(), date.getMonth(), date.getDay())){
                System.out.println(date);
            }
            else
            {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
