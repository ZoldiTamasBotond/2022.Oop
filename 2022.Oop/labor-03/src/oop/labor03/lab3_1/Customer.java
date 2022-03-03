package oop.labor03.lab3_1;

public class Customer {

    private String firstName;
    private String lastName;
    private BankAccount account;
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

    public BankAccount getAccount() {
        return account;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
    public void closeAccount(){
        this.account=null;
    }
    public String toString(){
        if(this.account!=null)
        {
            return "\nFirstname: "+firstName+"\nLastname: "+lastName+account.toString();
        }
        else {
            return "\nFirstname: "+firstName+"\nLastname: "+lastName+"\nAccount not available";
        }
    }
}
