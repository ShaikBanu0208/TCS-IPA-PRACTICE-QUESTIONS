import java.util.*;
class Player2{
    int id;
    String name;
    int iccRank;
    int matchesPlayed;
    int runsScored;
    Player2(int a,String b,int c,int d,int e){
        this.id=a;
        this.name=b;
        this.iccRank=c;
        this.matchesPlayed=d;
        this.runsScored=e;
    }
    int getid(){
        return id;
    }
    String getname(){
        return name;
    }
    int geticcRank(){
        return iccRank;
    }
    int getmatchesPlayed(){
        return matchesPlayed;
    }
    int getrunsScored(){
        return runsScored;
    }
}
class IPA233{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Player2[] arr=new Player2[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            int e=sc.nextInt();
            sc.nextLine();
            
            arr[i]=new Player2(a,b,c,d,e);
        }
        int target=sc.nextInt();
        sc.nextLine();
        double[] ans=findAverageOfRuns(arr,target);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                if(ans[i]>=80 && ans[i]<=100){
                    System.out.println("Grade A");
                }else if(ans[i]>=50 && ans[i]<=79){
                    System.out.println("Grade B");
                }else{
                    System.out.println("Grade C");
                }
            }
        }
    }
    public static double[] findAverageOfRuns(Player2[] arr,int target){
        double[] ans=new double[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i].getmatchesPlayed()>target){
                ans=Arrays.copyOf(ans,ans.length+1);
                ans[ans.length-1]=arr[i].getrunsScored()/arr[i].getmatchesPlayed();
            }
        }
        if(ans.length>0){
            return ans;
        }
        return null;
    }
}
/*
 * 
Create class Player2 with below attributes:

id - int
name - String
iccRank - int
matchesPlayed - int
runsScored - int

Create class Solution and implement static method "findAverageOfRuns" in the Solution class.
This method will take array of Player objects and a target int as parameters.
And will return another double array where the target int is lesser than or equal to the original array of Player object's 
matchesPlayed attribute and contains the average run scored by each player satisfying above condition.

Write necessary getters and setters.

Before calling "findAverageOfRuns" method in the main method, read values for four Player objects referring the attributes 
in above sequence along with a int target.
Then call the "findAverageOfRuns" method and write logic in main method to print "Grade A",if the calculated averageRun 
value is 80 to 100. Else if the averageRun value is between 50 and 79 then print "Grade B". Else print "Grade C".

Input
------------------
100
Sachin
5
150
13000
101
Sehwag
4
120
10000
103
Dhoni
7
110
7000
104
Kohli
15
57
4400
100

Output
--------------------
Grade A
Grade A
Grade B

 */