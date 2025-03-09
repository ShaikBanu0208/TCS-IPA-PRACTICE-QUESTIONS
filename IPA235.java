import java.util.*;
class Team{
    int tid;
    String tName;
    String tCountry;
    int tRun;
    Team(int a,String b,String c,int d){
        this.tid=a;
        this.tName=b;
        this.tCountry=c;
        this.tRun=d;
    }
    int gettid(){
        return tid;
    }
    String gettName(){
        return tName;
    }
    String gettCountry(){
        return tCountry;
    }
    int gettRun(){
        return tRun;
    }
}
class IPA235{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Team[] arr=new Team[n];
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            arr[i]=new Team(a,b,c,d); 
        }
        int run=sc.nextInt();
        sc.nextLine();
        String country=sc.nextLine();
        Team ans=findPlayer(arr,run,country);
        if(ans!=null){
            System.out.println(ans.gettid());
            System.out.println(ans.gettName());
            System.out.println(ans.gettCountry());
            System.out.println(ans.gettRun());
        }else{
            System.out.println("No team is found from the given country and run");
        }
    }
    public static Team findPlayer(Team[] arr,int run,String country){
        for(int i=0;i<arr.length;i++){
            if(arr[i].gettCountry().equalsIgnoreCase(country) && arr[i].gettRun()>run){
                return arr[i];
            }
        }
        return null;
    }
}
/*
 * 
Create class Team with below attributes:

tId - int
tName - String
tCountry - String
tRun - int

The above attributes should be private.Write Getter and Setter and parametrized constructor as required.

Create class Solution with main method.

Implement One static method-

● findPlayer

findPlayer in the solution class. 
This method will take array of Team objects, int paramater run and String country and returns the Team object where taken 
country is matched with the country of team object and team run is greater than the taken run.

Write code to perform following tasks:

1. In main mehod, take 1st input as integer parameter which shows the number of team object.
2. Take necessary input variable and call findPlayer.
3. All searches should be case insensitive.

For this method- The main method should print the team object. As if the returned value is not null, 
or it should print "No team is found from the given country and run".

Input
------------------
3 
1
Arijit
India
43
2
Doremon
China
40
3
Donal
England
32
35
China



Output
--------------
2
Doremon
China
40

 */