import java.util.*;
class Employee{
    private int employeeId;
    private String name;
    private String branch;
    private double rating;
    private boolean companyTransport;
    Employee(int a,String b,String c,double d,boolean e){
        this.employeeId=a;
        this.name=b;
        this.branch=c;
        this.rating=d;
        this.companyTransport=e;
    }
    int getemployeeId(){
        return employeeId;
    }
    String getname(){
        return name;
    }
    String getbranch(){
        return branch;
    }
    double getrating(){
        return rating;
    }
    boolean getcompanyTransport(){
        return companyTransport;
    }
}
class IPA217{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Employee[] arr=new Employee[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            boolean e=sc.nextBoolean();
            arr[i]=new Employee(a,b,c,d,e);
        }
        sc.nextLine();
        String branch=sc.nextLine();
        int ans1=findCountOfEmployeesUsingCompTransport(arr,branch);
        if(ans1>0){
            System.out.println(ans1);
        }else{
            System.out.println("No such Employees");
        }
        Employee[] ans2=findEmployeeWithSecondHighestRating(arr);
        if(ans2!=null){
            if(ans2[0].getrating()>ans2[1].getrating()){
                System.out.println(ans2[1].getemployeeId());
                System.out.println(ans2[1].getname());
            }
        }else{
            System.out.println("All Employees using company transport");
        }
    }
    public static int findCountOfEmployeesUsingCompTransport(Employee[] arr,String branch){
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getbranch().equalsIgnoreCase(branch)){
                cnt++;
            }
        }
        return cnt;
    }
    public static Employee[] findEmployeeWithSecondHighestRating(Employee arr[]){
        Employee[] ans=new Employee[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getcompanyTransport()==false){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        for(int i=0;i<ans.length;i++){
            for(int j=i+1;j<ans.length;j++){
                if(ans[i].getrating()<ans[j].getrating()){
                    Employee temp=ans[i];
                    ans[i]=ans[j];
                    ans[j]=temp;
                }
            }
        }
        if(ans.length>0){
            return ans;
        }else{
            return null;
        }
    }
}
/*
 * Create a class called Employee with the below attributes:

employeeld - int
name - String
branch - String
rating - double
company Transport - boolean
The above attributes should be private. write getters, setters and parameterized constructor as required.

Create class MyClass with main method.
Implement two static methods findCountOfEmployeesUsingCompTransport and findEmployeeWithSecondHighestRating
in MyClass class.

findCountOfEmployeesUsingCompTransport method: 
----------------------------------------------
This method will take an array of Employee object and a String parameter as input parameters. 
This method will calculate and return the count of Employees who are all using company transport 
in the given branch (String parameter passed).
If no Employee in the given branch using company transport in the array of Employee objects, then 
the method should return 0.

findEmployeeWithSecondHighestRating method: 
--------------------------------------------
This method will take an array of Employee objects as an input parameter. This method will return 
the object of the second highest rating employee from the array of Employee objects who are not using 
company transport.
If all Employees using company transport in the array of Employee objects, then the method should return null.

Note: All the searches should be case sensitive, companyTransport and rating combination of each Employee 
is unique.
For findCountOfEmployeesUsingCompTransport method, The main method should print the returned count as it 
is if the returned value is greater than 0, else it should print "No such Employees".
Ex: 2 , where 2 is the count
For findEmployeeWithSecondHighestRating method: The main method should print the employeeld and name from 
the returned object if the returned value is not null. If the returned value is null, then it should 
print "All Employees using company transport".
Ex: 1003
    Uma
where 1003 is the employeeld and Uma is the name.
Before calling these static methods in main, use Scanner object to read the values of four Employee 
objects referring attributes in the above mentioned attributes sequence. Next, read the value of String
parameter for capturing branch.

Input : 

1001
Ashwa
IT
5
true
1002
Preeti
IT
4
true
1003
Uma
Admin
3
false
1004
Akash
Hardware
4.5
false
IT



Output : 

2
1003
Uma
 */