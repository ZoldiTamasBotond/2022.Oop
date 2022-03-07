package oop.labor03.lab3_2;

import java.util.Random;
import oop.labor03.lab3_1.BankAccount;

public class Main {
    public static void main(String[] args){
        Random rand = new Random();
        Customer customer1 = new Customer("John", "BLACK");
        Customer customer2 = new Customer("Mary", "WHITE");
        int customer1Num=5;
        int numAccounts=0;
        String accountName="OTP";
        for (int i=0;i<customer1Num;i++)
        {
            numAccounts++;
            customer1.addAccount(new BankAccount(accountName+numAccounts));
        }
        int customer2Num=9;
        for (int i=0;i<customer2Num;i++) {
            numAccounts++;
            customer2.addAccount(new BankAccount(accountName + numAccounts));
        }
        System.out.println(customer1);
        System.out.println(customer2);
        for (int i=0;i<customer1Num;i++)
        {
            if (customer1.getAccount(accountName+(i+1))!=null)
            {
                customer1.getAccount(accountName+(i+1)).deposit(rand.nextInt(1000));
            }
        }
        for (int i=customer1Num;i<customer2Num+customer1Num;i++)
        {
            if (customer2.getAccount(accountName+(i+1))!=null)
            {
                customer2.getAccount(accountName+(i+1)).deposit(rand.nextInt(1000));
            }
        }

        System.out.println(customer1);
        System.out.println(customer2);
        customer1.closeAccount(accountName+1);
        customer2.closeAccount(accountName+(customer1Num+customer2Num));
        System.out.println(customer1);
        System.out.println(customer2);
    }
}
