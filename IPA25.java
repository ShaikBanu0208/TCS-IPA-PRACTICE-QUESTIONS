import java.util.*;
class Inventory{
    int inventoryId;
    int maximumQuantity;
    int currentQuantity;
    int threshold;
    Inventory(int a,int b,int c,int d){
        this.inventoryId=a;
        this.maximumQuantity=b;
        this.currentQuantity=c;
        this.threshold=d;
    }
    int getinventoryId(){
        return inventoryId;
    }
    int getmaximumQuantity(){
        return maximumQuantity;
    }
    int getcurrentQuantity(){
        return currentQuantity;
    }
    int getthreshold(){
        return threshold;
    }
}
class IPA25{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Inventory[] arr=new Inventory[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            int b=sc.nextInt();
            sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            arr[i]=new Inventory(a,b,c,d);
        }
        int limit=sc.nextInt();
        Inventory[] ans=Replenish(arr,limit);
        for(int i=0;i<ans.length;i++){
            int res=ans[i].getthreshold();
            if(res>75){
                System.out.println(ans[i].getinventoryId()+" Critical Filling");
            }else if(res>=50 && res<=75){
                System.out.println(ans[i].getinventoryId()+" Moderate Filling");
            }else{
                System.out.println(ans[i].getinventoryId()+" Not Critical Filling");
            }
        }
        
    }
    public static Inventory[] Replenish(Inventory[] arr,int limit){
        Inventory[] temp=new Inventory[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i].getthreshold()<=limit){
                temp=Arrays.copyOf(temp,temp.length+1);
                temp[temp.length-1]=arr[i];
            }
        }
        return temp;
    }
}
/*
 * Question:
Create class Inventory with below attributes:

inventoryId - int
maximumQuantity - int
currentQuantity - int
threshold - int

Create class Solution and implement static method "Replenish" in the Solution class.
This method will take array of Inventory objects and a limit int as parameters.
And will return another array of Inventory objects where the limit int is greater than or equal to the original array of 
Inventory object's threshold attribute.

Write necessary getters and setters.

Before calling "Replenish" method in the main method, read values for four Inventory objects referring the attributes in above 
sequence along with a int limit.Then call the "Replenish" method and write logic in main method to print "Critical Filling",
if the threshold attribute is greater than 75. Else if the threshold attribute is between 50 and 75 then print 
"Moderate Filling". Else print "Non-Critical Filling"

Input
---------------------------
1
100
50
50
2
200
60
40
3
150
35
45
4
80
45
40
45

Output
----------------------------
2 Non-Critical Filling
3 Non-Critical Filling
4 Non-Critical Filling
 */