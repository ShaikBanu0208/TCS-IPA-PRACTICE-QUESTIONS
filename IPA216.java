import java.util.*;
class Employee{
    private int employeeId;
    private String employeeName;
    private int age;
    private char gender;
    private double salary;
    Employee(int a,String b,int c,char d,double e){
        this.employeeId=a;
        this.employeeName=b;
        this.age=c;
        this.gender=d;
        this.salary=e;
    }
    int getemployeeId(){
        return employeeId;
    }
    String getemployeeName(){
        return employeeName;
    }
    int getage(){
        return age;
    }
    char getgender(){
        return gender;
    }
    double getsalary(){
        return salary;
    }
}
class IPA216{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        Employee[] arr=new Employee[n];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            char d=sc.next().charAt(0);
            double e=sc.nextDouble();
            sc.nextLine();
            arr[i]=new Employee(a,b,c,d,e);
        }
        int age=sc.nextInt();
        Employee ans1=getEmployeeWithSecondLowestSalary(arr);
        if(ans1!=null){
            System.out.println(ans1.getemployeeId()+"#"+ans1.getemployeeName());
        }else{
            System.out.println("Null");
        }
        int ans2=countEmployeesBasedOnAge(arr, age);
        if(ans2!=0){
            System.out.println(ans2);
        }else{
            System.out.println("No employee found for the given age");
        }
    }
    public static Employee getEmployeeWithSecondLowestSalary(Employee[] arr){
        double first=Double.MAX_VALUE;
        double second=Double.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            double sal=arr[i].getsalary();
            if(sal<first){
                second=first;
                first=sal;
            }else if(first<sal && sal<second){
                second=sal;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i].getsalary()==second){
                return arr[i];
            }
        }
        return null;
    }
    public static int countEmployeesBasedOnAge(Employee[] arr,int age){
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getage()==age){
                cnt++;
            }
        }
        return cnt;
    }
}
/*
 * Create a class Employee with below attributes:

employeeId - int
employeeName - String
age - int
gender - char
salary - double

where employeeId is the unique identifier of the employee, employeeName is the name of the employee, age is the age of 
the employee, gender is the gender of the employee and salary is the salary of the employee.

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - getEmployeeWithSecondLowestSalary and countEmployeesBasedOnAge in Solution class.

getEmployeeWithSecondLowestSalary method:
This method will take an array of Employee objects as a parameter.
The method will return the Employee object with the second lowest salary in the array of Employee objects.
If there are less than two employees in the array, then the method should return null.

countEmployeesBasedOnAge method:
This method will take two input parameters - array of Employee objects and an integer parameter (for age).
The method will return the count of employees from the array of Employee objects whose age matches with the input 
parameter.
If no employee with the given age is present in the array of Employee objects, then the method should return 0.

Note :

Two employee objects can have the same salary.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For getEmployeeWithSecondLowestSalary method - The main method should print the employeeId followed by # and employeeName
from the returned Employee object, if the returned value is not null.

If the returned value is null then it should print "Null".

For countEmployeesBasedOnAge method - The main method should print the count of employees as it is, if the returned value
is greater than 0, otherwise it should print "No employee found for the given age".

Before calling these static methods in main, use Scanner to read the number of objects and objects to read the values of 
Employee objects referring attributes in the above mentioned attribute sequence.

Consider below sample input and output:

Input:
-------------
4
101
John
30
M
10000.00
102
Samantha
25
F
15000.00
103
Alex
28
M
12000.00
104
Lisa
30
F
15000.00
30

Output:
----------------
103#Alex
2
*/