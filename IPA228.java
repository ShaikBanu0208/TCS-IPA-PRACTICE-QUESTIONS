import java.util.*;
class Fruits{
    int fruitId;
    String fruitName;
    int price;
    int rating;
    Fruits(int a,String b,int c,int d){
        this.fruitId=a;
        this.fruitName=b;
        this.price=c;
        this.rating=d;
    }
    int getfruitId(){
        return fruitId;
    }
    String getfruitName(){
        return fruitName;
    }
    int getprice(){
        return price;
    }
    int getrating(){
        return rating;
    }
}
class IPA228{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Fruits[] arr=new Fruits[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            arr[i]=new Fruits(a, b, c, d);
        }
        int rating=sc.nextInt();
        Fruits ans=findMaximumPriceByRating(arr, rating);
        if(ans!=null){
            System.out.println(ans.getfruitId());
        }else{
            System.out.println("No such Fruit");
        }
    }
    public static Fruits findMaximumPriceByRating(Fruits[] arr,int rating){
        int maxi=Integer.MIN_VALUE;
        Fruits ans=null;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getrating()>rating && arr[i].getprice()>maxi){
                maxi=arr[i].getprice();
                ans=arr[i];
            }
        }
        if(ans!=null){
            return ans;
        }else{
            return null;
        }
    }
}
/*
 * Create a class Fruits with below attributes as private
● int fruitId
● String fruitName
● int price
● int rating

Write getters, setters and parameterized constructor in the abovementioned attribute 
sequence as required.

Create class Solution with main method

Implement One static method-

● findMaximumPriceByRating

findMaximumPriceByRating in the solution class. 
This method will take array of Fruit objects, int paramater and returns the maximum priced fruit 
object from array of Fruit objects whichever has rating greater than the rating 
(rating parameter passed). This method should be called from main method.

Write code to perform following tasks:

1. Take necessary input variable and call findMaximumPriceByRating.

For this method- The main method should print the fruitId from returnedobject. As if the 
returned value is not null, or it should print "No such Fruit".

Note:- Before calling this static method, use Scanner object to read thevalues of four Fruits 
objects. No two Fruits will have same price. All thesearches should be case insensitive.
Consider below sample input and output to test your code.


Input
-------------------
555
Apple
200
5
777
Orange
150
4
333
Banana
100
4
888
Avocado
250
4
3

Output
-----------------
888
 */