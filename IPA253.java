import java.util.*;
class Player{
    int id;
    String country;
    String side;
    double price;
    Player(int a,String b,String c,double d){
        this.id=a;
        this.country=b;
        this.side=c;
        this.price=d;
    }
    int getid(){
        return id;
    }
    String getcountry(){
        return country;
    }
    String getside(){
        return side;
    }
    double getprice(){
        return price;
    }
}
public class IPA253 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Player[] arr=new Player[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            arr[i]=new Player(a, b, c, d);
        }
        String player=sc.nextLine();
        Player[] ans1=searchPlayerForMatch(arr, player);
        ArrayList<Integer> id=new ArrayList<>();
        for(int i=0;i<ans1.length;i++){
            id.add(ans1[i].getid());
        }
        Collections.sort(id);
        for(int i=0;i<id.size();i++){
            System.out.println(id.get(i));
        }
    }
    public static Player[] searchPlayerForMatch(Player[] arr,String player){
        Player[] ans=new Player[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getside().equalsIgnoreCase(player)){
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
 * Create a Class Player with below attributes:

id - int
country - String
side - String
price - double

Write getters, setters and parameterized constructor as required. 

Create class Solution with main method. 

Implement static method - searchPlayerForMatch in Solution class.

This method will take a String parameter along with the other parameter as array of Player objects. 
The method will return array of Player where the String parameter appears in the side attribute (with case insensitive search).

This method should be called from main method and display the id of returned objects in ascending order. 

Before calling this method(searchPlayerForMatch) in the main method, use Scanner object to read values for four Player objects 
referring the attributes in the above sequence, then, read the value for search parameter. 
Next call the method searchPlayerForMatch, write the logic to sort the id in ascending order (in main method) and display the 
result. 

Consider below sample input and output:

Input:
------------
1
India
Batting
2500000
2
Australia
Batting
1000000
3
Srilanka
Bowling
1700000
4
England
Bowling
2000000
Batting

Output:
------------
1
2
 */