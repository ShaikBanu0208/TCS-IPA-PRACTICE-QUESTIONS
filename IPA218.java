import java.util.*;
class Player{
    int playerId;
    String skill;
    String level;
    int points;
    Player(int a,String b,String c,int d){
        this.playerId=a;
        this.skill=b;
        this.level=c;
        this.points=d;
    }
    int getplayerId(){
        return playerId;
    }
    String getskill(){
        return skill;
    }
    String getlevel(){
        return level;
    }
    int getpoints(){
        return points;
    }
}
class IPA218{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Player[] arr=new Player[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();
            arr[i]=new Player(a,b,c,d);
        }
        sc.nextLine();
        String skill=sc.nextLine();
        String level=sc.nextLine();
        int ans1=findPointsForGivenSkill(arr, skill);
        if(ans1!=0){
            System.out.println(ans1);
        }else{
            System.out.println("The given Skill is not available");
        }
        Player ans2=getPlayerBasedOnLevel(arr, level, skill);
        if(ans2!=null){
            System.out.println(ans2.getplayerId());
        }else{
            System.out.println("No player is available with specified level, skill and eligibility points");
        }

    }
    public static int findPointsForGivenSkill(Player[] arr,String skill){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getskill().equalsIgnoreCase(skill)){
                sum=sum+arr[i].getpoints();
            }
        }
        return sum;
    }
    public static Player getPlayerBasedOnLevel(Player[] arr,String level,String skill){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getlevel().equalsIgnoreCase(level) && arr[i].getskill().equalsIgnoreCase(skill) && arr[i].getpoints()>20){
                return arr[i];
            }
        }
        return null;
    }
}
/*
Create a class Player with below attributes: 

playerId - int 
skill - String 
level - String 
points - int

Write getters, setters and parameterized constructor in the above mentioned attribute 
sequence as required.

Create class Solution with the main method.

Implement two static methods - findPointsForGivenSkill and getPlayerBasedOnLevel in Solution class.

findPointsForGivenSkill method: 
------------------------------------
This method will take two input parameters - array of Player objects 
and string parameter skill. The method will return the sum of the points attribute from player objects 
for the skill passed as parameter. If no player with the given skill is present in the array of player 
objects, then the method should return 0.

getPlayerBasedOnLevel method: 
-------------------------------------
This method will take two String parameters level and skill, along with the array of Player objects. 
The method will return the player object, if the input String parameters matches with the level and 
skill attribute of the player object and its point attribute is greater than or equal to 20. If any 
of the conditions are not met, then the method should return null.

Note : No two player object would have the same value for skill and level attribute. All player object 
would have the points greater than 0. All the searches should be case insensitive.

These above mentioned static methods should be called from the main method.

For findPointsForGivenSkill method - The main method should print the points as it is if the returned 
price is greater than 0, or it should print "The given Skill is not available".

For getPlayerBasedOnLevel method - The main method should print the playerId of the returned player object.
If the returned value is null then it should print "No player is available with specified level, skill 
and eligibility points".

Before calling these static methods in main, use Scanner object to read the values of four Player objects 
referring attributes in the above mentioned attribute sequence. Next, read the value for skill and level.
Please consider the skill value read above as skill parameter for both the static methods.

Input:
-----------
101
Cricket
Basic
20
102
Cricket
Intermediate
25
111
Football
Intermediate
50
113
BaseBall
Advanced
100
Cricket
Intermediate

Output:
--------------
45
102
*/