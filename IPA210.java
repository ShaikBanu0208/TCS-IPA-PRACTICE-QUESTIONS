import java.util.*;
class College{
   int id;
   String name;
   int contactNo;
   String address;
   int pincode;
   College(int a,String b,int c,String d,int e){
      this.id=a;
      this.name=b;
      this.contactNo=c;
      this.address=d;
      this.pincode=e;
   }
   int getid(){
      return id;
   }
   String getName(){
      return name;
   }
   int getcontactNo(){
      return contactNo;
   }
   String getaddress(){
      return address;
   }
   int getpincode(){
      return pincode;
   }
}
class IPA210{
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      College[] arr=new College[n];
      for(int i=0;i<arr.length;i++){
         int a=sc.nextInt();
         sc.nextLine();
         String b=sc.nextLine();
         int c=sc.nextInt();
         sc.nextLine();
         String d=sc.nextLine();
         int e=sc.nextInt();
         arr[i]=new College(a,b,c,d,e);
      }
      sc.nextLine();
      String address=sc.nextLine();
      College pin=findCollegeWithMaximumPincode(arr);
      if(pin!=null){
         System.out.println("ID : "+pin.getid());
         System.out.println("Name : "+pin.getName());
         System.out.println("Contact No : "+pin.getcontactNo());
         System.out.println("Address : "+pin.getaddress());
         System.out.println("Pin : "+pin.getpincode());
      }else{
         System.out.println("No college found with mentioned attribute");
      }
      College addr=searchCollegeByAddress(arr, address);
      if(addr!=null){
         System.out.println("ID : "+pin.getid());
         System.out.println("Name : "+pin.getName());
         System.out.println("Contact No : "+pin.getcontactNo());
 
        System.out.println("Address : "+pin.getaddress());
         System.out.println("Pin : "+pin.getpincode());
      }else{
         System.out.println("No college found with mentioned attribute");
      }
   }
   public static College findCollegeWithMaximumPincode(College[] arr){
      int max=0;
      for(int i=0;i<arr.length;i++){
         if(arr[i].getpincode()>max){
            max=arr[i].getpincode();
         }
      }
      for(int i=0;i<arr.length;i++){
         if(arr[i].getpincode()==max){
            return arr[i];
         }
      }
      return null;
   }
   public static College searchCollegeByAddress(College[] arr,String address){
      for(int i=0;i<arr.length;i++){
         if(arr[i].getaddress().equalsIgnoreCase(address)){
            return arr[i];
         }
      }
      return null;
   }
}
/*
 * Create a class College with the below attributes.

 id-int 

 name -String 

 contactNo-int

 address-String 

 pinCode-int



Write the getters and setters and parametrized constructor in the above 

mentioned sequence as required.



Create the class Solution with the main method.

Implement the two static methods:

 1.findCollegeWithMaximumPincode 

 2.searchCollegeByAddress



findCollegeWithMaximumPincode method:

   Create the Static method in the Solution Class.

 This method will take array of the College objects and return the 

College object having maximum pincode if found else return null if not 

found.

   for this method ,main method will print College object with maximum

pincode if the returned value is not null.if the returned value is null ,


then the main method will print "No college found with mentioned attribute".





searchCollegeByAddress method:

   Create the Static method in the Solution Class.

This method will take array of College objects as input and address as 

input and return College object having the mentioned address if found 

else return null if not found.

   for this method main method will print College object details as it is ,

 if the returned value is not null.if the returned value is null then ,


main method will print "No college found with mentioned attribute".


 

***************************************************************************

input 1:

109 
ACT
2500256
mumbai
695001
107
MCE
2500254
malapuram
612354
113
CTE
2500252
chennai
623145
102
SCT
2500255
AP
523641
AP



OUTPUT1:

id-109

name-ACT

contactNo-2500256

address-mumbai

pincode-695001

id-102

name-SCT

contactNo-2500255

address-AP

pincode-523641







INPUT2:

4
111
MJT
2500251
Calicut
401235
105
MET
2500256
kochi
668745
115
IIT
2500262
banglore
569874
110
ACT
2500263
delhi
687945
delhi


output2:

id-110

name-ACT

contactNo-2500263

address-delhi

pincode-687945

id-110

name-ACT

contactNo-2500263

address-delhi

pincode-687945
 */