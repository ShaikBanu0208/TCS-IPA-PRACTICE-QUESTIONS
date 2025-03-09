import java.util.*;
class Inventory{
    String inventoryId;
    int maximumQuantity;
    int currentQuantity;
    int threshold;
    Inventory(String a,int b,int c,int d){
        this.inventoryId=a;
        this.maximumQuantity=b;
        this.currentQuantity=c;
        this.threshold=d;
    }
    String getinventoryId(){
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
class IPA232{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Inventory[] arr=new Inventory[4];
        for(int i=0;i<arr.length;i++){
            String a=sc.nextLine();
            int b=sc.nextInt();
            sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            arr[i]=new Inventory(a, b, c, d);
        }
        int limit=sc.nextInt();
        sc.nextLine();
        Inventory[] ans=Replenish(arr, limit);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                if(ans[i].getthreshold()>75){
                    System.out.println(ans[i].getinventoryId()+" Critical Filling");
                }else if(ans[i].getthreshold()>=50 && ans[i].getthreshold()<=75){
                    System.out.println(ans[i].getinventoryId()+" Moderate Filling");
                }else{
                    System.out.println(ans[i].getinventoryId()+" Non-Critical Filling");
                }
            }
        }else{
            System.out.println("Not Found");
        }
    }
    public static Inventory[] Replenish(Inventory[] arr,int limit){
        Inventory[] ans=new Inventory[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getthreshold()<=limit){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        if(ans.length>0){
            return ans;
        }else{
            return null;
        }
    }
}
/*
 * 
Create class Inventory with below attributes:

inventoryId - String
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