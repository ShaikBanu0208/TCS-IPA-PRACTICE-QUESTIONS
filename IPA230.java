import java.util.*;
class Cinema{
    int movieId;
    String director;
    int rating;
    int budget;
    Cinema(int a,String b,int c,int d){
        this.movieId=a;
        this.director=b;
        this.rating=c;
        this.budget=d;
    }
    int getmovieId(){
        return movieId;
    }
    String getdirector(){
        return director;
    }
    int getrating(){
        return rating;
    }
    int getbudget(){
        return budget;
    }
}
class IPA230{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Cinema[] arr=new Cinema[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            arr[i]=new Cinema(a,b,c,d);
        }
        String director=sc.nextLine();
        int rating=sc.nextInt();
        sc.nextLine();
        int budget=sc.nextInt();
        sc.nextLine();
        int ans1=findAvgBudgetByDirector(arr, director);
        if(ans1>0){
            System.out.println(ans1);
        }else{
            System.out.println("Sorry - The given director has not yet directed any movie");
        }
        Cinema ans2=getMovieByRatingBudget(arr, rating, budget);
        if(ans2!=null){
            System.out.println(ans2.getmovieId());
        }else{
            System.out.println("Sorry - No movie is available with the specified rating and budget requirement");
        }
    }
    public static int findAvgBudgetByDirector(Cinema[] arr,String director){
        int cnt=0,sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getdirector().equalsIgnoreCase(director)){
                cnt++;
                sum=sum+arr[i].getbudget();
            }
        }
        if(sum>0 && cnt>0){
            return sum/cnt;
        }else{
            return 0;
        }
    }
    public static Cinema getMovieByRatingBudget(Cinema[] arr,int rating,int budget){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getrating()==rating && arr[i].getbudget()==budget && (arr[i].getbudget()%arr[i].getrating()==0)){
                return arr[i];
            }
        }
        return null;
    }
}
/*
Create a class Cinema with the below attributes:

movieId - int
director - String
rating - int
budget - int

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with the main method.

Implement two static methods - findAvgBudgetByDirector and getMovieByRatingBudget in Solution class.

findAvgBudgetByDirector method:
----------------------------------
This method will take two input parameters - array of Movie objects and string parameter director.
The method will return the average of the budget attribute from Movie objects directed by the director passed as parameter.
If no movie with the given director is present in the array of movie objects, then the method should return 0.

getMovieByRatingBudget method:
----------------------------------
This method will take two int parameters rating and budget, along with the array of movie objects.
The method will return the movie object, if the input parameters rating and budget, matches with the rating and budget 
attribute of the movie object respectively.

Also check if rating is a factor of budget (eg: 3 is a factor of 12 because 3 divides 12 without leaving a remainder).
If any of the conditions are not met, then the method should return null.

Note : No two movie object would have the same value for rating and budget attributes.
All the searches should be case insensitive.
The budget mentioned are in crores and in INR.

These above mentioned static methods should be called from the main method.

For findAvgBudgetByDirector method - The main method should print the average budget as it is if the returned value is 
greater than 0, or it should print "Sorry - The given director has not yet directed any movie".

For getMovieByRatingBudget method - The main method should print the movieId of the returned movie object. If the returned 
value is null then it should print "Sorry - No movie is available with the specified rating and budget requirement".

Before calling these static methods in main, use Scanner object to read the values of four Movie objects referring attributes 
in the above mentioned attribute sequence. Next, read the value for director, rating and budget.

Input
----------
1101
GVM
4
100
1201
Shankar
5
500
1301
Shankar
3
50
1401
GVM
5
300
GVM
5
300

Output
----------
200
1401
*/