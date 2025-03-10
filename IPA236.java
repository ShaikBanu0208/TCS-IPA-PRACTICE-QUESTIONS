/*
 * Find total interest of an amount.

Create a class Account with following attributes :
id - int
balance - double
interestRate - double

Take another integer as number of year. 
After that calculate total interest using formula:

Percentage = interestRate * 100 / time
Total Interest = Percentage + interestRate
 */

import java.util.Scanner;
class Account{
    int id;
    double balance;
    double interestRate;
    Account(int a,double b,double c){
        this.id=a;
        this.balance=b;
        this.interestRate=c;
    }
    int getid(){
        return id;
    }
    double getbalance(){
        return balance;
    }
    double getinterestRate(){
        return interestRate;
    }
}
public class IPA236 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        sc.nextLine();
        double b=sc.nextDouble();
        sc.nextLine();
        double c=sc.nextDouble();
        sc.nextLine();
        Account account=new Account(a,b,c);
        int n=sc.nextInt();
        sc.nextLine();
        double interest=calculateInterest(account,n);
        System.out.printf("%.3f",interest);    
    }
    public static double calculateInterest(Account account,int n){
        double per=(account.getinterestRate()/100)*n;
        per=account.getinterestRate()+per;
        return per;
    }
}
