package oop.labor06.lab6_1;

public class BankAccount {
        private double balance;
        private static int numAccounts=0;
        private final String accountNumber;
        public static final String PREFIX = "OTP";
        public static final int ACCOUNT_NUMBER_LENGTH = 10;

    public BankAccount() {
        ++numAccounts;
        this.accountNumber = createAccountNumber();
    }

    private static String createAccountNumber(){
        int numOfZeros= ACCOUNT_NUMBER_LENGTH-String.valueOf(numAccounts).length()-PREFIX.length();
        return PREFIX+"0".repeat(numOfZeros)+numAccounts;
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

    public String toString(){
        return "\nAccount number: "+this.accountNumber+"\nBalance: "+this.balance+"EUR";
    }
    }
