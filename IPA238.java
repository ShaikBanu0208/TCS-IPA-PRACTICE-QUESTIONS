import java.util.*;
class Music{
    private int playListNo;
    private String type;
    private int count;
    private double duration;
    Music(int a,String b,int c,double d){
        this.playListNo=a;
        this.type=b;
        this.count=c;
        this.duration=d;
    }
    int getplayListNo(){
        return playListNo;
    }
    String gettype(){
        return type;
    }
    int getcount(){
        return count;
    }
    double getduration(){
        return duration;
    }
}
class IPA238{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Music[] arr=new Music[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            arr[i]=new Music(a,b,c,d);
        }
        int count=sc.nextInt();
        sc.nextLine();
        int duration=sc.nextInt();
        sc.nextLine();
        int ans1=findAvgOfCount(arr, count);
        if(ans1!=0){
            System.out.println(ans1);
        }else{
            System.out.println("No playlist found");
        }
        Music[] ans2=sortTypeByDuration(arr, duration);
        if(ans2!=null){
            for(int i=0;i<ans2.length;i++){
                System.out.println(ans2[i].gettype());
            }
        }else{
            System.out.println("No playlist found with mentioned attribute");
        }
    }
    public static int findAvgOfCount(Music[] arr,int count){
        int sum=0;
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getcount()>count){
                sum+=arr[i].getcount();
                cnt++;
            }
        }
        if(cnt>0){
            return sum/cnt;
        }
        return 0;
    }
    public static Music[] sortTypeByDuration(Music[] arr,int duration){
        Music[] ans=new Music[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getduration()>duration){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        for(int i=0;i<ans.length;i++){
            for(int j=i+1;j<ans.length;j++){
                if(ans[i].getduration()>ans[j].getduration()){
                    Music temp=ans[i];
                    ans[i]=ans[j];
                    ans[j]=temp;
                }
            }
        }
        if(ans.length>0){
            return ans;
        }
        return null;
    }
}
/*
 * Create a class Music with below attributes:

playListNo - int

type -String

count - int

duration(minutes) -double.



The above attributes should be private.Write Getter and Setter and parametrized constructor as required.

Create class Solution with main method.

****************************************************************************

Implement two static methods: findAvgOfCount and sortTypeByDuration in Solution Class.



findAvgOfCount Method:
----------------------------------------
This method will take an array of Music objects and an int value as input parameters.The method will find out Average 
(as int) of count for those objects whose count is more than the given Count(int parameter passed).This method will return 
average if found.If there is no Type that matches then the method should return 0.

for this method- main method should print average ,if the returned value is not 0.If the returned value is 0 then main method 
should print "No playlist found".

sortTypeByDuration method:
-----------------------------------------
This method will take an array of Music objects and an int value as input parameters.This method should return an array of 
Music objects in an ascending order of their duration which are more than the given duration (int parameter passed) value.
If there are no such objects ,then the method should return null.

for this method-The main method should print the type from the returned Music object array if the returned value is not null.
If the returned value is null then the main method should print "No playlist found with mentioned attribute".

****************************************************************************

Consider the below input and output:

input1:
------------
111
WorkOut
10
15.2
321
Dance Party
20
55.500
721
Childhood Jams
6
50.60
521
Chill
30
78.89
15
20


output1:
--------------------
25
Childhood Jams
Dance Party
Chill



input2:
-----------------------
111
Oldies but Goodies
17
55
321
Guilty Pleasures
27
27
721
night drive
21
345
521
Rainy day
34
21
50
5000


output 2:
-----------------------
No playlist found.
No playlist found with mentioned attribute.
 */