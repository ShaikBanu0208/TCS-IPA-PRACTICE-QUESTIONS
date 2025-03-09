import java.util.*;
class TravelAgencies{
    int regNo;
    String agencyName;
    String pakageType;
    int price;
    boolean flightFacility;

    TravelAgencies(int regNo,String agencyName,String pakageType,int price,boolean flightFacility){
        this.regNo=regNo;
        this.agencyName=agencyName;
        this.pakageType=pakageType;
        this.price=price;
        this.flightFacility=flightFacility;
    }
    //Getter Methods
    int getRegNo(){
        return regNo;
    }
    String getAgencyName(){
        return agencyName;
    }
    String getPakageType(){
        return pakageType;
    }
    int getPrice(){
        return price;
    }
    boolean getflightFacility(){
        return flightFacility; 
    }
}
class IPA22{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        TravelAgencies[] arr=new TravelAgencies[4];
        for(int i=0;i<arr.length;i++){
            int regNo=sc.nextInt(); sc.nextLine();
            String agencyName=sc.nextLine();
            String pakageType=sc.nextLine();
            int price=sc.nextInt(); sc.nextLine();
            boolean flightFacility=sc.nextBoolean();
            arr[i]=new TravelAgencies(regNo, agencyName, pakageType, price, flightFacility);
        }
        int regNo=sc.nextInt(); sc.nextLine();
        String pakageType=sc.nextLine();
        int maxi=findAgencyWithHighestPackagePrice(arr);
        System.out.println(maxi);
        TravelAgencies result= agencyDetailsforGivenIdAndType(arr,regNo,pakageType);
        if(result != null) {
            System.out.println(result.getAgencyName() + ":" + result.getPrice());
        } else {
            System.out.println("No matching agency found with the given registration number and package type.");
        }

    }
    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] arr){
        int maxi=arr[0].getPrice();
        for(int i=1;i<arr.length;i++){
            maxi=Math.max(maxi,arr[i].getPrice());
        }
        return maxi;
    }
    public static TravelAgencies agencyDetailsforGivenIdAndType(TravelAgencies[] arr,int RegNo,String pakageType){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getflightFacility()==true){
                if(arr[i].getRegNo()==RegNo && arr[i].getPakageType().equals(pakageType)){
                    return arr[i];
                }
            }
        }
        return null;
    }
}


/*Question: 1
Create a class TravelAgencies with below attributes:

regNo – int
agencyName – String
pakageType – String
price – int
flightFacility – boolean

Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence.

Create class Solution with main method. Implement two static methods – findAgencyWithHighestPackagePrice and 
agencyDetailsforGivenIdAndType in Solution class.

findAgencyWithHighestPackagePrice method:

This method will take array of TravelAgencies objects as an input parameter and return the highest package 
price from the given array of objects.

agencyDetailsForGivenldAndType method:

This method will take three input parameters -array of TravelAgencies objects, int parameter regNo and String
parameter packageType. The method will return the TravelAgencies object based on below conditions.

FlightFacility should be available.
The input parameters(regNo and packageType) should matched with the regNo and packageType of TravelAgencies object.
If any of the above conditions are not met, then the method should return null. Note : Same Travel agency can 
have more than one package type. Travel agency and package type combination is unique. All the searches should 
be case insensitive.

The above mentioned static methods should be called from the main method.


For findAgencyWithHighestPackagePrice method – The main method should print the highestPackagePrice as it is. 
For agencyDetailsForGivenldAndType method -The main method should print the AgencyName and price of the returned 
object.The AgencyName and price should be concatinated with : while printing.
---------
Input
---------
123
A2Z Agency
Platinum
50000
true
345
SSS Agency
Gold
30000
false
987
Cox and Kings
Diamond
40000
true
888
Global Tours
Silver
20000
false
987
Diamond
-------------------------------
Output
-------------------------------
50000
Cox and Kings:40000
*/