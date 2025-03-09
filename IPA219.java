import java.util.*;
class medicine{
    String MedicineName;
    String batch;
    String disease;
    int price;
    medicine(String MedicineName,String batch,String disease,int price){
        this.MedicineName=MedicineName;
        this.batch=batch;
        this.disease=disease;
        this.price=price;
    }
    String getMedicineName(){
        return MedicineName;
    }
    String getbatch(){
        return batch;
    }
    String getdisease(){
        return disease;
    }
    int getprice(){
        return price;
    }
}
class IPA219{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        medicine[] arr=new medicine[4];
        for(int i=0;i<arr.length;i++){
            String a=sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            arr[i]=new medicine(a,b,c,d);
        }
        String disease=sc.nextLine();
        medicine[] ans1=getPriceByDisease(arr,disease);
        if(ans1!=null){
            for(int i=0;i<ans1.length;i++){
                System.out.println(ans1[i].getprice());
            }
        }else{
            System.out.println("No medicines are available");
        }
    }
    public static medicine[] getPriceByDisease(medicine[] arr,String disease){
        medicine[] ans=new medicine[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getdisease().equalsIgnoreCase(disease)){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        if(ans!=null){
            return ans;
        } else{
            return null;
        }

    }
}
/*
 * Create class Medicine with below attributes: 

MedicineName - String 
batch - String 
disease - String 
price - int

Create class Solution and implement static method "getPriceByDisease" in the Solution class. 
This method will take array of Medicine objects and a disease String as parameters. 
And will return another sorted array of Integer objects where the disease String matches with the 
original array of Medicine object's disease attribute (case insensitive search).

Write necessary getters and setters.

Before calling "getPriceByDisease" method in the main method, read values for four Medicine objects 
referring the attributes in above sequence along with a String disease. Then call the "getPriceByDisease" 
method and print the result.

Input
-------------

dolo650
FAC124W
fever
100
paracetamol
PAC545B
bodypain
150
almox
ALM747S
fever
200
aspirin
ASP849Q
flu
250
fever

Output
---------
100
200
 */