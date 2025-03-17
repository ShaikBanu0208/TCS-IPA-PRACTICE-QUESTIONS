import java.util.*;
class BankAccount{
    int accountNumber;
    String accountHolderName;
    double balance;
    BankAccount(int a,String b,double c){
        this.accountNumber=a;
        this.accountHolderName=b;
        this.balance=c;
    }
    int getaccountNumber(){
        return accountNumber;
    }
    String getaccountHolderName(){
        return accountHolderName;
    }
    double getbalance(){
        return balance;
    }
    void setbalance(double balance){
        this.balance=balance;
    }
}
public class IPA248 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BankAccount[] arr=new BankAccount[3];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            double c=sc.nextDouble();
            sc.nextLine();
            arr[i]=new BankAccount(a, b, c);
        }
        int accountNumber=sc.nextInt();
        sc.nextLine();
        double ans1=withdraw(arr, accountNumber);
        if(ans1>0){
            System.out.println(ans1);
        }else{
            System.out.println("Sorry - Insufficient balance");
        }
        double ans2=deposit(arr, accountNumber);
        if(ans2>0){
            System.out.println(ans2);
        }else{
            System.out.println("Sorry - Account not found");
        }
    }
    public static double withdraw(BankAccount[] arr,int accountNumber){
        Scanner sc=new Scanner(System.in);
        double balance=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getaccountNumber()==accountNumber){
                double withdraw=sc.nextDouble();
                sc.nextLine();
                if(arr[i].getbalance()>=withdraw){
                    balance=arr[i].getbalance()-withdraw;
                    arr[i].setbalance(balance);
                    return balance;
                }else{
                    return -1;
                }
            }
        }
        return -2;
    }
    public static double deposit(BankAccount[] arr,int accountNumber){
        Scanner sc=new Scanner(System.in);
        double balance=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getaccountNumber()==accountNumber){
                double deposit=sc.nextDouble();
                sc.nextLine();
                balance=arr[i].getbalance()+deposit;
                arr[i].setbalance(balance);
                return balance;
            }
        }
        return -1;
    }
}
/*
 * Create a class BankAccount with the following attributes:

accountNumber - int
accountHolderName - String
balance - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Solution with the main method.

Implement two static methods - withdraw and deposit in Solution class.

withdraw method:
------------------------------------------
This method will take two input parameters - array of BankAccount objects and the account number (int) from which withdrawal 
should be done.
The method will check if the account number is present in the array of BankAccount objects.
If present, the method will then check if the balance is sufficient to withdraw the requested amount (double). If yes, it will 
deduct the amount from the account balance and return the updated balance.
If the account number is not present or the balance is not sufficient, the method should return -1.

deposit method:
--------------------------------------------
This method will take two input parameters - array of BankAccount objects and the account number (int) in which deposit should 
be done.
The method will check if the account number is present in the array of BankAccount objects.
If present, it will add the deposit amount (double) to the account balance and return the updated balance.
If the account number is not present, the method should return -1.

These above mentioned static methods should be called from the main method.

For withdraw method - The main method should print the updated balance if the returned value is greater than or equal to 0, or 
it should print "Sorry - Insufficient balance" if the returned value is -1, or it should print "Sorry - Account not found" if 
the returned value is -2.

For deposit method - The main method should print the updated balance if the returned value is greater than or equal to 0, or 
it should print "Sorry - Account not found" if the returned value is -1.

Before calling these static methods in main, a parameterized constructor in the above mentioned attribute sequence as required.

Input
------------------------
1001
Alice
5000.0
1002
Bob
10000.0
1003
Charlie
15000.0
1002
5000.0
1001
10000.0

Output
---------------------------
5000.0
15000.0
 */