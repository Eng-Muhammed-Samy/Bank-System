package bank;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Bank extends Application {
     static Stage s; // public stage 
     // define all text inputs
     static TextField name = new TextField();
     static TextField date = new TextField();
     static TextField address = new TextField();
     static TextField phone_number = new TextField();
     static TextField amount = new TextField();
     static TextField account_id = new TextField();
     static TextField ubdate_address = new TextField();
     static TextField ubdate_ph_num = new TextField();
     // define the list type of accounts
     static ChoiceBox type1;
     // used to determine type of transaction
     static RadioButton deposit;
     static RadioButton withdraw;
     //show if delete account
     static Label remove;
     // path of saving file
     static String save = "customer.json";
     //list of Information accounts
     static ArrayList<AccountInformation> Customers = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) {
        s = primaryStage; // set stage
        primaryStage.setTitle("Customer Account Bank Management System");//set name for stage
        primaryStage.setScene(welcom()); //set scene
        primaryStage.show(); // start stage
    }

    public static void main(String[] args) {
        Customers = OPerations.loadCustomers(save).getCustomers();//load list of customer
        System.out.println(Customers); // print the list
        System.out.println("size of list : " + Customers.size());//print size of list
        launch(args);//start program
    }
    // create welcom screen 
    public static Scene welcom(){
        // add container
        GridPane root = new GridPane();
        // add two buttons and label and set some properties fot them
        Label lbl = new Label("BANK MANAGEMENT SYSTEM\nto add account please enter Enroll!");
        lbl.setFont(new Font("Arial", 18));
        lbl.setPadding(new Insets(20));
        Button creat = new Button("Enroll");
        creat.setFont(new Font("Tahoma", 18));
        creat.setPadding(new Insets(20));
        creat.setMinSize(130, 50);
        creat.setShape(new Circle(50));
        Button exit = new Button("Exit");
        exit.setFont(new Font("Tahoma", 18));
        exit.setPadding(new Insets(20));
        exit.setMinSize(130, 50);
        exit.setShape(new Circle(50));
        // add all elemnts to container and set some properties to it
        root.add(lbl, 0, 0, 2, 1);
        root.add(creat, 0, 1);
        root.add(exit, 1, 1);
        root.setHgap(20);
        root.setVgap(20);
        root.setAlignment(Pos.CENTER);
        root.setMargin(exit, new Insets(10, 40, 10, 20));
        root.setMargin(creat, new Insets(10, 20, 10, 40));
        root.setMargin(lbl, new Insets(10, 40, 10, 40));
        // this button used to enroll to main screen
        creat.setOnAction((event) -> {
            s.setScene(mainScene());
        });
        // used to wxit from program
        exit.setOnAction((event) -> {
            System.exit(0);
        }); 
        return new Scene(root,380, 220); 
    }
    // create main screen
    public static Scene mainScene(){
        // add primary continer
        BorderPane mainScene = new BorderPane();
        /* add two secondarys pane and add 5 buttons and label
         and set some properties for them*/
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        VBox box2 = new VBox();
        box2.setAlignment(Pos.CENTER);
        // add secondary containers to primary container
        mainScene.setTop(box2);
        mainScene.setBottom(box);
        Label lbl = new Label("CHOOSE OPRERATION");
        lbl.setFont(new Font("Arial", 20));
        lbl.setPadding(new Insets(20));
        box2.getChildren().addAll(lbl);
        Button add = new Button("Create Acount");
        add.setFont(new Font("Arial", 20));
        add.setPadding(new Insets(20));
        // used to enroll to add account screen
        add.setOnAction((event) -> {
            s.setScene(addAcount());
        });
        Button ubdate = new Button("Ubdate");
        ubdate.setFont(new Font("Arial", 20));
        ubdate.setPadding(new Insets(20));
        // used to enroll to ubdate account screen
        ubdate.setOnAction((event) -> {
            s.setScene(ubdateAcount());
        });
        Button trans = new Button("Transaction");
        trans.setFont(new Font("Arial", 20));
        trans.setPadding(new Insets(20));
        // used to enroll to transaction screen
        trans.setOnAction((event) -> {
            s.setScene(transactionAcount());
        });
        Button check = new Button("Check");
        check.setFont(new Font("Arial", 20));
        check.setPadding(new Insets(20));
        //used to enroll in search account screen
        check.setOnAction((event) -> {
            s.setScene(checkAcount());
        });
        Button remove = new Button("Remove");
        remove.setFont(new Font("Arial", 20));
        remove.setPadding(new Insets(20));
        // used to enrolled in remove account screen
        remove.setOnAction((event) -> {
            s.setScene(removeAcount());
        });
        Button return1 = new Button("Return");
        return1.setFont(new Font("Arial", 20));
        return1.setPadding(new Insets(20));
        // used to return to welcom screen
        return1.setOnAction((event) -> {
            s.setScene(welcom());
        });
        // add all element to container
        box.getChildren().addAll(add, ubdate, trans, check, remove, return1);
        return new Scene(mainScene);
    }
    // create account screen
    public static Scene addAcount(){
        //main continer
        GridPane addScene = new GridPane();
        // set some properties to input text
        name.setFont(new Font("Arial", 20));
        name.setPadding(new Insets(10));
        date.setFont(new Font("Arial", 20));
        date.setPadding(new Insets(10));
        address.setFont(new Font("Arial", 20));
        address.setPadding(new Insets(10));
        phone_number.setFont(new Font("Arial", 20));
        phone_number.setPadding(new Insets(10));
        amount.setFont(new Font("Arial", 20));
        amount.setPadding(new Insets(10));
        //add labels and set properties for them
        Label name1 = new Label("Name");
        name1.setFont(new Font("Arial", 20));
        name1.setPadding(new Insets(10));
        Label date1 = new Label("Date");
        date1.setFont(new Font("Arial", 20));
        date1.setPadding(new Insets(10));
        Label address1 = new Label("Address");
        address1.setFont(new Font("Arial", 20));
        address1.setPadding(new Insets(10));
        Label phonenumber = new Label("Phone Number");
        phonenumber.setFont(new Font("Arial", 20));
        phonenumber.setPadding(new Insets(10));
        Label amount1 = new Label("Transaction Amount");
        amount1.setFont(new Font("Arial", 20));
        amount1.setPadding(new Insets(10));
        Label type = new Label("Type of Account");
        type.setFont(new Font("arial", 20));
        type.setPadding(new Insets(10));
        //type of accunt array
        String types [] = {"Saved", "Current", "Fixed 1 year", "Fixed 2 year", "Fixed 3 year"};
        //set list to choice boox and set properties
        type1 = new ChoiceBox(FXCollections.observableArrayList(types));
        type1.setPadding(new Insets(10));
        // used to return to maine screen
        Button return1 = new Button("Return");
        return1.setFont(new Font("Arial", 20));
        return1.setPadding(new Insets(10));
        return1.setOnAction((event) -> {
            s.setScene(mainScene());
        });
        // create account class and create button to handel this operation
        CreateAccount cr = new CreateAccount();
        Button create = new Button("Create Account");
        create.setFont(new Font("Arial", 20));
        create.setPadding(new Insets(10));
        create.setOnAction(cr);// add action to button
        //add element to container and set some properties to it
        addScene.add(name1 ,0 ,0);
        addScene.add(name, 1, 0);
        addScene.add(date1, 0, 1);
        addScene.add(date, 1, 1);
        addScene.add(address1,0 , 2);
        addScene.add(address,1 , 2);
        addScene.add(phonenumber, 0, 3);
        addScene.add(phone_number, 1, 3);
        addScene.add(amount1, 0, 4);
        addScene.add(amount, 1, 4);
        addScene.add(type, 0, 5);
        addScene.add(type1, 1, 5);
        addScene.add(create,0 , 6);
        addScene.add(return1, 1, 6);
        addScene.setHgap(10);
        addScene.setVgap(10);
        addScene.setAlignment(Pos.CENTER);
        return new Scene(addScene, 500, 500);
    }
    // create ubdate screen
    public static Scene ubdateAcount(){
        // create main continer
        GridPane ubdateAcount = new GridPane();
        // set some properties to input field
        account_id.setFont(new Font("Arial", 20));
        account_id.setPadding(new Insets(10));
        ubdate_address.setFont(new Font("Arial", 20));
        ubdate_address.setPadding(new Insets(10));
        ubdate_ph_num.setFont(new Font("Arial", 20));
        ubdate_ph_num.setPadding(new Insets(10));
        // add many of label and set some properties
        Label id = new Label("Account ID");
        id.setFont(new Font("Arial", 20));
        id.setPadding(new Insets(10));
        Label addre = new Label("Enter address");
        addre.setFont(new Font("Arial", 20));
        addre.setPadding(new Insets(10));
        Label ph = new Label("Enter phone Number");
        ph.setFont(new Font("Arial", 20));
        ph.setPadding(new Insets(10));
        // add ubdata button and handle button ubdate event
        Button ubd = new Button("Create ubdate");
        ubd.setMinSize(150, 50);
        ubd.setFont(new Font("Arial", 20));
        ubd.setPadding(new Insets(10));
        createUbdate change = new createUbdate();
        ubd.setOnAction(change);
        //used to return to main scene
        Button return2 = new Button("Return");
        return2.setFont(new Font("Arial", 20));
        return2.setPadding(new Insets(10));
        return2.setMinSize(150, 50);
        return2.setOnAction((event) -> {
            s.setScene(mainScene());
        });
        // add all elements to container and set some properties to it
        ubdateAcount.add(id, 0, 0);
        ubdateAcount.add(account_id, 1, 0);
        ubdateAcount.add(addre, 0, 1);
        ubdateAcount.add(ubdate_address, 1, 1);
        ubdateAcount.add(ph, 0, 2);
        ubdateAcount.add(ubdate_ph_num, 1, 2);
        ubdateAcount.add(ubd, 0, 3);
        ubdateAcount.add(return2, 1, 3);
        ubdateAcount.setHgap(20);
        ubdateAcount.setVgap(15);
        ubdateAcount.setAlignment(Pos.CENTER);
        return new Scene(ubdateAcount, 650, 300);
    }
    // create Transaction screen
    public static Scene transactionAcount(){
        // add main container
        GridPane transactionAcount = new GridPane();
        // add labels and texts and set some properties to it
        Label id = new Label("Enter ID");
        id.setFont(new Font("Arial", 20));
        id.setPadding(new Insets(10));
        account_id.setFont(new Font("Arial", 20));
        account_id.setPadding(new Insets(10));
        Label amountadded = new Label("Enter New Amount");
        amountadded.setFont(new Font("Arial", 20));
        amountadded.setPadding(new Insets(10));
        amount.setFont(new Font("Arial", 20));
        amount.setPadding(new Insets(10));
        // initialize radio buttons and set some properties and added to toggle group
        deposit = new RadioButton("Deposit");
        deposit.setFont(new Font("Arial", 20));
        deposit.setPadding(new Insets(10));
        withdraw = new RadioButton("Withdraw");
        withdraw.setFont(new Font("Arial", 20));
        withdraw.setPadding(new Insets(10));
        ToggleGroup group = new ToggleGroup();
        deposit.setToggleGroup(group);
        withdraw.setToggleGroup(group);
        // handle transaction action and add clc button , set some properties to it
        TransactionOperation trans = new TransactionOperation();
        Button claculate = new Button("Calculate");
        claculate.setFont(new Font("Arial", 20));
        claculate.setPadding(new Insets(10));
        claculate.setOnAction(trans);
        // return to main screen
        Button return1 = new Button("Return");
        return1.setFont(new Font("Arial", 20));
        return1.setPadding(new Insets(10));
        return1.setOnAction((event) -> {
            s.setScene(mainScene());
        });
        // add all elements to container and set some properties to it
        transactionAcount.add(id, 0, 0);
        transactionAcount.add(account_id, 1, 0);
        transactionAcount.add(amountadded, 0, 1);
        transactionAcount.add(amount, 1, 1);
        transactionAcount.add(deposit, 0, 2);
        transactionAcount.add(withdraw, 1, 2);
        transactionAcount.add(claculate, 0, 3);
        transactionAcount.add(return1, 1, 3);
        transactionAcount.setHgap(15);
        transactionAcount.setVgap(15);
        transactionAcount.setAlignment(Pos.CENTER);
        return new Scene(transactionAcount, 500, 250);
    }
    // create search screen
    public static Scene checkAcount(){
        // add main container
        GridPane checkAcount = new GridPane();
        // add some of label and set properties for them
        Label id = new Label("Search by Id");
        id.setFont(new Font("Arial", 20));
        id.setPadding(new Insets(10));
        account_id.setFont(new Font("Arial", 20));
        account_id.setPadding(new Insets(10));
        Label name1 = new Label("");
        name1.setFont(new Font("Arial", 20));
        name1.setPadding(new Insets(10));
        Label date1 = new Label("");
        date1.setFont(new Font("Arial", 20));
        date1.setPadding(new Insets(10));
        Label address1 = new Label("");
        address1.setFont(new Font("Arial", 20));
        address1.setPadding(new Insets(10));
        Label phonenumber = new Label("");
        phonenumber.setFont(new Font("Arial", 20));
        phonenumber.setPadding(new Insets(10));
        Label amount1 = new Label("");
        amount1.setFont(new Font("Arial", 20));
        amount1.setPadding(new Insets(10));
        Label type = new Label("");
        type.setFont(new Font("arial", 20));
        type.setPadding(new Insets(10));
        // handle search action 
        Button check = new Button("Check");
        check.setFont(new Font(20));
        check.setPadding(new Insets(10));
        check.setOnAction((event) -> {
            int id1 = Integer.parseInt(account_id.getText());// recived id from user
            AccountInformation account = new AccountInformation();
            // make search operation by id about customer 
            account = OPerations.srearchAccount(id1, Customers);  
            // show all information about customer 
            name1.setText(account.getName());
            date1.setText(account.getDate());
            address1.setText(account.getAddress());
            amount1.setText(String.valueOf(account.getTransactionAmount()));
            phonenumber.setText(account.getPhoneNumber());
            type.setText(account.getTypeAccount());
        });
        // add return button to return in main screen
        Button return1 = new Button("Return");
        return1.setFont(new Font("Arial", 20));
        return1.setPadding(new Insets(10));
        return1.setOnAction((event) -> {
            s.setScene(mainScene());
        });
        // add all elements to container
        checkAcount.add(id, 0, 0);
        checkAcount.add(account_id, 1, 0);
        checkAcount.add(name1, 0, 1);
        checkAcount.add(date1, 1, 1);
        checkAcount.add(address1, 0, 2);
        checkAcount.add(phonenumber, 1, 2);
        checkAcount.add(amount1, 0, 3);
        checkAcount.add(type, 1, 3);
        checkAcount.add(check ,0 ,4);
        checkAcount.add(return1 ,1 ,4);
        checkAcount.setVgap(15);
        checkAcount.setHgap(15);
        checkAcount.setAlignment(Pos.CENTER);
        return new Scene(checkAcount, 500, 300);
    }
    // create remove account screen
    public static Scene removeAcount(){
        // add container 
        GridPane removeAcount = new GridPane();
        // add label and set properties to it
        Label idREmoved = new Label("Enter ID");
        idREmoved.setFont(new Font("Arial", 20));
        idREmoved.setPadding(new Insets(10));
        // add some properties to input exts
        account_id.setFont(new Font("Arial", 20));
        account_id.setPadding(new Insets(10));
        remove = new Label();
        remove.setFont(new Font("Arial", 20));
        remove.setPadding(new Insets(10));
        // handle delete event 
        Remove delete = new Remove();
        Button rem = new Button("Remove");
        rem.setFont(new Font("Arial", 20));
        rem.setPadding(new Insets(10));
        rem.setOnAction(delete);
        // return to main screen
        Button return1 = new Button("Return");
        return1.setFont(new Font("Arial", 20));
        return1.setPadding(new Insets(10));
        return1.setOnAction((event) -> {
            s.setScene(mainScene());
        });
        // add all elements to container
        removeAcount.add(idREmoved, 0, 0);
        removeAcount.add(account_id, 1, 0);
        removeAcount.add(rem, 0, 2);
        removeAcount.add(return1, 1, 2);
        removeAcount.add(remove, 0, 1, 2, 1);
        removeAcount.setHgap(10);
        removeAcount.setVgap(10);
        removeAcount.setAlignment(Pos.CENTER);
        return new Scene(removeAcount, 400, 200);
    }
    // create account action
    static class CreateAccount implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           AccountInformation account = new AccountInformation();// account object
           account.setId(Customers.size() + 1);// generate id
           // recived all information data from customer and save it to account object
           account.setName(name.getText());
           account.setDate(date.getText());
           account.setAddress(address.getText());
           account.setPhoneNumber(phone_number.getText());
           account.setTransactionAmount(Integer.parseInt(amount.getText()));
           account.setTypeAccount(type1.getSelectionModel().getSelectedItem().toString());
           // add account to customer list
           Customers.add(account);
           // save to file 
           CustomerAccounts customer = new CustomerAccounts(Customers);
           OPerations.AddCustomers(customer, save);
        }
        
    }
    //create ubdate action
    static class createUbdate implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            int id = Integer.parseInt(account_id.getText()); // recived id to search by it
            AccountInformation account = new AccountInformation();
            // search by id to make ubdate
            account = OPerations.srearchAccount(id, Customers);
            // make ubdate and save new data to account
            account.setAddress(ubdate_address.getText());
            account.setPhoneNumber(ubdate_ph_num.getText());
            // save to file
            CustomerAccounts customer = new CustomerAccounts(Customers);
            OPerations.AddCustomers(customer, save);
        }
        
    }
    // create transaction action
    static class TransactionOperation implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           AccountInformation account = new AccountInformation(); // 
           int id = Integer.parseInt(account_id.getText()); // recived id to search by it
           int value = Integer.parseInt(amount.getText()); // add amount from user
           // search by id to make operatin ( deposit, withdraw )
           account = OPerations.srearchAccount(id, Customers);
            // select type ( deposit, withdraw )
           if(deposit.isSelected())
               //if deposit
               account.setTransactionAmount(account.getTransactionAmount()+ value);
           if(withdraw.isSelected()) 
               // if withdraw
              account.setTransactionAmount(account.getTransactionAmount()- value);
           // save to file
           CustomerAccounts customer = new CustomerAccounts(Customers);
           OPerations.AddCustomers(customer, save);
        }
        
    }
    //create remove action
    static class Remove implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           int id = Integer.parseInt(account_id.getText());// recived id to delete by it
           // delete function
           OPerations.deleteObject(id, Customers);
           // save to file
           CustomerAccounts customer = new CustomerAccounts(Customers);
           OPerations.AddCustomers(customer, save);
           // show event to label
           remove.setText("The Acccount removed");
        }
        
    }
}
