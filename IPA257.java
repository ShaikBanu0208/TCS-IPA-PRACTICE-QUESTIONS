import java.util.*;
class Beach{
    int beachId;
    String beachName;
    int beachRating;
    int beachCost;
    Beach(int a,String b,int c,int d){
        this.beachId=a;
        this.beachName=b;
        this.beachRating=c;
        this.beachCost=d;
    }
    int getbeachId(){
        return beachId;
    }
    String getbeachName(){
        return beachName;
    }
    int getbeachRating(){
        return beachRating;
    }
    int getbeachCost(){
        return beachCost;
    }
}
class IPA257{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Beach[] arr=new Beach[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            arr[i]=new Beach(a,b,c,d);
        }
        String name=sc.nextLine();
        int rating=sc.nextInt();
        sc.nextLine();
        int ans=findLeastRatingWithName(arr, name, rating);
        if(ans!=0){
            System.out.println(ans);
        }else{
            System.out.println("No Beach Found");
        }
    }
    public static int findLeastRatingWithName(Beach[] arr,String name,int rating){
        int[] ans=new int[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getbeachName().equalsIgnoreCase(name) && arr[i].getbeachCost()>rating){
                ans[cnt++]=arr[i].getbeachRating();
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        Arrays.sort(ans);
        if(ans.length>0){
            return ans[0];
        }
        return 0;
    }
}
/*
 * Create a class Beach with the below attributes: 
beachId - int 
beachName - String 
beachRating - int 
beachCost - int
Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with the main method.
Implement two static methods - findLeastRatingWithName in Solution class.

findLeastRatingWithName method: 
-----------------------------------
This method will take three input parameters - array of Beach objects and string parameter and a int parameter. The method 
will return the minimum rating attribute from beach objects whose name is matched with string parameter and whose amount
is greater than the int parameter. If no data found of beach objects, then the method should return 0.

Note : All the searches should be case insensitive.

These above mentioned static methods should be called from the main method.
For findLeastRatingWithName method - The main method should print the least rating from the beach array. If return 0, then
you should print "No beach found".

Input ->
1001
Puri
3
8600 
1002
Digha
5
6200
1003
Digha
3
4000
1004
Digha
4
5500
digha
5000

Output ->
4
 */