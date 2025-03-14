import java.util.*;
class Car{
    int carId;
    String carName;
    String fuelType;
    Car(int a,String b,String c){
        this.carId=a;
        this.carName=b;
        this.fuelType=c;
    }
    int getcarId(){
        return carId;
    }
    String getcarName(){
        return carName;
    }
    String getfuelType(){
        return fuelType;
    }
}
class IPA242{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Car[] arr=new Car[5];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            arr[i]=new Car(a,b,c);
        }
        int id=sc.nextInt();
        sc.nextLine();
        Car[] ans=RemoveAndRearrange(arr, id);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i].getcarId()+":"+ans[i].getcarName());
            }
        }else{
            System.out.println("There are no car with given id");
        }
    }
    public static Car[] RemoveAndRearrange(Car[] arr,int id){
        Car[] ans=new Car[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getcarId()!=id){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        if(ans.length>0){
            return ans;
        }
        return null;
    }
}
/*
 * Create a class Car with the below attributes:

carId – int
carName – String
fuelType – String

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class RemoveCar with main method.

Implement two static methods – RemoveAndRearrange in RemoveCar class.

RemoveAndRearrange method: 
This method will take int input parameter. The method will return the new array of Car object and remove that car whose 
id is match with the input parameter. Remove the car details and return the array with continuous new ids.

If no car with the given id is present in the array of Car objects, then the method should return null.

Note: No two Car object would have the same engine id.

The above mentioned static methods should be called from the main method.

For RemoveAndRearrange method: The main method should print the id and car name as it is, if the returned 
value is not null, or it should print “There are no car with given id”. 

Before calling these static methods in main, use Scanner object to read the values of five objects referring attributes 
in the above mentioned attribute sequence. next, read the value of int parameters for capturing car id.

Input :

1001
Maruti
Diesel
1002
Kia
Pertro
1003
Hyundai
Diesel
1004
Taxi
Petrol
1005
Truck
Diesel
1003

Output :

1001 : Maruti
1002 : Kia
1003 : Hyundai
1004 : Taxi
 */