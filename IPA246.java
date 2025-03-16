import java.util.*;
class Vegetable{
    private int VegetableId;
    private String VegetableName;
    private int price;
    private int Rating;
    Vegetable(int a,String b,int c,int d){
        this.VegetableId=a;
        this.VegetableName=b;
        this.price=c;
        this.Rating=d;
    }
    int getVegetableId(){
        return VegetableId;
    }
    String getVegetableName(){
        return VegetableName;
    }
    int getprice(){
        return price;
    }
    int getRating(){
        return Rating;
    }
}
class IPA246{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Vegetable[] arr=new Vegetable[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            arr[i]=new Vegetable(a, b, c, d);
        }
        int rating=sc.nextInt();
        sc.nextLine();
        Vegetable ans=findMinimumPriceByRating(arr, rating);
        if(ans!=null){
            System.out.println(ans.getVegetableId());
        }else{
            System.out.println("No such Vegetables");
        }
    }
    public static Vegetable findMinimumPriceByRating(Vegetable[] arr,int rating){
        Vegetable[] ans=new Vegetable[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getRating()>rating){
                ans[cnt++]=arr[i];
            }
        }
        if(cnt==0){
            return null;
        }
        ans=Arrays.copyOf(ans,cnt);
        int mini=ans[0].getprice();
        Vegetable a=null;
        for(int i=1;i<ans.length;i++){
            if(ans[i].getprice()<mini){
                mini=ans[i].getprice();
                a=ans[i];
            }
        }
        return a;
    }
}
/* 
Create a class Vegetable with below attributes:

VegetableId - int
VegetableName - String
Price - int
Rating - int

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - findMinimumPriceByRating in Solution class.

findMinimumPriceByRating method:
-----------------------------------------------
The method will return minimum price object from array of vegetable objects, whichever by rating greater than given rating.
If no vegetable with the above condition is present in the array of vegetable object, then the mothod return null.

Note : 
No vegetable has the same price.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For findMinimumPriceByRating method - The main method should print the id of vegetable object or it should print 
"No such Vegetables".

Eg: 1002
where 1002 is the id whose price is lowest

Before calling these static methods in main, use Scanner object to read the values of four Vegetable objects referring 
attributes in the above mentioned attribute sequence.
Next, read the value of int parameter for rating.

Consider below sample input and output:

Input1
---------------------------
1001
Carrot
90
5
1002
Tomato
40
4
1003
Bectroot
80
4
1004
Onion
78
3
2

Output1
-------------------------------
1002
=====================================================================================
Input2
---------------------------
1001
Carrot
90
5
1002
Tomato
40
4
1003
Bectroot
80
4
1004
Onion
78
3
7

Output2
----------------------------
No such Vegetables
*/