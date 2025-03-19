import java.util.*;
class Employee{
    String name;
    int age;
    double salary;
    Employee(String a,int b,double c){
        this.name=a;
        this.age=b;
        this.salary=c;
    }
    String getname(){
        return name;
    }
    int getage(){
        return age;
    }
    double getsalary(){
        return salary;
    }
}
public class IPA252 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        int b=sc.nextInt();
        sc.nextLine();
        double c=sc.nextDouble();
        sc.nextLine();
        Employee arr=new Employee(a, b, c);
        double ans1=calculateYearlySalary(arr);
        double ans2=calculateTax(arr);
        if(ans1!=0 && ans2!=0){
            System.out.println("Yearly salary of "+arr.getname()+":"+ans1);
            System.out.println("Tax to be paid by "+arr.getname()+":"+ans2);
        }
    }
    public static double calculateYearlySalary(Employee arr){
        double total=arr.getsalary()*12;
        return total;
    }
    public static double calculateTax(Employee arr){
        double yearsalary=calculateYearlySalary(arr);
        double tax=0;
        if(yearsalary>0){
            if(yearsalary<=50000){
                tax=yearsalary*0.10;
            }else if(yearsalary>50000 && yearsalary<=100000){
                tax=50000*0.10+(yearsalary-50000)*0.20;
            }else{
                tax=50000*0.10+50000*0.20+(yearsalary-100000)*0.30;
            }
        }
        return tax;
    }
}
/*
 * 
Create a class Employee with the following attributes:

name (string)
age (int)
salary (double)
Write getters, setters, and a parameterized constructor in the above-mentioned attribute sequence as required.

Create a class Solution with the main method.

Implement two static methods - calculateYearlySalary and calculateTax in the Solution class.

calculateYearlySalary method:
-----------------------------------------
This method will take an Employee object as input.
The method will calculate the yearly salary of the employee (assuming that the employee works for 12 months in a year) and 
return it as a double.

calculateTax method:
-----------------------------------------
This method will take an Employee object as input.
The method will calculate the tax to be paid by the employee based on the following rules:

If the yearly salary is less than or equal to 50000, the tax is 10% of the yearly salary.
If the yearly salary is greater than 50000 but less than or equal to 100000, the tax is 20% of the amount over 50000 plus 10% 
of the first 50000.
If the yearly salary is greater than 100000, the tax is 30% of the amount over 100000 plus 20% of the amount between 50000 and 
100000 plus 10% of the first 50000.
The method will return the tax amount as a double.
These above-mentioned static methods should be called from the main method.

For calculateYearlySalary method - The main method should print the yearly salary returned by the method.

For calculateTax method - The main method should print the tax amount returned by the method.

Before calling these static methods in main, use a Scanner object to read the values of an Employee object's attributes.

Example Input:
----------------
John
30
55000.0

Example Output:
----------------
Yearly salary of John: 660000.0
Tax to be paid by John: 183000.0

 */