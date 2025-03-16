import java.util.*;
class Car{
    String make;
    String model;
    int year;
    double price;
    Car(String a,String b,int c,double d){
        this.make=a;
        this.model=b;
        this.year=c;
        this.price=d;
    }
    String getmake(){
        return make;
    }
    String getmodel(){
        return model;
    }
    int getyear(){
        return year;
    }
    double getprice(){
        return price;
    }
}
class IPA247{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Car[] arr=new Car[4];
        for(int i=0;i<arr.length;i++){
            String a=sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            arr[i]=new Car(a,b,c,d);
        }
        String make=sc.nextLine();
        String model=sc.nextLine();
        Car ans1=findMostExpensiveCar(arr);
        if(ans1!=null){
            System.out.println(ans1.getmake());
            System.out.println(ans1.getmodel());
            System.out.println(ans1.getyear());
            System.out.println(ans1.getprice());
        }else{
            System.out.println("Sorry - No car is available");
        }
        Car ans2=getCarByMakeAndModel(arr, make, model);
        if(ans2!=null){
            System.out.println(ans2.getyear());
            System.out.println(ans2.getprice());
        }else{
            System.out.println("Sorry - No car is available");
        }

    }
    public static Car findMostExpensiveCar(Car[] arr){
        if(arr.length==0){
            return null;
        }
        Car ans=null;
        double maxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getprice()>maxi){
                maxi=arr[i].getprice();
                ans=arr[i];
            }
        }
        return ans;
    }
    public static Car getCarByMakeAndModel(Car[] car,String make,String model){
        for(int i=0;i<car.length;i++){
            if(car[i].getmake().equalsIgnoreCase(make) && car[i].getmodel().equalsIgnoreCase(model)){
                return car[i];
            }
        }
        return null;
    }
}
/*Create a class Car with the following attributes:

make - String
model - String
year - int
price - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Solution with the main method.

Implement two static methods - findMostExpensiveCar and getCarByMakeAndModel in Solution class.

findMostExpensiveCar method:
This method will take an array of Car objects as input.
The method will return the Car object with the highest price.
If the array is empty, the method should return null.

getCarByMakeAndModel method:
This method will take three input parameters - array of Car objects, make and model (both strings).
The method will return the Car object that matches the make and model attributes passed as parameters.
If no car with the given make and model is present in the array of car objects, then the method should return null.

Note: The search should be case insensitive.

These above mentioned static methods should be called from the main method.

For findMostExpensiveCar method - The main method should print the make, model, year and price of the returned Car object. 
If the returned value is null then it should print "Sorry - No car is available".

For getCarByMakeAndModel method - The main method should print the year and price of the returned Car object. If the returned 
value is null then it should print "Sorry - No car is available".

Before calling these static methods in main, use Scanner object to read the values of four Car objects referring attributes in 
the above mentioned attribute sequence. Next, read the values for make and model.

Input:
-----------------
Mercedes
S-Class
2020
1250000
BMW
5-Series
2019
900000
Audi
A4
2022
800000
Jaguar
F-PACE
2021
1100000
Audi
A4

Output:
---------------------
Mercedes
S-Class
1250000.0
2020
2022
800000.0
*/
