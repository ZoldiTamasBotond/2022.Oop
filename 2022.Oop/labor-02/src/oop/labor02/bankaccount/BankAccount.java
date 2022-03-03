package oop.labor02.bankaccount;

public class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount( String accountNumber){
        this.accountNumber=accountNumber;
        this.balance =0;
    }

    public double getBalance(){
        return balance;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }

    public void deposit( double  amount){
        balance += amount;
    }

    public boolean withdraw( double amount ){
        if( amount <= balance ){
            balance-= amount;
            return true;
        }
        return false;
    }
}
