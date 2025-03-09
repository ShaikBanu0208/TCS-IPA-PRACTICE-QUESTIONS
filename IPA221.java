import java.util.*;
class Movie{
    String movieName;
    String company;
    String genre;
    int budget;
    Movie(String a,String b,String c,int d){
        this.movieName=a;
        this.company=b;
        this.genre=c;
        this.budget=d;
    }
    String getmovieName(){
        return movieName;
    }
    String getcompany(){
        return company;
    }
    String getgenre(){
        return genre;
    }
    int getbudget(){
        return budget;
    }
}
class IPA221{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Movie[] movie=new Movie[4];
        for(int i=0;i<movie.length;i++){
            String a=sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            movie[i]=new Movie(a,b,c,d);
        }
        String genre=sc.nextLine();
        Movie[] ans=getMovieByGenre(movie, genre);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                if(ans[i].getbudget()>80000000){
                    System.out.println("High Budget Movie");
                }else{
                    System.out.println("Low Budget Movie");
                }
            }
        }else{
            System.out.println("No movies found");
        }
    }
    public static Movie[] getMovieByGenre(Movie[] movie,String genre){
        Movie[] ans=new Movie[movie.length];
        int cnt=0;
        for(int i=0;i<movie.length;i++){
            if(movie[i].getgenre().equalsIgnoreCase(genre)){
                ans[cnt++]=movie[i];
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
 * Create class Movie with below attributes: 

movieName - String 
company - String 
genre - String 
budget - int

Create class Solution and implement static method "getMovieByGenre" in the Solution class. This method will 
take array of Movie objects and a searchGenre String as parameters. And will return another array of Movie 
objects where the searchGenre String matches with the original array of Movie object's genre attribute 
(case insensitive search).

Write necessary getters and setters.

Before calling "getMovieByGenre" method in the main method, read values for four Movie objects referring the 
attributes in above sequence along with a String searchGenre. Then call the "getMovieByGenre" method and write
logic in main method to print "High Budget Movie",if the movie budget attribute is greater than 80000000 else 
print "Low Budget Movie".

Input
---------
aaa
Marvel
Action
250000000
bbb
Marvel
Comedy
25000000
ccc
Marvel
Comedy
2000000
ddd
Marvel
Action
300000000
Action

Output
-------------------
High Budget Movie
High Budget Movie
 */