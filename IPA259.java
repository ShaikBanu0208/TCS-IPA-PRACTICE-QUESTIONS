import java.util.*;
class course{
    String CourseName;
    int CourseNumber;
    String Mode;
    boolean Sharedata;
    course(String a,int b,String c,boolean d){
        this.CourseName=a;
        this.CourseNumber=b;
        this.Mode=c;
        this.Sharedata=d;
    }
    String getCourseName(){
        return CourseName;
    }
    int getCourseNumber(){
        return CourseNumber;
    }
    String getMode(){
        return Mode;
    }
    boolean getSharedata(){
        return Sharedata;
    }
}
class IPA259{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        course[] arr=new course[4];
        for(int i=0;i<arr.length;i++){
            String a=sc.nextLine();
            int b=sc.nextInt();
            sc.nextLine();
            String c=sc.nextLine();
            boolean d=sc.nextBoolean();
            sc.nextLine();
            arr[i]=new course(a,b,c,d);
        }
        String Course=sc.nextLine();
        int ans=findCourseStatus(arr,Course);
        if(ans!=0){
        if(ans>=1000){
            System.out.println("High");
        }else if(ans>=500 && ans<1000){
            System.out.println("Medium");
        }else{
            System.out.println("Low");
        }
        }else{
            System.out.println("No Course Found");
        }
    }
    public static int findCourseStatus(course[] arr,String Course){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getCourseName().equalsIgnoreCase(Course)){
                return arr[i].getCourseNumber();
            }
        }
        return 0;
    }
}
/*
 * Create a Class Course with below attributes:

CourseName - String
CourseNumber - int
Mode - String
Sharedata - boolean

Write getters, setters and parameterized constructor as required. 

Create class Solution with main method. 

Implement static method - findCourseStatus in Solution class.

This method will take a String parameter along with the other parameter as array of Course objects. 
The method will return status where the String parameter appears in the side attribute (with case insensitive search).

If the number of the course greater than equal to 1000, print "High", if greater or equal to 500 but less than 1000 then print
"Medium" and if less than 500 then print "Low".

If the taken string not match with the Course name then print "No course found".


Consider below sample input and output:

Input 1:
------------
Java
1200
Online
False
Python
600
Offline
False
HTML
800
Offline
False
JavaScript
300
Online
True
Python

Output 1:
------------
Medium
=========================================
Input 2:
------------
Java
1200
Online
False
Python
600
Offline
False
HTML
800
Offline
False
JavaScript
300
Online
True
PHP

Output 2:
-------------
No course found
 */