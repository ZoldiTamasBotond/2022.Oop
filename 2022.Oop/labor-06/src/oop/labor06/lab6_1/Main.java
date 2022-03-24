package oop.labor06.lab6_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /* ArrayList<BankAccount> bankAccounts=new ArrayList<>();
        for (int i=0;i<200;i++){
            bankAccounts.add(new BankAccount());
        }
        for (BankAccount bankAccount:bankAccounts){
            System.out.println(bankAccount);
        }

        */
        System.out.println(readFromTXTFile("lab6_1_input.txt"));
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
                    case "Account" -> {
                        customers.get(customers.size() - 1).addAccount(new BankAccount());
                        customers.get(customers.size()-1).getBankAccount(customers.get(customers.size()-1).getNumAccounts()-1).deposit(Integer.parseInt(items[1].trim()));
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
