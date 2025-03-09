import java.util.*;
class Motel{
    private int motelId;
    private String motelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String cabFacility;
    private double totalBill; 
    Motel(int a,String b,String c,int d,String e,double f){
        this.motelId=a;
        this.motelName=b;
        this.dateOfBooking=c;
        this.noOfRoomsBooked=d;
        this.cabFacility=e;
        this.totalBill=f;
    }
    int getmotelId(){
        return motelId;
    }
    String getmotelName(){
        return motelName;
    }
    String getdateOfBooking(){
        return dateOfBooking;
    }
    int getnoOfRoomsBooked(){
        return noOfRoomsBooked;
    }
    String getcabFacility(){
        return cabFacility;
    }
    double gettotalBill(){
        return totalBill;
    }
}
class IPA211{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Motel[] arr=new Motel[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            String e=sc.nextLine();
            double f=sc.nextDouble();
            arr[i]=new Motel(a,b,c,d,e,f);
        }
        sc.nextLine();
        String cab=sc.nextLine();
        int ans=totalNoOfRoomsBooked(arr,cab);
        if(ans!=0){
            System.out.println(ans);
        }else{
            System.out.println("No such rooms booked");
        }
    }
    public static int totalNoOfRoomsBooked(Motel[] arr,String cab){
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getcabFacility().equalsIgnoreCase(cab) && arr[i].getnoOfRoomsBooked()>5){
                cnt=cnt+arr[i].getnoOfRoomsBooked();
            }
        }
        if(cnt>0){
            return cnt;
        }else{
            return 0;
        }
    }
}
/*
 * Create a class Motel with the below attributes:

motelId - int
motelName - String
dateOfBooking – String (in the format dd-mon-yyyy)
noOfRoomsBooked – int
cabFacility – String
totalBill- double

Restricted for circulation outside TCS Xplore 6
The above attributes should be private, write getters, setters and parameterized constructor as 
required.
Create class Solution with main method.
Implement one static method – totalNoOfRoomsBooked in Solution class.
totalNoOfRoomsBooked method:
This method will take two input parameter - array of Motel objects and a String parameter.
The method will return the total numbers of rooms booked from array of Motel objects if the cab facility 
attribute matches with the given String parameter(cab facility) and the number of rooms booked is 
greater than 5.
If no rooms are booked with the above criteria in the array of Motel objects, then the method should 
return 0.
Note :
No two Motel object would have the same motelId.
dateOfBooking is stored in the format dd-mon-yyyy(eg. 01-Jan-2022)
The above mentioned static method should be called from the main method.
For totalNoOfRoomsBooked method - The main method should print the total number of booked rooms 
as it is, if the returned value is greater than 0, else it
should print "No such rooms booked"
Before calling these static methods in main, use Scanner object to read the values of four Motel objects 
referring attributes in the above mentioned attribute sequence.
Next, read the value of one String parameter for capturing the cab facility

Input
___________
1001
M&M
01-Dec-2022
5
Yes
30000
1002
BestStay
10-Jan-2022
3
Yes
27000
1003
Novatel
11-Jun-2022
5
Yes
25000
1004
Chola
01-Sep-2022
7
Yes
72000
Yes
___________
OutPut
___________
7
 */