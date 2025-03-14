import java.util.*;
class MobileDetails{
    private int MobileId;
    private int price;
    private String Brand;
    private boolean isFlagShip;
    MobileDetails(int a,int b,String c,boolean d){
        this.MobileId=a;
        this.price=b;
        this.Brand=c;
        this.isFlagShip=d;
    }
    int getMobileId(){
        return MobileId;
    }
    int getprice(){
        return price;
    }
    String getbrand(){
        return Brand;
    }
    boolean getisFlagShip(){
        return isFlagShip;
    }
}
class IPA243{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        MobileDetails[] arr=new MobileDetails[5];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            int b=sc.nextInt();
            sc.nextLine();
            String c=sc.nextLine();
            boolean d=sc.nextBoolean();
            sc.nextLine();
            arr[i]=new MobileDetails(a,b,c,d);
        }
        String brand=sc.nextLine();
        sc.close();
        int ans1=getTotalPrice(arr,brand);
        if(ans1!=0){
            System.out.println(ans1);
        }else{
            System.out.println("here are no mobile with given brand");
        }
        MobileDetails[] ans=getSecondMin(arr,brand);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i].getbrand()+":"+ans[i].getprice());
            }
        }else{
            System.out.println("There are no mobile with given brand");
        }
    }
    public static int getTotalPrice(MobileDetails[] arr,String brand){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getbrand().equalsIgnoreCase(brand)){
                sum+=arr[i].getprice();
            }
        }
        return sum;
    }
    public static MobileDetails[] getSecondMin(MobileDetails[] arr,String brand){
        int mini=Integer.MAX_VALUE;
        int secmini=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getprice()<mini){
                secmini=mini;
                mini=arr[i].getprice();
            }else if(arr[i].getprice()>mini && arr[i].getprice()<secmini){
                secmini=arr[i].getprice();
            }
        }
        MobileDetails[] ans=new MobileDetails[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getprice()==secmini){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        if(ans.length>0){
            return ans;
        }
        return null;
    }
}
/*
 * 
Create a class MobileDetails with the below attributes:

MobileId – int
Price - int
Brand – String
isFlagShip – boolean

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class MobileDetails with main method.

Implement two static methods – getTotalPrice() and getSecondMin() in MobileDetails class.

getTotalPrice method: 
----------------------------------------
This method will take two int input parameters which take object array and string brand. The method will return the total
price of mobiles of that brand.

If no mobile with the given brand is present in the array of MobileDetails objects, then the method should return 0.

getSecondMin method: 
----------------------------------------
This method will take object array which will return the second minimum price from the array and name of that mobile brand.

The above mentioned static methods should be called from the main method.

For getTotalPrice method: The main method should print the total price as it is, if the returned 
value is not null, or it should print “There are no mobile with given brand”. 

Before calling these static methods in main, use Scanner object to read the values of five objects referring attributes 
in the above mentioned attribute sequence.

Input :
---------------------------------------
101
25000
Samsung
True
102
19000
Redmi
False
103
28000
Nokia
True
104
25000
Realme
False
105
40000
Samsung
True
Samsung

Output :
-----------------------------------------
65000
Samsung : 25000
Realme : 25000

 */