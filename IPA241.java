import java.util.*;
class Player3{
    private int id;
    private String name;
    private String country;
    private int matchesPlayed;
    private int runsScored;
    Player3(int a,String b,String c,int d,int e){
        this.id=a;
        this.name=b;
        this.country=c;
        this.matchesPlayed=d;
        this.runsScored=e;
    }
    int getid(){
        return id;
    }
    String getname(){
        return name;
    }
    String getcountry(){
        return country;
    }
    int getmatchesPlayed(){
        return matchesPlayed;
    }
    int getrunsScored(){
        return runsScored;
    }
}
public class IPA241 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        Player3[] arr=new Player3[n];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            int e=sc.nextInt();
            sc.nextLine();
            arr[i]=new Player3(a, b, c, d, e);
        }
        String country=sc.nextLine();
        int run=sc.nextInt();
        sc.nextLine();
        Player3[] ans=findPlayerName(arr, country, run);
        if(ans!=null){
            for (int i = 0; i < ans.length-1; i++) 
            {
                for (int j = i+1; j < ans.length; j++) 
                {
                    if(ans[i].getname().compareTo(ans[j].getname())>0)
                    {
                        Player3 name = ans[i];
                        ans[i] = ans[j];
                        ans[j] = name;
                    }
                }
            }
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i].getid()+":"+ans[i].getname());
            }
        }else{
            System.out.println("No player found");
        }
    }
    public static Player3[] findPlayerName(Player3[] arr,String country,int run){
        Player3[] ans=new Player3[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getcountry().equalsIgnoreCase(country) && arr[i].getrunsScored()>run){
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
 *Create class Player3 with below attributes:

id - int
name - String
Country - String
matchesPlayed - int
runsScored - int

the above attribute should be private ,write getter and setter and parametrized constructor as well.

Create class Solution and implement static method "findPlayerName" in the Solution class.
This method will take array of Player objects and a String as country parameters and int as run parameter.
And will return another array of Player object where the String is matched with country and run scored of that Player object 
is greater than the input int parameter. All the searches should be case insensitive.

Before calling "findPlayerName" method in the main method, read values for Player objects referring the attributes 
in above sequence along with a int target.
Then call the "findPlayerName" method and write logic in main method to print Player object. If any of the input doesn't match
with the following attributes then print "No player found".

Note:
--------------
1. First take input as the number of player object, then the player details
2. Show the output as the dictionary order of the players name
3. First print player id, and then use ' : ' sign and after that player name
    3 : Arijit
    1 : Minaz
    5 : Priyanka

Input : 1
--------------
5 
1
Arnab
India
4
94
2
Virat
UK
5
68
3
Arijit
India
82
87
4
Raj
India
21
78
5
Priyanka
India
12
86
India
80

Output : 1
-----------------
3:Arijit
1:Arnab
5:Priyanka

___________________________________________________________

Input : 2
--------------
5 
1
Arnab
India
4
94
2
Virat
UK
5
68
3
Arijit
India
82
87
4
Raj
India
21
78
5
Priyanka
India
12
86
UK
80

Output : 2
--------------------
No player found 
 */