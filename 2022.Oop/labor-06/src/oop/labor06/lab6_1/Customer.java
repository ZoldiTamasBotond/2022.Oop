package oop.labor06.lab6_1;

import java.util.ArrayList;

public class Customer {
    private final int id;
    private final String firstName;
    private String lastName;
    private static int numCustomers=0;
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName){
        this.id=++numCustomers;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public int getId() {
        return id;
    }

    public BankAccount getBankAccount(int numOfAcccount){
        if (numOfAcccount<getNumAccounts()){
            return accounts.get(numOfAcccount);
        }
        else return null;
    }

    public ArrayList<String> getAccountNumbers() {
        ArrayList<String> accountNumbers =new ArrayList<>();
        for (BankAccount account:accounts){
            accountNumbers.add(account.getAccountNumber());
        }
        return accountNumbers;
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
            result.append(id + " " + firstName + ' ' + lastName + " accounts:\n");
            for(BankAccount account: accounts){
                result.append( "\t" + account.toString() +"\n");
            }
            return result.toString();

        }
    }
