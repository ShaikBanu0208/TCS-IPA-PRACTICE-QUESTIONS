import java.util.*;
class Associate{
    int id;
    String name;
    String technology;
    int experienceInYears;
    Associate(int a,String b,String c,int d){
        this.id=a;
        this.name=b;
        this.technology=c;
        this.experienceInYears=d;
    }
    int getid(){
        return id;
    }
    String getname(){
        return name;
    }
    String gettechnology(){
        return technology;
    }
    int getexperienceInYears(){
        return experienceInYears;
    }
}
class IPA229{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Associate[] arr=new Associate[5];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            arr[i]=new Associate(a, b, c, d);
        }
        String tech=sc.nextLine();
        Associate[] ans=associatesForGivenTechnology(arr, tech);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i].getid());
            }
        }else{
            System.out.println("Not Found");
        }
    }
    public static Associate[] associatesForGivenTechnology(Associate[] arr,String tech){
        Associate[] ans=new Associate[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].gettechnology().equalsIgnoreCase(tech) && arr[i].getexperienceInYears()%5==0){
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
Create class Associate with below attributes:
id - int
name - String
technology - String
experienceInYears - int

Create class Solution and implement static method "associatesForGivenTechnology" in the Solution class.
This method will take array of Associate objects and a searchTechnology String as parameters.
And will return another array of Associate objects where the searchTechnology String matches with the original array of 
Associate object's technology attribute (case insensitive search) and experienceInYears attribute should be multiples of 5.

Write necessary getters and setters.

Before calling "associatesForGivenTechnology" method in the main method, read values for five associate objects referring 
the attributes in above sequence along with a String searchTechnology.
Then call the "associatesForGivenTechnology" method and write the logic to print the id's in the main method.

Input
-----------------
101
Alex
Java
15
102
Albert
Unix
20
103
Alferd
Testing
13
104
Alfa
Java
15
105
Almas
Java
29
Java

Output
------------------
101
104

 */