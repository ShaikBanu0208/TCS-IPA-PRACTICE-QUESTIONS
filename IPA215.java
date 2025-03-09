import java.util.*;
class Book{
    private int id;
    private int pages;
    private String title;
    private String author;
    private double price;
    Book(int a,int b,String c,String d,double e){
        this.id=a;
        this.pages=b;
        this.title=c;
        this.author=d;
        this.price=e;
    }
    int getid(){
        return id;
    }
    int getpages(){
        return pages;
    }
    String gettitle(){
        return title;
    }
    String getauthor(){
        return author;
    }
    double getprice(){
        return price;
    }
}
class IPA215{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Book[] arr=new Book[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            int b=sc.nextInt();
            sc.nextLine();
            String c=sc.nextLine();
            String d=sc.nextLine();
            double e=sc.nextDouble();sc.nextLine();
            arr[i]=new Book(a,b,c,d,e);
        }
        String book=sc.nextLine();
        Book ans1[]=findBookWithMaximumPrice(arr);
        if(ans1!=null){
            for(int i=0;i<ans1.length;i++){
                System.out.println(ans1[i].getid()+" "+ans1[i].gettitle());
            }
        }else{
            System.out.println("No Book found with mentioned attribute.");
        }
        Book[] ans2=searchBookByTitle(arr, book);
        if(ans2!=null){
            for(int i=0;i<ans2.length;i++){
                System.out.println(ans2[i].getpages());
            }
        }else{
            System.out.println("No Book found with mentioned attribute.");
        }
    }
    public static Book[] findBookWithMaximumPrice(Book[] arr){
        Book ans[]=new Book[arr.length];
        double maxi=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getprice()>maxi){
                maxi=arr[i].getprice();
            }
        }
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getprice()==maxi){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        if(ans.length>0){
            return ans;
        }
        return null;
    }
    public static Book[] searchBookByTitle(Book[] arr,String book){
        Book[] ans2=new Book[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].gettitle().equalsIgnoreCase(book)){
                ans2[cnt++]=arr[i];
            }
        }
        ans2=Arrays.copyOf(ans2,cnt);
        if(ans2.length>0){
            return ans2;
        }else{
            return null;
        }
    }
}
/*
 * Create a class Book with below attributes

id - int

pages - int

title - String

author - String

price - double

The above attributes should be private, write getters and setters and parameterized constructor as required.

Create a class Solution with main method
--------------------------------------------
Implement two static methods - findBookWithMaximumPrice and searchBookByTitle in Solution class.

findBookWithMaximumPrice :
=============================
Create a static method findBookWithMaximumPrice in the Solution class. This method will take array of Book objects and 
returns the Book object having the maximum Price if found else return null if not found.

searchBookByTitle :
=============================
Create a static method searchBookByTitle in the Solution class. This method will take array of Book objects and Title as 
input and returns the Book object having the mentioned Title if found else return null if not found.

These methods should be called from the main method.

write code to perform the following tasks.

1. Take necessary input variable and call findBookWithMaximumPrice. For this method - The main method should print the Book
 object with the maximum of mentioned attribute as it is if the returned value is not null, or it should print 
 "No Book found with mentioned attribute."

2. Take necessary input variable and call searchBookByTitle. For this method - The main method should print the Book object 
details as it is, if the returned value is not null or it should print "No Book found with mentioned attribute."

The above mentioned static methods should be called from the main method. Also write the code for accepting the inputs and 
printing the outputs. Don't use any static test or formatting for printing the result. Just invoke the method and print the
result.

All String comparison needs to be in case sensitive.

Input:

1
845
Bengali
Arijit
525.50
2
456
English
Raju
412.30
3
1022
History
Kaka
525.50
4
125
geography
MN
524
English

Output:

1 Bengali
3 History
2
456
 */