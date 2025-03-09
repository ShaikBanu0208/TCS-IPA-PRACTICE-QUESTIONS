import java.util.*;
class Antenna{
    private int antennaid;
    private String antennaName;
    private String projectLead;
    private double antennaVSWR;
    Antenna(int a,String b,String c,double d){
        this.antennaid=a;
        this.antennaName=b;
        this.projectLead=c;
        this.antennaVSWR=d;
    }
    int getantennaid(){
        return antennaid;
    }
    String getantennaName(){
        return antennaName;
    }
    String getprojectLead(){
        return projectLead;
    }
    double getantennaVSWR(){
        return antennaVSWR;
    }
}
class IPA225{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Antenna[] arr=new Antenna[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            arr[i]=new Antenna(a,b,c,d);
        }
        String name=sc.nextLine();
        double value=sc.nextDouble();
        int ans1=searchAntennaByName(arr, name);
        if(ans1>0){
            System.out.println(ans1);
        }else{
            System.out.println("There is no antenna with the given parameter");
        }
        Antenna[] ans2=sortAntennaByVSWR(arr, value);
        if(ans2!=null){
            for(int i=0;i<ans2.length;i++){
                System.out.println(ans2[i].getprojectLead());
            }
        }else{
            System.out.println("No Antenna found");
        }
    }
    public static int searchAntennaByName(Antenna[] arr,String name){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getantennaName().equalsIgnoreCase(name)){
                return arr[i].getantennaid();
            }
        }
        return 0;
    }
    public static Antenna[] sortAntennaByVSWR(Antenna[] arr,double value){
        int cnt=0;
        Antenna[] ans=new Antenna[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i].getantennaVSWR()<value){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        for(int i=0;i<ans.length;i++){
            for(int j=i+1;j<ans.length;j++){
                if(ans[i].getantennaVSWR()>ans[j].getantennaVSWR()){
                    Antenna temp=ans[i];
                    ans[i]=ans[j];
                    ans[j]=temp;
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
 * create a class Antenna with below attributes.
antennaid=int
antennaName=String
projectLead=String
antennaVSWR=double

the above attribute should be private ,write getter and setter and parametrized constructor as well.

create class MyClass with main method.
implement two static methods searchAntennaByName and sortAntennaByVSWR in MyClass class.


searchAntennaByName :
---------------------------------------
This method will take an array of Antenna objects and the string value as input parameter.The method will find out Antenna name(String parameterpassed).
It will return Antennaid if found.if there is no Antenna that matches then the method will return zero.
The main method should print the antennaid,if the returned value is not 0.if the returned value is 0 then print,"There is no antenna with the given parameter".


sortAntennaByVSWR:
--------------------------------------
This method will take an array of Antenna Objects and a double value as input.
This method will return an array of Antenna objects sorted in ascending orderof their antennaVSWR, which is less than VSWR(double value passed).       

The main method should print name of the project leads from the returned array if the returned value is not null.if the returned value is null then main method 
should print "No Antenna found";


input1:

111
Reconfigurable
Hema
0.4
222
Wearable
Kavya
0.9
333
Microstrip
Teju
0.3
444
Dielectric
Sai
0.65
Microstrip
0.5

output:
333
Teju
Hema


input 2:
111
Reconfigurable
Hema
0.3
222
Wearable
Kavya
0.9
333
Microstrip
Teju
0.4
444
Dielectric
Sai
0.65
Resonator
0.25

output:
There is no antenna with given parameter
No Antenna found
 */