package oop.labor04.lab4_2;

import oop.labor04.lab4_2.BankAccount;

import java.util.ArrayList;

public class Customer {
    private final String firstName;
    private String lastName;
    // constant
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumAccounts(){return accounts.size();}


    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account: accounts)
        {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }
    public void closeAccount(String accountNumber){
        for (int i=0;i<accounts.size();i++)
        {
            if (this.accounts.get(i).getAccountNumber().equals(accountNumber)) {
                accounts.remove(i);
            }
        }
    }

    public String toString() {
            StringBuffer result = new StringBuffer();
            result.append(firstName + ' ' + lastName + " accounts:\n");
            for(BankAccount account: accounts){
                result.append( "\t" + account.toString() +"\n");
            }
            return result.toString();

        }
    }
