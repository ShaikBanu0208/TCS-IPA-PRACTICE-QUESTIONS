import java.util.*;
class Resort{
    int resortId;
    String resortName;
    String Category;
    double resortPrice;
    double resortRating;
    Resort(int a,String b,String c,double d,double e){
        this.resortId=a;
        this.resortName=b;
        this.Category=c;
        this.resortPrice=d;
        this.resortRating=e;
    }
    int getresortId(){
        return resortId;
    }
    String getresortName(){
        return resortName;
    }
    String getCategory(){
        return Category;
    }
    double getresortPrice(){
        return resortPrice;
    }
    double getresortRating(){
        return resortRating;
    }
}
class IPA261{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Resort[] arr=new Resort[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            double d=sc.nextDouble();sc.nextLine();
            double e=sc.nextDouble();sc.nextLine();
            arr[i]=new Resort(a,b,c,d,e);
        }
        String category=sc.nextLine();
        int ans1=findAvgPrice(arr,category);
        if(ans1!=0){
            System.out.println("The average price of"+category+":"+ans1);
        }else{
            System.out.println("No Such Resort Found");
        }
    }
    public static int findAvgPrice(Resort[] arr,String category){
        int sum=0,cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getCategory().equalsIgnoreCase(category) && arr[i].getresortRating()>4){
                sum+=arr[i].getresortPrice();
                cnt++;
            }
        }
        if(cnt!=0){
            return sum/cnt;
        }
        return 0;
    }
}
/*
 * Create a class Resort with the below attributes:

resortId - int
resortName - String
Category - String 
resortPrice - double
resortRating - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with the main method.

Implement two static methods - findAvgPrice in Solution class.

findAvgPrice method:
----------------------------------
This method will take two input parameters - array of Resort objects and a string parameter.
The method will return the average of the prices from resort objects whose Category matched with passed as parameter and rating
will greater than 4.
If no resort present found, then the method should return 0.

Note : All the searches should be case insensitive.

These above mentioned static methods should be called from the main method.

For findAvgPrice method - The main method should print the average price as it is if the returned value is 
greater than 0, or it should print "No such Resort found".

Before calling these static methods in main, use Scanner object to read the values of four resort objects referring attributes 
in the above mentioned attribute sequence. Next, read the value for category.

Input
----------
1004
ABC
3 star
5400.00
4.5
1001
DEF
5 star
4781.45
4.0
1002
GHI
3 star
6235.72
4.2
1008
JKL
2 star
7454.00
4.2
3 star

Output
----------
The average price of 3 star:5817
 */