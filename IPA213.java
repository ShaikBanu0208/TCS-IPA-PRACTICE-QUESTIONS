import java.util.*;
class Sim{
    int simId;
    String customerName;
    double balance;
    double ratePerSecond;
    String circle;
    Sim(int simId,String customerName,double balance,double ratePerSecond,String circle){
        this.simId=simId;
        this.customerName=customerName;
        this.balance=balance;
        this.ratePerSecond=ratePerSecond;
        this.circle=circle;
    }
    int getsimId(){
        return simId;
    }
    String getcustomerName(){
        return customerName;
    }
    double getbalance(){
        return balance;
    }
    double getratePerSecond(){
        return ratePerSecond;
    }
    String getcircle(){
        return circle;
    }
}
class IPA213{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Sim[] arr=new Sim[5];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            double c=sc.nextDouble();
            sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            String e=sc.nextLine();
            arr[i]=new Sim(a,b,c,d,e);
        }
        String circle1=sc.nextLine();
        String circle2=sc.nextLine();
        Sim[] ans=transferCustomerCircle(arr, circle1, circle2);
        if(ans!=null){
            for(int i=ans.length-1;i>=0;i--){
                System.out.println(ans[i].getsimId()+" "+ans[i].getcircle()+" "+ans[i].getratePerSecond());
            }
        }
    }
    public static Sim[] transferCustomerCircle(Sim[] arr,String circle1,String circle2){
        Sim[] ans=new Sim[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
        if(arr[i].getcircle().equalsIgnoreCase(circle1)){
            ans[cnt++]=arr[i];
        }
        }
        ans=Arrays.copyOf(ans,cnt);
        for(int i=0;i<ans.length;i++){
            for(int j=i+1;j<ans.length;j++){
                if(ans[i].getratePerSecond()>ans[j].getratePerSecond()){
                    Sim k=ans[i];
                    ans[i]=ans[j];
                    ans[j]=k;
                }
            }
        }
        if(ans.length>0){
            return ans;
        }else{
            return null;
        }

    }
}
/*
 * Create a class Sim with below attributes:



simId - int

customerName - String

balance - double

ratePerSecond - double

circle - String



Write getters, setters and parameterized constructor as required. 



Public class Solution is already created with main method.


Code inside main method should not be altered else your solution might be 


scored as zero.You may copy the code from main method in eclipse to 

verify your implementation. 





Implement static method - transferCustomerCircle in Solution class.

This method will take first parameter as array of Sim class objects, 

second parameter as circle to be transferred (which is String parameter 

circle1) and third parameter as new circle (which is String parameter 

circle2).



Method will transfer the customer to new circle (circle2), where the

 circle attribute would match second parameter (circle1). 


Method will return array of Sim objects for which circle is transferred.


 Return array should be sorted in descending order of ratePerSecond

 (assuming ratePerSecond is not same for any of the Sim objects).





This method should be called from main method and display the simId,

customerName,circle and ratePerSecond of returned objects 

(as per sample output).



Main method mentioned above already has Scanner code to read values, 

create objects and test above methods. Hence do not modify it.






************************************************************************



Consider below sample input and output:



Input:

1
raj
100
1.5
KOL
2
chetan
200
1.6
AHD
3
asha
150
1.7
MUM
4
kiran
50
2.2
AHD
5
vijay
130
1.8
AHD
AHD
KOL



Output:

4 kiran KOL 2.2

5 vijay KOL 1.8

2 chetan KOL 1.6
 */