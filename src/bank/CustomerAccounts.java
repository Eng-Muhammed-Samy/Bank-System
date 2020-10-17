package bank;

import java.util.ArrayList;

public class CustomerAccounts {
    // arraylist of accounts
    private ArrayList<AccountInformation> customers;
    private AccountInformation cutomer ; // add one account at a time
  // no argument constractor
    public CustomerAccounts() {
    }
    // with arguments constractors
    public CustomerAccounts(AccountInformation cutomer) {
        this.cutomer = cutomer;
    }

    public CustomerAccounts(ArrayList<AccountInformation> customers) {
        this.customers = customers;
    }

    public CustomerAccounts(ArrayList<AccountInformation> customers, AccountInformation cutomer) {
        this.customers = customers;
        this.cutomer = cutomer;
    }
    // setters and getters methods
    public ArrayList<AccountInformation> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<AccountInformation> customers) {
        this.customers = customers;
    }

    public AccountInformation getCutomer() {
        return cutomer;
    }

    public void setCutomer(AccountInformation cutomer) {
        this.cutomer = cutomer;
    }
    // tostring function
    @Override
    public String toString() {
        return "CustomerAccounts{" + "customers=" + customers + ", cutomer=" + cutomer + '}';
    }
    
}
