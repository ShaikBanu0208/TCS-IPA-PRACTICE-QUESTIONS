import java.util.*;
class Bill{
    private int billNo;
    private String name;
    private String typeOfConnection;
    private double billAmount;
    private boolean status;
    Bill(int a,String b,String c,double d,boolean e){
        this.billNo=a;
        this.name=b;
        this.typeOfConnection=c;
        this.billAmount=d;
        this.status=e;
    }
    int getbillNo(){
        return billNo;
    }
    String getname(){
        return name;
    }
    String gettypeOfConnection(){
        return typeOfConnection;
    }
    double getbillAmount(){
        return billAmount;
    }
    boolean getstatus(){
        return status;
    }
}
public class IPA255 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Bill[] arr=new Bill[n];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            boolean e=sc.nextBoolean();
            arr[i]=new Bill(a, b, c, d, e);
        }
        boolean status=sc.nextBoolean();
        sc.nextLine();
        String connection=sc.nextLine();
        Bill[] ans1=findBillWithMaxBillAmountBasedOnStatus(arr, status);
        int ans2=getCountWithTypeOfConnection(arr, connection);
        if(ans1!=null){
            for(int i=0;i<ans1.length;i++){
                System.out.println(ans1[i].getbillNo()+"#"+ans1[i].getname());
            }
        }else{
            System.out.println("There are no bill with the given status");
        }
        if(ans2>0){
            System.out.println(ans2);
        }else{
            System.out.println("There are no bills with given type of connection");
        }
    }
    public static Bill[] findBillWithMaxBillAmountBasedOnStatus(Bill[] arr,boolean pay){
        double maxi=arr[0].getbillAmount();
        for(int i=1;i<arr.length;i++){
            if(arr[i].getbillAmount()>maxi){
                maxi=arr[i].getbillAmount();
            }
        }
        Bill[] ans=new Bill[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getstatus()==pay && arr[i].getbillAmount()==maxi){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        if(arr.length>0){
            for(int i=0;i<ans.length-1;i++){
                for(int j=0;j<ans.length;j++){
                    if(ans[i].getbillNo()>ans[j].getbillNo()){
                        Bill temp=ans[i];
                        ans[i]=ans[j];
                        ans[j]=temp;
                    }
                }
            }
        }
        if(ans.length>0){
            return ans;
        }
        return null;
    }
    public static int getCountWithTypeOfConnection(Bill[] arr,String connection){
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].gettypeOfConnection().equalsIgnoreCase(connection)){
                cnt++;
            }
        }
        return cnt;
    }
}
/*
 * 
Create a class Bill with below attributes:

billNo- int
name - String
typeOfConnection - String
billAmount - double
status – boolean

where billNo is the bill number, name is the name of the customer, typeOfConnection is the type of the connection 
(prepaid, postpaid), billAmount is the bill amount and status is whether the bill is paid or not (if paid then value is TRUE 
else value is FALSE). 

The above attributes should be private, write getters, setters and parameterized constructor as required. 

Create class Solution with main method.
Implement two static methods - findBillWithMaxBillAmountBasedOnStatus and getCountWithTypeOfConnection in Solution class.

findBillWithMaxBillAmountBasedOnStatus method:
-----------------------------------------------------
This method will take an array of Bill objects and a boolean parameter as parameters. 
The method will return bill object array in ascending order of their bill number from the array of Bill objects whose bill 
amount is maximum in the array with the status attribute that matches with the input parameter.

If no Bill with the given status is present in the array of Bill objects, then the method should return null.

getCountWithTypeOfConnection method:
-----------------------------------------------------
This method will take two input parameters - array of Bill objects and string parameter ( for type of connection).
The method will return the count of bills from array of bill objects for the given type of connection.
If no bill with the given type of connection is present in the array of bill objects, then the method should return 0.


Note :

Two bill object can have the same bill amount.
All the searches should be case insensitive. 

The above mentioned static methods should be called from the main method.

For findBillWithMaxBillAmountBasedOnStatus method - The main method should print the billNo followed by # and name from the 
returned Bill object array if the returned value is not null.

If the returned value is null then it should print "There are no bill with the given status".

For getCountWithTypeOfConnection method - The main method should print the count of bills as it is, if the returned value is 
greater than 0,  otherwise it should print "There are no bills with given type of connection".

Before calling these static methods in main, use Scanner to read the number of object and objects to read the values of Bill 
objects referring attributes in the above mentioned attribute sequence. 

Next, read the value for status and typeOfConnection.


Consider below sample input and output:
Input:

4
111
Aman Mittal
Prepaid
914.25
true
222
Rekha Kumar
Prepaid
1425.75
false
333
Samyra Gupta
Prepaid
1305.00
true
444
Mohit Saxena
Postpaid
1300.50
false
false
Prepaid

Output:

222#Rekha Kumar
3
*************************************************************************************
--------------------------------------------------
Sample code snippet for reference:
Please use below code to build your solution.
--------------------------------------------------

import java.util.Scanner;
public class Solution
{
public static void main(String[] args)
{
//code to read values

//code to call required method

//code to display the result

}

public static Bill[] findBillWithMaxBillAmountBasedOnStatus( /* required parameters to be added  ) {
//method logic
}
// public static int getCountWithTypeOfConnection( /* required parameters to be added */ 
// //method logic
// }
// */
// }
// class Bill
// {
// //code to build the class
// }

// -------------------------------------------------
// Note on using Scanner object:
// Sometimes scanner does not read the new line character while invoking methods like nextInt(), nextDouble() etc. 
// Usually, this is not an issue, but this may be visible while calling nextLine() immediately after those methods.


// Consider below input values:

// 1234
// Merin Bakers

// Referring below code:

// Scanner sc = new Scanner(System.in);
// int x = sc.nextInt();
// String str = sc.nextLine(); -> here we expect str to have value Bakers name. Instead it may be "".

// If above issue is observed, then it is suggested to add one more explicit call to nextLine() after reading numeric value.

// */