/* all operation */
package bank;

import java.io.File;
import java.util.ArrayList;


public class OPerations {
    // deposit and withdraw attribute
   private int deposir; 
   private int withdraw;
// no argument constractor
    public OPerations() {
    }
// with arguments constractors
    public OPerations(int deposir, int withdraw) {
        this.deposir = deposir;
        this.withdraw = withdraw;
    }
  // setters and getters methods
    public int getDeposir() {
        return deposir;
    }

    public void setDeposir(int deposir) {
        this.deposir = deposir;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }
     // search for accounts by id
    public static AccountInformation srearchAccount(int id, ArrayList<AccountInformation> customers){

        for (AccountInformation customer : customers) {
            int y = customer.getId();
            if(id == y){
                return customer;
             }          
         }
        return null;
    }
    // used to delete customer
    public static void deleteObject(int id, ArrayList<AccountInformation> customers){
        for (AccountInformation customer : customers) {
            int y = customer.getId();
            if(id == y){
                customers.remove(customer);
                return;
            }
        }
    }
    
       // this function used to reload accounts from file
    	public static CustomerAccounts loadCustomers(String savefile) {

		ObjectMapper mapper = new ObjectMapper();// crate mapper object
		CustomerAccounts customers = null;

		try {
                    //load the data from file
			customers = mapper.readValue(new File(savefile), CustomerAccounts.class);
		} catch (Exception e) {
                    e.printStackTrace();
                }

		return customers ;
    }
        // this function used to add accounts to file
        public static void AddCustomers(CustomerAccounts customers, String savefile) {

            // using mapper to save a data in file
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(savefile), customers);
	}
}
