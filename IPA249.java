import java.util.*;
class Person{
    String firstName;
    String lastName;
    int age;
    char gender;
    Person(String a,String b,int c,char d){
        this.firstName=a;
        this.lastName=b;
        this.age=c;
        this.gender=d;
    }
    String getfirstName(){
        return firstName;
    }
    String getlastName(){
        return lastName;
    }
    int getage(){
        return age;
    }
    char getgender(){
        return gender;
    }
}
class Student extends Person{
    String rollNo;
    String course;
    int semester;
    double GPA;
    Student(String p,String q,int r,char s,String a,String b,int c,double d){
        super(p,q,r,s);
        this.rollNo=a;
        this.course=b;
        this.semester=c;
        this.GPA=d;
    }
    String getrollNo(){
        return rollNo;
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
class Faculty extends Person{
    String employeeId;
    String department;
    String designation;
    double salary;
    Faculty(String p,String q,int r,char s,String a,String b,String c,double d){
        super(p,q,r,s);
        this.employeeId=a;
        this.department=b;
        this.designation=c;
        this.salary=d;
    }
    String getemployeeId(){
        return employeeId;
    }
    String getdepartment(){
        return department;
    }
    String getdesignation(){
        return department;
    }
    double getsalary(){
        return salary;
    }
}
public class IPA249 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Student[] student=new Student[2];
        Faculty[] faculty=new Faculty[2];
        //student
        for(int i=0;i<student.length;i++){
            String a=sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            char d=sc.nextLine().charAt(0);
            String e=sc.nextLine();
            String f=sc.nextLine();
            int g=sc.nextInt();
            sc.nextLine();
            double h=sc.nextDouble();
            sc.nextLine();
            student[i]=new Student(a,b,c,d,e,f,g,h);
        }
        //Faculty
        for(int i=0;i<faculty.length;i++){
            String a=sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            char d=sc.nextLine().charAt(0);
            String e=sc.nextLine();
            String f=sc.nextLine();
            String g=sc.nextLine();
            double h=sc.nextDouble();
            sc.nextLine();
            faculty[i]=new Faculty(a,b,c,d,e,f,g,h);
        }
        Student ans1=findHighestGPAStudent(student);
        if(ans1!=null){
            System.out.println(ans1.getrollNo());
            System.out.println(ans1.getcourse());
            System.out.println(ans1.getGPA());
        }else{
            System.out.println("Sorry - No student is available");
        }
        Faculty ans2=findHighestPaidFaculty(faculty);
        if(ans2!=null){
            System.out.println(ans2.getemployeeId());
            System.out.println(ans2.getdepartment());
            System.out.println(ans2.getsalary());
        }else{
            System.out.println("Sorry - No faculty is available");
        }
    }
    public static Student findHighestGPAStudent(Student[] arr){
        Student ans=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i].getGPA()>ans.getGPA()){
                ans=arr[i];
            }
        }
        if(ans!=null){
            return ans;
        }
        return null;
    }
    public static Faculty findHighestPaidFaculty(Faculty[] arr){
        Faculty ans=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i].getsalary()>ans.getsalary()){
                ans=arr[i];
            }
        }
        if(ans!=null){
            return ans;
        }
        return null;
    }
}
/*
 * 
Create a class Person with the following attributes:

firstName - String
lastName - String
age - int
gender - char ('M' for male and 'F' for female)

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Student that extends the Person class and adds the following attributes:

rollNo - String
course - String
semester - int
GPA - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Faculty that extends the Person class and adds the following attributes:

employeeId - String
department - String
designation - String
salary - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Solution with the main method.

Implement two static methods - findHighestGPAStudent and findHighestPaidFaculty in Solution class.

findHighestGPAStudent method:
This method will take an array of Student objects as input.
The method will return the Student object with the highest GPA.
If the array is empty, the method should return null.

findHighestPaidFaculty method:
This method will take an array of Faculty objects as input.
The method will return the Faculty object with the highest salary.
If the array is empty, the method should return null.

These above mentioned static methods should be called from the main method.

For findHighestGPAStudent method - The main method should print the roll number, course and GPA of the returned Student object.
If the returned value is null then it should print "Sorry - No student is available".

For findHighestPaidFaculty method - The main method should print the employee ID, department and salary of the returned 
Faculty object.
If the returned value is null then it should print "Sorry - No faculty is available".

Before calling these static methods in main, use Scanner object to read the values of two Student objects and two Faculty 
objects referring attributes in the above mentioned attribute sequence.

Example Input:

First1
Last1
20
M
Roll1
Course1
2
3.8
First2
Last2
21
F
Roll2
Course2
3
3.9
Faculty1
Last3
35
M
ID1
Department1
Associate Professor
90000.0
Faculty2
Last4
40
F
ID2
Department2
Professor
100000.0

Output:

Roll2
Course2
3.9
ID2
Department2
100000.0

 */