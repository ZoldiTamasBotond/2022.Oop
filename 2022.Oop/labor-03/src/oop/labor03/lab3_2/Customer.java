package oop.labor03.lab3_2;

import oop.labor03.lab3_1.BankAccount;

public class Customer {
    private final String firstName;
    private String lastName;
    // constant
    public static final int MAX_ACCOUNTS = 10;
    // number of accounts
    private int numAccounts;
    // an array for the accounts
    private BankAccount accounts[] = new BankAccount[ MAX_ACCOUNTS ];

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

    public int getNumAccounts() {
        return numAccounts;
    }

    public BankAccount getAccount(String accountNumber) {
        for (int i=0;i<numAccounts;i++)
        {
            if (this.accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addAccount(BankAccount account) {
        if(numAccounts<MAX_ACCOUNTS) {
            this.accounts[numAccounts] = account;
            numAccounts++;
        }
    }
    public void closeAccount(String accountNumber){
        for (int i=0;i<numAccounts;i++)
        {
            if (this.accounts[i].getAccountNumber().equals(accountNumber)) {
                numAccounts--;
                accounts[i]=accounts[numAccounts];

            }
        }
    }

    public String toString() {
            StringBuffer result = new StringBuffer();
            result.append(firstName + ' ' + lastName + " accounts:\n");
            for(int i=0; i<numAccounts; ++i){
                result.append( "\t" + accounts[i].toString() +"\n");
            }
            return result.toString();

        }
    }
