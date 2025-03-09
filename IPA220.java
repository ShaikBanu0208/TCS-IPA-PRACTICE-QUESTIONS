import java.util.*;
class AutonomousCar{
    int carId;
    String brand;
    int noOfTestsConducted;
    int noOfTestsPassed;
    String environment;
    String grade;
    AutonomousCar(int a,String b,int c,int d,String e){
        this.carId=a;
        this.brand=b;
        this.noOfTestsConducted=c;
        this.noOfTestsPassed=d;
        this.environment=e;
    }
    int getcarId(){
        return carId;
    }
    String getbrand(){
        return brand;
    }
    int getnoOfTestsConducted(){
        return noOfTestsConducted;
    }
    int getnoOfTestsPassed(){
        return noOfTestsPassed;
    }
    String getenvironment(){
        return environment;
    }
    void setgrade(String a){
        this.grade=a;
    }
    String getgrade(){
        return grade;
    }
}
class IPA220{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        AutonomousCar[] arr=new AutonomousCar[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            String e=sc.nextLine();
            arr[i]=new AutonomousCar(a, b, c, d, e);
        }
        String envir=sc.nextLine();
        String brand=sc.nextLine();
        int ans1=findTestPassedByEnv(arr,envir);
        if(ans1!=0){
            System.out.println(ans1);
        }else{
            System.out.println("There are no tests passed in this particular environment");
        }
        AutonomousCar ans2=updateCarGrade(arr,brand);
        if(ans2!=null){
            System.out.println(ans2.getbrand()+"::"+ans2.getgrade());
        }else{
            System.out.println("No Car is available with the specified brand");
        }
    }
    public static int findTestPassedByEnv(AutonomousCar[] arr,String envir){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getenvironment().equalsIgnoreCase(envir)){
                sum+=arr[i].getnoOfTestsPassed();
            }
        }
        return sum;
    }
    public static AutonomousCar updateCarGrade(AutonomousCar[] arr,String brand){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getbrand().equalsIgnoreCase(brand)){
                int rating=(arr[i].getnoOfTestsPassed()*100)/arr[i].getnoOfTestsConducted();
                if(rating>=80){
                    arr[i].setgrade("A1");
                }else{
                    arr[i].setgrade("B2");
                }
                return arr[i];
            }
            
        }
        return null;
    }
}
/*
 * Create a class AutonomousCar with the below attributes:

carld – int
brand – String 
noOfTestsConducted – int
noOfTestsPassed- int
environment – String

Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence 
except grade.

Create class Solution with main method. Implement two static methods – findTestPassedByEnv and updateCarGrade in 
Solution class.

findTestPassedByEnv method:

This method will take two input parameters -array of AutonomousCar objects and string parameter environment. The method 
will return the sum of the noOfTestsPassed attribute from autonomousCar objects for the environment passed as parameter. 
If no autonomousCar with the given environment is present in the array of AutonomousCar objects, then the method should 
return 0.

updateCarGrade method:

This method will take a String parameter brand, along with the array of AutonomousCar objects. The method will return 
the autonomousCar object, if the input String parameter matches with the brand attribute of the autonomousCar object. 
Before returning the object, the grade should be derived based on the rating calculation mentioned below. This grade 
value should be assigned to the object. If any of the above conditions are not met, then the method should return null. 
The grade attribute should be calculated as follows: rating .(noOfTestsPassed * 100)/noOfTestsConducted 
If the rating > = 80 then grade should be ‘A1’, otherwise the grade should be ‘B2’.

The above mentioned static methods should be called from the main method. For findTestPassedByEnv method – The main 
method should print the totalTestPassed as it is, if the returned value is greater than 0, or it should print “There 
are no tests passed in this particular environment”.

For updateCarGrade method – The main method should print the brand and grade of the returned autonomousCar object. 
The brand and grade should be concatinated with :: while printing. eg:- Tesla::A1, where Tesla is the brand and Al 
is the grade.

If the returned value is null then it should print “No Car is available with the specified brand”. Before calling these 
static methods in main, use Scanner object to read the values of four autonomousCar objects referring attributes in the 
above mentioned attribute sequence (except grade attribute). Next, read the value for environment and brand.

Input
----------------
100
Tesla
1000
500
Hills
200
Ford
2000
1500
Desert
300
Royce
3000
1700
Hills
400
Mercedez
1000
400
Desert
Desert
Mercedez

Output
-----------
1900
Mercedez::B2
 */