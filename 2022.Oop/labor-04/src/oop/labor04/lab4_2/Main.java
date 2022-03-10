package oop.labor04.lab4_2;

import oop.labor04.lab4_1.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    public static ArrayList<Customer> readFromTXTFile(String fileName) {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<BankAccount> accounts = new ArrayList<>();
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
                        customers.get(customers.size() - 1).addAccount(new BankAccount(items[1].trim()));
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
