import java.util.*;
class NavalVessel{
    int vesselId;
    String vesselName;
    int noOfVoyagesPlanned;
    int noOfVoyagesCompleted;
    String purpose;
    String classification;
    NavalVessel(int a,String b,int c,int d,String e){
        this.vesselId=a;
        this.vesselName=b;
        this.noOfVoyagesPlanned=c;
        this.noOfVoyagesCompleted=d;
        this.purpose=e;
    }
    int getvesselId(){
        return vesselId;
    }
    String getvesselName(){
        return vesselName;
    }
    int getnoOfVoyagesPlanned(){
        return noOfVoyagesPlanned;
    }
    int getnoOfVoyagesCompleted(){
        return noOfVoyagesCompleted;
    }
    String getpurpose(){
        return purpose;
    }
    void setclassification(String a){
        this.classification=a;
    }
    String getclassification(){
        return classification;
    }
}
class IPA223{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        NavalVessel[] arr=new NavalVessel[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            String e=sc.nextLine();
            arr[i]=new NavalVessel(a, b, a, d, e);
        }
        int percentage=sc.nextInt();
        sc.nextLine();
        String purpose=sc.nextLine();
        int ans1=findAvgVoyagesByPct(arr, percentage);
        if(ans1!=0){
            System.out.println(ans1);
        }else{
            System.out.println("No NavalVessels completed");
        }
        NavalVessel[] ans2=findVesselByGrade(arr, purpose);
        if(ans2!=null){
            for(int i=0;i<ans2.length;i++){
                int a=(ans2[i].getnoOfVoyagesCompleted() * 100)/ans2[i].getnoOfVoyagesPlanned();
                if(a==100){
                    System.out.println(ans2[i].getvesselName()+"%"+"Star");
                }else if(a>=80 && a<=99){
                    System.out.println(ans2[i].getvesselName()+"%"+"Leader");
                }else if(a>=55 && a<=79){
                    System.out.println(ans2[i].getvesselName()+"%"+"Inspirer");
                }else{
                    System.out.println(ans2[i].getvesselName()+"%"+"Striver");
                }
            }
        }else{
            System.out.println("No Naval Vessel is available with the specified purpose");
        }
    }
    public static int findAvgVoyagesByPct(NavalVessel[] arr,int percentage){
        int cnt=0,sum=0;
        for(int i=0;i<arr.length;i++){
            int a=(arr[i].getnoOfVoyagesCompleted() * 100)/arr[i].getnoOfVoyagesPlanned();
            if(a>=percentage){
                cnt++;
                sum+=arr[i].getnoOfVoyagesCompleted();
            }
        }
        if(sum>0 && cnt>0){
            return (int)sum/cnt;
        }else{
            return 0;
        }
    }
    public static NavalVessel[] findVesselByGrade(NavalVessel[] arr,String purpose){
        NavalVessel[] ans=new NavalVessel[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
           if(arr[i].getpurpose().equalsIgnoreCase(purpose)){
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
Create a class NavalVessel with the below attributes:

vesselld – int
vesselName – String
noOfVoyagesPlanned – int
noOfVoyagesCompleted – int
purpose – String


Write getters, setters for the above attributes. Create constructor which takes parameter in the above 
sequence except classification.

Create class Solution with main method. Implement two static methods – findAvgVoyagesByPct and findVesselByGrade 
in Solution class.

findAvgVoyagesByPct method:

This method will take two input parameters -array of NavalVessel objects and int parameter percentage. The method will 
return the average of the noOfVoyagesCompleted attribute from NavalVessel objects which meets the percentage requirement 
as mentioned below.The percentage for each navalVessel is calculated as 
percentage .(noOfVoyagesCompleted * 100)/noOfVoyagesPlanned. If the above calculated percentage is greater than or equal 
to the percentage passed as the parameter, then those objects should participate in the average calculation. If there are 
no objects with the mentioned criteria, then the method should return 0.

findVesselByGrade method:

This method will take a String parameter purpose, along with the array of NavalVessel objects. The method will return the 
NavalVessel object, if the input String parameter matches with the purpose attribute of the NavalVessel object. Before 
returning the object, the classification should be derived as mentioned below. This classification value should be assigned 
to the object before returning. If any of the above conditions are not met, then the method should return null. The 
classification attribute should be calculated based on the percentage calculation mentioned above. 
If the percentage = 100 then classification should be ‘Star’, if percentage is between 99 and 80 then classification should 
be ‘Leader, if percentage is between 79 and 55 then classification should be ‘Inspirer' otherwise the classification should 
be ‘Striver’ If the returned value is null then it should print “No Naval Vessel is available with the specified purpose”.

Before calling these static methods in main, use Scanner object to read the values of four NavalVessel objects referring 
attributes in the above mentioned attribute sequence (except the classification attribute). Next, read the value for 
percentage and purpose.

Input
-------------------
111
Rojer
100
100
Passenger
222
Kalam
200
100
Goods
333
Yashwin
400
300
Army
444
Thanishwini
500
500
Welfare
75
Army

Output
------------------
300
Yashwin%Inspirer

 */