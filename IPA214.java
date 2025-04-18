import java.util.*;
class Hotel{
   private int hotelId;
   private String hotelName;
   private String dateOfBooking;
   private int noOfRoomsBooked;
   private String wifiFacility;
   private double totalBill;
   Hotel(int a,String b,String c,int d,String e,double f){
      this.hotelId=a;
      this.hotelName=b;
      this.dateOfBooking=c;
      this.noOfRoomsBooked=d;
      this.wifiFacility=e;
      this.totalBill=f;
   }
   int gethotelId(){
      return hotelId;
   }
   String gethotelName(){
      return hotelName;
   }
   String getdateOfBooking(){
      return dateOfBooking;
   }
   int getnoOfRoomsBooked(){
      return noOfRoomsBooked;
   }
   String getwifiFacility(){
      return wifiFacility;
   }
   double gettotalBill(){
      return totalBill;
   }
}
class IPA214{
   public static void main(String args[]){
      Scanner sc=new Scanner(System.in);
      Hotel arr[]=new Hotel[4];
      for(int i=0;i<arr.length;i++){
         int a=sc.nextInt();
         sc.nextLine();
         String b=sc.nextLine();
         String c=sc.nextLine();
         int d=sc.nextInt();
         sc.nextLine();
         String e=sc.nextLine();
         double f=sc.nextDouble();
         arr[i]=new Hotel(a,b,c,d,e,f);
      }
      sc.nextLine();
      String month=sc.nextLine();
      String wifi=sc.nextLine();
      int ans1=noOfRoomsBookedInGivenMonth(arr, month);
      if(ans1>0){
         System.out.println(ans1);
      }else{
         System.out.println("No rooms booked in the given month");
      }
      Hotel ans2=searchHotelByWifiOption(arr, wifi);
      if(ans2!=null){
         System.out.println(ans2.gethotelId());
      }else{
         System.out.println("No such option available");
      }
   }
   public static int noOfRoomsBookedInGivenMonth(Hotel[] arr,String month){
      int count=0;
      for(int i=0;i<arr.length;i++){
         if(arr[i].getdateOfBooking().contains(month)){
            count+=arr[i].getnoOfRoomsBooked();
         }
      }
      if(count>0){
         return count;
      }else{
         return 0;
      }
   }
   public static Hotel searchHotelByWifiOption(Hotel[] arr,String wifi){
      Hotel[] ans=new Hotel[arr.length];
      int count=0;
      for(int i=0;i<arr.length;i++){
         if(arr[i].getwifiFacility().equalsIgnoreCase(wifi)){
            ans[count++]=arr[i];
         }
      }
      ans=Arrays.copyOf(ans,count);
      int[] id=new int[ans.length];
      for(int i=0;i<ans.length;i++){
         id[i]=ans[i].gethotelId();
      }
      Arrays.sort(id);
      for(int i=0;i<ans.length;i++){
         if(ans[i].gethotelId()==id[ans.length-2]){
            return ans[i];
         }
      }
      return null;
   }

}
/*
 * Create a class Hotel with the below attributes:
 
hotelId - int
hotelName - String
dateOfBooking – String (in the format dd-mon-yyyy)
noOfRoomsBooked – int
wifiFacility – String
totalBill- double



The above attributes should be private, write getters, setters and parameterized constructor as required.
 
Create class Solution with main method.
 
Implement two static methods – noOfRoomsBookedInGivenMonth and searchHotelByWifiOption in Solution class.
 
noOfRoomsBookedInGivenMonth method:
This method will take two input parameter - array of Hotel objects and a String parameter.
The method will return the total numbers of rooms booked from array of Hotel objects for the given month(String parameter passed).
If no rooms are booked for the given month in the array of Hotel objects, then the method should return 0.



searchHotelByWifiOption method:
This method will take two input parameter - array of Hotel objects and a String parameter
The method will return Hotel object with second highest totalbill, from the array of Hotel objects where wifiFacility attribute 
matches with the given wifi facility(String parameter passed).
If no Hotel with the given wifi option is present in the array of Hotel objects, then the method should return null.
 
Note : 
No two Hotel object would have the same hotelId.
No two Hotel object would have the same totalbill.
The Array either has at least two objects with specified wifi option OR  no object with specified wifi option. 
All the searches should be case insensitive. 
dateOfBooking is stored in the format dd-mon-yyyy(eg. 01-Jan-2022)
 
The above mentioned static methods should be called from the main method. 
 
For noOfRoomsBookedInGivenMonth method - The main method should print the total number of booked rooms as it is, 
if the returned value is greater than 0, else it should print "No rooms booked in the given month"
 
For searchHotelByWifiOption method - The main method should print the hotelId from the returned Hotel object if the returned value is not null. 
If the returned value is null then it should print "No such option available".
 
Before calling these static methods in main, use Scanner object to read the values of four Hotel objects referring attributes in the above mentioned attribute sequence. 
Next, read the value of two String parameters for capturing the month and wifi option .



Consider below sample input and output:


Input1:
101
Best Stay
01-jan-2022
10
Yes
20000
102
Apple Stay
12-Feb-2022
3
Yes
4000
103
Accord
11-May-2022
5
Yes
15000
104
Royal Park
22-Dec-2021
7
Yes
12000
May
Yes
 
Output1:
5
103



Input2:
101
Best Stay
01-jan-2022
10
Yes
20000
102
Apple Stay
12-Feb-2022
3
Yes
4000
103
Accord
11-May-2022
5
Yes
15000
104
Royal Park
22-Dec-2021
7
Yes
12000
May1
Yes1



Output2:
No rooms booked in the given month
No such option available

--------------------------------------------------
Sample code snippet for reference: 
Please use below code to build your Solution.
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
    
 //code the first method 
  
    
 //code the second method    

}
    
//code the class

-------------------------------------------------
Note on using Scanner object:
Sometimes scanner does not read the new line character while invoking methods like nextInt(), nextDouble() etc. 
Usually, this is not an issue, but this may be visible while calling nextLine() immediately after those methods.

Consider below input values:
1001
Savings

Referring below code:

Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
String str = sc.nextLine(); -&gt; here we expect str to have value Savings.Instead it may be "".

If above issue is observed, then it is suggested to add one more explicit call to nextLine() after reading numeric value.
 */