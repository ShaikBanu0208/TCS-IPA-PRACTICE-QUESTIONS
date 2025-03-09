import java.util.*;
class Sim2{
    int id;
    String company;
    int balance;
    double ratePerSecond;
    String circle;
    Sim2(int a,String b,int c,double d,String e){
        this.id=a;
        this.company=b;
        this.balance=c;
        this.ratePerSecond=d;
        this.circle=e;
    }
    int getid(){
        return id;
    }
    String getcompany(){
        return company;
    }
    int getbalance(){
        return balance;
    }
    double getratePerSecond(){
        return ratePerSecond;
    }
    String getcircle(){
        return circle;
    }
}
class IPA234{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Sim2[] arr=new Sim2[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            String e=sc.nextLine();
            arr[i]=new Sim2(a,b,c,d,e);
        }
        String search_circle=sc.nextLine();
        double search_rate=sc.nextDouble();
        sc.nextLine();
        Sim2[] ans=matchAndSort(arr,search_circle,search_rate);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i].getid());
            }
        }else{
            System.out.println("Not Found");
        }
    }
    public static Sim2[] matchAndSort(Sim2[] arr,String search_circle,double search_rate){
        Sim2[] ans=new Sim2[arr.length];
        int cnt=0;
        for(int i=0;i<ans.length;i++){
            if(arr[i].getcircle().equalsIgnoreCase(search_circle) && arr[i].getratePerSecond()< search_rate){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        if(ans.length>0){
        for(int i=0;i<ans.length-1;i++){
            for(int j=i+1;j<ans.length;j++){
                if(ans[i].getbalance()<ans[j].getbalance()){
                    Sim2 temp=ans[i];
                    ans[i]=ans[j];
                    ans[j]=temp;
                }
            }
        }
        return ans;
    }
        return null;
    }
}

/*
 * Create class Sim2 with below attributes:

id - int
company - String
balance - int
ratePerSecond - double
circle - String

Create class Solution and implement static method "matchAndSort" in the Solution class.

This method will take array of Sim objects, search_circle String and search_rate double as parameters.
And will return another Sim array where the search_circle matches with the circle parameter of the original Sim array and 
the search_rate double is greater than the original array of Sim object's ratePerSecond attribute which is also sorted by 
means of balance attribute in descending order.

Write necessary getters and setters.

Before calling "matchAndSort" method in the main method, read values for four Sim objects referring the attributes in above 
sequence along with a String search_circle and a double search_rate. Then call the "matchAndSort" method and write logic in 
main method to print the id's of the result obtained.

Input
--------------------------
1
jio
430
1.32
mumbai
2
idea
320
2.26
mumbai
3
airtel
500
2.54
mumbai
4
vodafone
640
3.21
mumbai
mumbai
3.4

Output
--------------------------
4
3
1
2
 */