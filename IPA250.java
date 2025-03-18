import java.util.*;
class Student{
    String name;
    String rollNo;
    int age;
    char gender;
    String course;
    int semester;
    double GPA;
    Student(String a,String b,int c,char d,String e,int f,double g){
        this.name=a;
        this.rollNo=b;
        this.age=c;
        this.gender=d;
        this.course=e;
        this.semester=f;
        this.GPA=g;
    }
    String getname(){
        return name;
    }
    String getrollNo(){
        return rollNo;
    }
    int getage(){
        return age;
    }
    char getgender(){
        return gender;
    }
    String getcourse(){
        return course;
    }
    int getsemester(){
        return semester;
    }
    double getGPA(){
        return GPA;
    }
}
public class IPA250 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Student[] arr=new Student[4];
        for(int i=0;i<arr.length;i++){
            String a=sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            char d=sc.nextLine().charAt(0);
            String e=sc.nextLine();
            int f=sc.nextInt();
            sc.nextLine();
            double g=sc.nextDouble();
            sc.nextLine();
            arr[i]=new Student(a, b, c, d, e, f, g); 
        }
        String course=sc.nextLine();
        double ans1=calculateAverageGPA(arr);
        if(ans1>0){
            System.out.println(ans1);
        }else{
            System.out.println("Sorry - No students are available");
        }
        Student[] ans2=getStudentsByCourse(arr, course);
        if(ans2!=null){
            for(int i=0;i<ans2.length;i++){
                System.out.println(ans2[i].getname());
                System.out.println(ans2[i].getrollNo());
                System.out.println(ans2[i].getGPA());
            }
        }else{
            System.out.println("Sorry - No students are available for the given course");
        }
    }
    public static double calculateAverageGPA(Student[] arr){
        if(arr.length==0){
            return 0;
        }
        double sum=0;
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i].getGPA();
            cnt++;
        }
        return sum/cnt;
    }
    public static Student[] getStudentsByCourse(Student[] arr,String course){
        Student[] ans=new Student[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getcourse().equalsIgnoreCase(course)){
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
 * Create a class Student with the following attributes:

name - String
rollNo - String
age - int
gender - char ('M' for male and 'F' for female)
course - String
semester - int
GPA - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Solution with the main method.

Implement two static methods - calculateAverageGPA and getStudentsByCourse in Solution class.

calculateAverageGPA method:
This method will take an array of Student objects as input.
The method will return the average GPA of all the students in the array.
If the array is empty, the method should return 0.

getStudentsByCourse method:
This method will take two input parameters - array of Student objects and a course (string).
The method will return an array of Student objects that are enrolled in the specified course.
If no student with the given course is present in the array of Student objects, then the method should return an empty array.

These above mentioned static methods should be called from the main method.

For calculateAverageGPA method - The main method should print the average GPA returned by the method.
If the returned value is 0, then it should print "Sorry - No students are available".

For getStudentsByCourse method - The main method should print the name, roll number and GPA of the returned Student objects.
If the returned value is an empty array, then it should print "Sorry - No students are available for the given course".

Before calling these static methods in main, use Scanner object to read the values of four Student objects referring 
attributes in the above mentioned attribute sequence. Next, read the value for a course.

Example Input:
------------------------
John
1234
20
M
CSE
2
3.5
Alice
5678
19
F
EEE
1
3.7
Bob
9101
21
M
CSE
4
3.9
Sarah
2345
20
F
ME
3
3.2
CSE

Example Output:
---------------------------
3.6
John
1234
3.5
Bob
9101
3.9
 */