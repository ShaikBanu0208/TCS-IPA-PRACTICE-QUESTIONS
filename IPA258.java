import java.util.*;
class Employee{
    int EmpId;
    String EmpName;
    String Dept;
    int Rating;
    int Salary;
    Employee(int a,String b,String c,int d,int e){
        this.EmpId=a;
        this.EmpName=b;
        this.Dept=c;
        this.Rating=d;
        this.Salary=e;
    }
    int getEmpId(){
        return EmpId;
    }
    String getEmpName(){
        return EmpName;
    }
    String getDept(){
        return Dept;
    }
    int getRating(){
        return Rating;
    }
    int getSalary(){
        return Salary;
    }
}
class IPA258{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Employee[] arr=new Employee[5];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            int e=sc.nextInt();
            sc.nextLine();
            arr[i]=new Employee(a, b, c, d, e);
        }
        int salary=sc.nextInt();
        sc.nextLine();
        String dept=sc.nextLine();
        String[] ans1=findDept(arr, salary);
        if(ans1!=null){
            String ans=Arrays.toString(ans1);
            String answer=ans.substring(1,ans.length()-1);
            System.out.println(answer);
        }else{
            System.out.println("No Department Found");
        }
        int ans2=findSecondHighestSalary(arr, dept);
        if(ans2!=0){
            System.out.println(ans2);
        }else{
            System.out.println("No data Found");
        }
    }
    public static String[] findDept(Employee[] arr,int salary){
        String[] ans=new String[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getSalary()==salary && arr[i].getRating()>=3){
                ans[cnt++]=arr[i].getDept();
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        if(ans.length>0){
            return ans;
        }
        return null;
    }
    public static int findSecondHighestSalary(Employee[] arr,String dept){
        int maxi=Integer.MIN_VALUE;
        int secmaxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getDept().equalsIgnoreCase(dept)){
                if(arr[i].getSalary()>maxi){
                    secmaxi=maxi;
                    maxi=arr[i].getSalary();
                }else if(arr[i].getSalary()<maxi && arr[i].getSalary()>secmaxi){
                    secmaxi=arr[i].getSalary();
                }
            }
        }
        if(secmaxi>0){
            return secmaxi;
        }
        return 0;
    }
}
/*
* Create a class Employee with the below attributes: 
EmpId - int 
EmpName - String 
Dept - String
Rating - int
Salary - int

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with the main method.

Implement two static methods - findDept and findSecondHighestSalary in Solution class.

findDept method: 
-----------------------------------
This method will take two input parameters - array of Employee objects and int parameter. The method 
will return the dept array attribute from employee objects whose salary is matched with int parameter and rating greater than
equal to 3. If no data found of beach objects, then the method should return null.

findSecondHighestSalary method: 
-----------------------------------
This method will take two input parameters - array of Employee objects and string parameter. The method
will return the second highest salary from employee objects whose dept is matched with string parameter. 
If no data found of beach objects, then the method should return 0.

Note: No two employees have same rating. All the searches should be case insensitive.

These above mentioned static methods should be called from the main method.
For findDept method - The main method should print the dept from the Employee array. If return null, then you should print 
"No Department found".
For findSecondHighestSalary method - The main method should print the 2nd highest salary from the Employee array with 
the following condition. If return 0, then you should print "No data found".


Input ->
101
Arijit
Computer
4
35000
102
Rakesh
Electronics
2
18000
103
Mahima
Mechanical
3
35000
104
Saniya
Mechanical
5
68000
105
Rajesh 
Computer
1
30000
35000
Mechanical

Output ->
Computer, Mechanical
35000
 */