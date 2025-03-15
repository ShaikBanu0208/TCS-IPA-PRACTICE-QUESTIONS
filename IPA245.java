import java.util.*;
class HeadSets{
    private String headsetName;
    private String brand;
    private int price;
    private boolean available;
    HeadSets(String a,String b,int c,boolean d){
        this.headsetName=a;
        this.brand=b;
        this.price=c;
        this.available=d;
    }
    String getheadsetName(){
        return headsetName;
    }
    String getbrand(){
        return brand;
    }
    int getprice(){
        return price;
    }
    boolean getavailable(){
        return available;
    }
}
class IPA245{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HeadSets[] arr=new HeadSets[4];
        for(int i=0;i<arr.length;i++){
            String a=sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            boolean d=sc.nextBoolean();
            sc.nextLine();
            arr[i]=new HeadSets(a,b,c,d);
        }
        String brand=sc.nextLine();
        int ans1=findTotalPriceForGivenBrand(arr, brand);
        if(ans1>0){
            System.out.println(ans1);
        }else{
            System.out.println("No Headsets available with the given brand");
        }
        HeadSets ans2=findAvailableHeadsetWithSecondMinPrice(arr);
        if(ans2!=null){
            System.out.println(ans2.getheadsetName());
            System.out.println(ans2.getprice());
        }else{
            System.out.println("No HeadSets Available");
        }
    }
    public static int findTotalPriceForGivenBrand(HeadSets[] arr,String brand){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getbrand().equalsIgnoreCase(brand)){
                sum=sum+arr[i].getprice();
            }
        }
        return sum;
    }
    public static HeadSets findAvailableHeadsetWithSecondMinPrice(HeadSets[] arr){
        int mini=Integer.MAX_VALUE;
        int secmini=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getprice()<mini){
                secmini=mini;
                mini=arr[i].getprice();
            }else if(arr[i].getprice()>mini && arr[i].getprice()<secmini){
                secmini=arr[i].getprice();
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i].getprice()==secmini){
                return arr[i];
            }
        }
        
        return null;
    }
}
/*
 * Create a class HeadSets with below attributes:

headsetName - String
brand-String 
price - int
available- boolean

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - findTotalPriceForGivenBrand and findAvailableHeadsetWithSecondMinPrice in Solution class.

findTotalPriceForGivenBrand method:
--------------------------------------
The method will return the total price of Headsets from array of Headset objects for the given brand(String parameter passed).
If no Headsets with the given brand is present in the array of Headsets objects, then the method should return 0.

findAvailableHeadsetWithSecondMinPrice method:
-----------------------------------------------
This method will take array of Headset objects as an input parameter and returns the available Headset object with the 
second lowest/minimum price from the given array of objects. 

If no Headsets with the above condition is present in the array of Headsets objects, then the method should return null.

Note : 
No two Headsets will have the same price.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For findTotalPriceForGivenBrand method - The main method should print the returned total price as it is if the returned 
value is greater than 0 or it should print "No Headsets available with the given brand".
Eg: 4500
where 4500 is the total Headsets price

For findAvailableHeadsetWithSecondMinPrice method - The main method should print the headsetsName and price from the 
returned Headsets object if the returned value is not null.
If the returned value is null then it should print "No Headsets available".

Eg:Logitech Wired
1500
where Logitech Wired is the headsetName and 1500 is the price

Before calling these static methods in main, use Scanner object to read the values of four Headset objects referring 
attributes in the above mentioned attribute sequence.
Next, read the value of String parameter for capturing brand.

Consider below sample input and output:

Input1:
----------------
boAt BassHeads
boAt
1220
true
Over Ear Wired
boAt
549
true
In Ear with Mic
JBL
450
true
Buds 2 Neo
RealMe
500
true
boAt

Output:
---------------
1769
Buds 2 Neo
500


Input2:
--------------------
boAt BassHeads
boAt
1220
false
Over Ear Wired
boAt
1549
false
In Ear with Mic
JBL
450
false
Buds 2 Neo
RealMe
500
false
boAt
Output:
--------------
2769
No Headsets available
--------------------------------------------------
Sample code snippet for reference:
Please use below code to build your solution.
--------------------------------------------------
import java.util.Scanner;
public class MyClass
{
public static void main(String[] args)
{
//code to read values
//code to call required method
//code to display the result
}
*/