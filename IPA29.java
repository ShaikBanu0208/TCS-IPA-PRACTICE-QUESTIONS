import java.util.*;
class Student{
    private int rollNo;
    private String name;
    private String branch;
    private double score;
    private boolean dayScholar;
    Student(int a,String b,String c,double d,boolean e){
        this.rollNo=a;
        this.name=b;
        this.branch=c;
        this.score=d;
        this.dayScholar=e;
    }
    int getrollNo(){
        return rollNo;
    }
    String getname(){
        return name;
    }
    String getbranch(){
        return branch;
    }
    double getscore(){
        return score;
    }
    boolean getdayScholar(){
        return dayScholar;
    }
}
class IPA29{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Student[] arr=new Student[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            boolean e=sc.nextBoolean();
            sc.nextLine();
            arr[i]=new Student(a,b,c,d,e);
        }
        int ans1=findCountOfDayscholarStudents(arr);
        if(ans1>0){
            System.out.println(ans1);
        }else{
            System.out.println("There are no such dayscholar students");
        }
        Student ans2=findStudentwithSecondHighestScore(arr);
        if(ans2!=null){
            System.out.println(ans2.getrollNo()+"#"+ans2.getname()+"#"+ans2.getscore());
        }else{
            System.out.println("There are no student from non day scholar");
        }
    }
    public static int findCountOfDayscholarStudents(Student[] arr){
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getscore()>80 && arr[i].getdayScholar()==true){
                cnt++;
            }
        }
        return cnt;
    }
    public static Student findStudentwithSecondHighestScore(Student[] arr){
        double[] ans=new double[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i].getdayScholar()==false){
                ans=Arrays.copyOf(ans,ans.length+1);
                ans[ans.length-1]=arr[i].getscore();
            }
        }
        Arrays.sort(ans);
        double shs=ans[ans.length-2];
        for(int i=0;i<arr.length;i++){
            if(arr[i].getscore()==shs){
                return arr[i];
            }
        }
        return null;
    }
}
/*
 * Create a class called Student with the below attributes:

rollNo - int
name - String
branch - String
score - double
dayScholar - boolean

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods -findCountOfDayscholarStudents  and findStudentwithSecondHighestScore in Solution 
class.

findCountOfDayscholarStudents:

This method will take an array of Student objects as an input parameter . This method will calculate and return 
the count of Students whose score is greater than 80 and who are all from dayScholar.

If no Student scored greater than 80 and from dayScholar are present in the array of Student objects, then the
method should return 0.

findStudentwithSecondHighestScore:

This method will take an array of Student objects as an input parameter. This method will return the object 
of the second highest score student from the array of Student objects who are not from the dayScholar.

If no Student is a dayScholar  in the array of Student objects, then the method should return null.

Note : All the searches should be case insensitive.

The combination of dayScholar and score for each student is always unique.

The above mentioned static methods should be called from the main method.

For findCountOfDayscholarStudents method - The main method should print the returned count as it is 
if the returned value is greater than 0, else it should print "There are no such dayscholar students".

For findStudentwithSecondHighestScore method - The main method should print the rollNo, name and score 
in the below format from the returned object if the retuned value is not null.

rollNo#name#score

If the returned value is null, then it should print ”There are no student from non day scholar”

Before calling these static methods in main, use Scanner object to read the values of four Student 
objects referring attributes in the above mentioned attribute sequence. 
Consider below sample input and output:

Input:

1001
Ashwa
IT
85
true
1002
Preeti
IT
70
false
1003
Uma
ECE
85
false
1004
Akash
EEE
90
true


Output:
2
1002#Preeti#70.0
 */