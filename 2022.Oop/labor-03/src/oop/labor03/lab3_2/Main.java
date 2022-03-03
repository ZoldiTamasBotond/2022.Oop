package oop.labor03.lab3_2;

import java.util.Random;
import oop.labor03.lab3_1.BankAccount;

public class Main {
    public static void main(String[] args){
        Random rand = new Random();
        Customer customer1 = new Customer("John", "BLACK");
        Customer customer2 = new Customer("Mary", "WHITE");
        customer1.addAccount(new BankAccount("OTP00001"));
        customer1.addAccount(new BankAccount("OTP00002"));
        customer1.addAccount(new BankAccount("OTP00003"));
        customer1.addAccount(new BankAccount("OTP00004"));
        customer1.addAccount(new BankAccount("OTP00005"));
        customer2.addAccount(new BankAccount("OTP00011"));
        customer2.addAccount(new BankAccount("OTP00012"));
        customer2.addAccount(new BankAccount("OTP00013"));
        customer2.addAccount(new BankAccount("OTP00014"));
        customer2.addAccount(new BankAccount("OTP00015"));
        customer2.addAccount(new BankAccount("OTP00016"));
        customer2.addAccount(new BankAccount("OTP00017"));
        customer2.addAccount(new BankAccount("OTP00018"));
        customer2.addAccount(new BankAccount("OTP00019"));
        System.out.println(customer1);
        System.out.println(customer2);
       /* customer1.getAccount("OTP00001").deposit(rand.nextInt(1000));
        customer1.getAccount("OTP00002").deposit(rand.nextInt(1000));
        customer1.getAccount("OTP00003").deposit(rand.nextInt(1000));
        customer1.getAccount("OTP00004").deposit(rand.nextInt(1000));
        customer1.getAccount("OTP00005").deposit(rand.nextInt(1000));
        customer2.getAccount("OTP00011").deposit(rand.nextInt(1000));
        customer2.getAccount("OTP00012").deposit(rand.nextInt(1000));
        customer2.getAccount("OTP00013").deposit(rand.nextInt(1000));
        customer2.getAccount("OTP00014").deposit(rand.nextInt(1000));
        customer2.getAccount("OTP00015").deposit(rand.nextInt(1000));
        customer2.getAccount("OTP00016").deposit(rand.nextInt(1000));
        customer2.getAccount("OTP00017").deposit(rand.nextInt(1000));
        customer2.getAccount("OTP00018").deposit(rand.nextInt(1000));
        customer2.getAccount("OTP00019").deposit(rand.nextInt(1000));

        */
        System.out.println(customer1);
        System.out.println(customer2);
        customer1.closeAccount("OTP00001");
        customer2.closeAccount("OTP00019");
        System.out.println(customer1);
        System.out.println(customer2);
    }
}
