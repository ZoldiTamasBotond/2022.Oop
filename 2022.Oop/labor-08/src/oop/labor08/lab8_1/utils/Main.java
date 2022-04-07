package oop.labor08.lab8_1.utils;

import oop.labor08.lab8_1.bank.Bank;
import oop.labor08.lab8_1.models.BankAccount;
import oop.labor08.lab8_1.customer.Customer;
import oop.labor08.lab8_1.models.CheckingAccount;
import oop.labor08.lab8_1.models.SavingsAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CheckingAccount account1=new CheckingAccount(1000);
        BankAccount account2 = new CheckingAccount(1000);
        BankAccount account3 = new SavingsAccount(0.02);
        System.out.println(account2);
        System.out.println(account3);




        ArrayList<Customer> customers=(readFromTXTFile("lab8_1_input.txt"));

        Bank bank= new Bank("OTP");
        for(Customer customer:customers) {
            bank.addCustomer(customer);
        }
        System.out.println( bank.getCustomer(1));
        bank.getCustomer(1).getBankAccount(bank.getCustomer(1).getNumAccounts()-1).deposit(100);
        System.out.println( bank.getCustomer(1));
        bank.printCustomersFile("bank_customers.csv");
    }

    public static ArrayList<Customer> readFromTXTFile(String fileName) {
        ArrayList<Customer> customers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }

                String[] items = line.split(",");
                switch (items[0]) {
                    case "Customer" -> {
                        String firstName = items[1].trim();
                        String lastName = items[2].trim();
                        customers.add(new Customer(firstName, lastName));
                    }
                    case "CheckingAccount" -> {
                        customers.get(customers.size() - 1).addAccount(new CheckingAccount(Double.parseDouble(items[1].trim())));
                        customers.get(customers.size()-1).getBankAccount(customers.get(customers.size()-1).getNumAccounts()-1).deposit(Integer.parseInt(items[2].trim()));
                    }
                    case "SavingsAccount" -> {
                        customers.get(customers.size() - 1).addAccount(new SavingsAccount(Double.parseDouble(items[1].trim())));
                        customers.get(customers.size()-1).getBankAccount(customers.get(customers.size()-1).getNumAccounts()-1).deposit(Integer.parseInt(items[2].trim()));
                    }
                    default -> {
                        System.out.println("Wrong input");
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
