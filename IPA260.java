import java.util.*;
class Course1{
    int CourseId;
    String CourseName;
    double CourseRating;
    String Mode;
    boolean HaveCertificate;
    Course1(int a,String b,double c,String d,boolean e){
        this.CourseId=a;
        this.CourseName=b;
        this.CourseRating=c;
        this.Mode=d;
        this.HaveCertificate=e;
    }
    int getCourseId(){
        return CourseId;
    }
    String getCourseName(){
        return CourseName;
    }
    double getCourseRating(){
        return CourseRating;
    }
    String getMode(){
        return Mode;
    }
    boolean getHaveCertificate(){
        return HaveCertificate;
    }
}
class IPA260{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Course1[] arr=new Course1[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();sc.nextLine();
            String b=sc.nextLine();
            double c=sc.nextDouble();sc.nextLine();
            String d=sc.nextLine();
            boolean e=sc.nextBoolean();sc.nextLine();
            arr[i]=new Course1(a, b, c, d, e);
        }
        int rating=sc.nextInt();sc.nextLine();
        String course=sc.nextLine();
        int ans=CountCourse(arr, rating, course);
        if(ans>0){
            System.out.println(ans);
        }else{
            System.out.println("No Course Found");
        }
    }
    public static int CountCourse(Course1[] arr,int rating,String course){
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getMode().equalsIgnoreCase(course) && arr[i].getCourseRating()>=rating){
                cnt++;
            }
        }
        return cnt;
    }
}
/*
 * Create a Class Course with below attributes:

CourseId - Int
CourseName - String
CourseRating - double
Mode - String
HaveCertificate - boolean

Write getters, setters and parameterized constructor as required. 

Create class Solution with main method. 

Implement static method - CountCourse in Solution class.

This method will take a String parameter and a double parameter along with the other parameter as array of Course objects. 
The method will return the total number of courses which have certificate facility and the rating of the course object is greater
than or equal to the given parameter with match the mode(with case insensitive search).

If no count is there then print "No course found".

Consider below sample input and output:

Input 1:
------------
1001
Java
5
Online
True
1002
Python
3
Offline
False
1003
HTML
4
Offline
True
1004
JavaScript
2
Online
False
3
Online


Output 1:
------------
1
=========================================
Input 2:
------------
1001
Java
5
Online
True
1002
Python
3
Offline
False
1003
HTML
4
Offline
True
1004
JavaScript
2
Online
False
5
Offline

Output 2:
-------------
No course found
 */