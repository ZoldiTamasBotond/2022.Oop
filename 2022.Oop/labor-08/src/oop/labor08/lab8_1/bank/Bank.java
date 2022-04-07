package oop.labor08.lab8_1.bank;

import oop.labor08.lab8_1.customer.Customer;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Bank {
    private String  name;
    private ArrayList<Customer> customers=new ArrayList<>();



    public Bank(String name) {
        this.name = name;
    }

    public Customer getCustomer(int customerId) {
        for (Customer customer:customers){
            if(customer.getId()==customerId){
                return customer;
            }
        }
        return null;
    }
    public void  addCustomer(Customer customer){
        customers.add(customer);
    }
    public int numCustomer(){
        return customers.size();
    }

    private void printCustomers( PrintStream ps ){
        ps.println("ID, Firstname, Last name, Number of bank accounts");
        for( Customer customer: customers ){
            ps.println( customer.getId()+", " + customer.getFirstName() +", "+
                    customer.getLastName()+", "+customer.getNumAccounts());
        }
        ps.close();
    }

    public void printCustomersToStdout(){
        printCustomers( System.out );
    }
    public void printCustomersFile(String fileName){
        try(PrintStream printStream = new PrintStream(fileName)){
            printCustomers(printStream);
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
