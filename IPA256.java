import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
class BankAccount{
    String accountNumber;
    String accountHolderName;
    double balance;
    BankAccount(String a,String b,double c){
        this.accountNumber=a;
        this.accountHolderName=b;
        this.balance=c;
    }
    String getaccountNumber(){
        return accountNumber;
    }
    String getaccountHolderName(){
        return accountHolderName;
    }
    double getbalance(){
        return balance;
    }
}
class BankUtils{
    BankAccount fromAccount;
    BankAccount toAccount;
    double amount;
    String transactionCode;
    BankUtils(BankAccount fromAccount,BankAccount toAccount,double amount,String transactionCode){
        this.fromAccount=fromAccount;
        this.toAccount=toAccount;
        this.amount=amount;
        this.transactionCode=transactionCode;
    }
    double getamount(){
        return amount;
    }
    String gettransactionCode(){
        return transactionCode;
    }
}
class Transaction{
    String transactionCode;
    double tamount;
    String timestamp;
    Transaction(String a,double b,String c){
        this.transactionCode=a;
        this.tamount=b;
        this.timestamp=c;
    }
    String gettransactionCode(){
        return transactionCode;
    }
    double gettamount(){
        return tamount;
    }
    String gettimestamp(){
        return timestamp;
    }
}
class IPA256{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BankAccount[] arr=new BankAccount[2];
        for(int i=0;i<arr.length;i++){
            System.out.println("Account "+(i+1)+":");
            System.out.println("Account Number: ");
            String a=sc.nextLine();
            System.out.println("Account Holder Name:");
            String b=sc.nextLine();
            System.out.println("Balance:");
            double c=sc.nextDouble();
            sc.nextLine();
            arr[i]=new BankAccount(a, b, c);
            System.out.println();
        }
        System.out.println("Transfer Details:");
        System.out.println("Amount: ");
        double amount=sc.nextDouble();
        sc.nextLine();
        System.out.println("Transaction Code:");
        String tran=sc.nextLine();
        sc.nextLine();
        BankUtils bu=new BankUtils(arr[0],arr[1],amount,tran);
        System.out.println("Before Transfer:");
        for(int i=0;i<arr.length;i++){
            System.out.println("Account "+(i+1)+arr[i].getaccountHolderName()+"-"+arr[i].getaccountNumber()+"-"+arr[i].getbalance());
        }
        double[] ans=transferFunds(bu);
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fTimestamp=sdf.format(timestamp);
        Transaction t=new Transaction(tran, amount, fTimestamp);
        System.out.println();
        if(ans!=null){
            System.out.println("After transfer");
            for(int i=0;i<ans.length;i++){
                System.out.println("Account "+(i+1)+arr[i].getaccountHolderName()+"-"+arr[i].getaccountNumber()+"-"+ans[i]);
            }
            System.out.println();
            System.out.println("Transaction Details");
            System.out.println("Transaction Code: "+t.gettransactionCode());
            System.out.println("Amount Transferred: "+t.gettamount());
            System.out.println("Timestamp: "+t.gettimestamp());
        }else{
            System.out.println("Insufficient Balance in Account 1");
            System.out.println("Transaction Code: "+t.gettransactionCode());
            System.out.println("Timestamp: "+t.gettimestamp());
        }

    }
    public static double[] transferFunds(BankUtils b){
        if(b.fromAccount.getbalance()>b.getamount()){
            double amount1=b.fromAccount.getbalance()-b.getamount();
            double amount2=b.toAccount.getbalance()+b.getamount();
            double[] amount={amount1,amount2};
            return amount;
        }
        return null;
    }
}
/*
 * 
Create a class called BankAccount with the following attributes:

accountNumber (String)
accountHolderName (String)
balance (double)
Write getters, setters, and a parameterized constructor for the class.

Create a static method transferFunds in a separate class called BankUtils. The method should take four parameters:

fromAccount (BankAccount)
toAccount (BankAccount)
amount (double)
transactionCode (String)
The method should transfer the specified amount from the fromAccount to the toAccount,
and return a Transaction object containing the transactionCode, the amount 
transferred, and the timestamp of the transaction. If the fromAccount has insufficient
balance, the method should throw an InsufficientBalanceException with an appropriate error message.

Create a class called Transaction with the following attributes:

transactionCode (String)
amount (double)
timestamp (String)
Write getters and a parameterized constructor for the class.

Create an InsufficientBalanceException class that extends the Exception class. 
The exception should have a constructor that takes a message as a parameter.

In the main method, create two BankAccount objects, transfer some funds between 
them using the transferFunds method, and print the transaction details to the console. Handle any exceptions.

Sample Input:

Account 1:
Account Number: 12345
Account Holder Name: John
Balance: 5000.0

Account 2:
Account Number: 67890
Account Holder Name: Jane
Balance: 10000.0

Transfer Details:
Amount: 2000.0
Transaction Code: T0001

Sample Output:

Before Transfer:
Account 1: John - 12345 - 5000.0
Account 2: Jane - 67890 - 10000.0

After Transfer:
Account 1: John - 12345 - 3000.0
Account 2: Jane - 67890 - 12000.0

Transaction Details:
Transaction Code: T0001
Amount Transferred: 2000.0
Timestamp: 2023-04-01 10:30:00

 */