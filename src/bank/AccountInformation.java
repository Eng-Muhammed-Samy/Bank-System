
package bank;

public class AccountInformation {
    // all information about any customer
    private int id;
    private String name;
    private String date;
    private String address;
    private String phoneNumber;
    private int transactionAmount;
    private String typeAccount;
    // no argument constructor
    public AccountInformation() {
    }
    // constructor with argument
    public AccountInformation(int id, String name, String date, String address, String ph_nymber, int transactionAmount, String typeAccount) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = address;
        this.phoneNumber = ph_nymber;
        this.transactionAmount = transactionAmount;
        this.typeAccount = typeAccount;
    }
    // setters and getters methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    // class information --> tostring function
    @Override
    public String toString() {
        return "AccountInformation{" + "id=" + id + ", name=" + name + ", date=" + date + ", address=" + address + ", ph_nymber=" + phoneNumber + ", transactionAmount=" + transactionAmount + ", typeAccount=" + typeAccount + '}';
    }
    
}
