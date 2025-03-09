import java.util.*;
import java.lang.*;
class Student{
	private int rollNo;
	private String name;
	private String subject;
	private char grade;
	private String date;
	Student(int a,String b,String c,char d,String e){
		this.rollNo=a;
		this.name=b;
		this.subject=c;
		this.grade=d;
		this.date=e;
	}
	int getrollNo(){
		return rollNo;
	}
	String getname(){
		return name;
	}
	String getsubject(){
		return subject;
	}
	char getgrade(){
		return grade;
	}
	String getdate(){
		return date;
	}
}
class IPA224{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Student[] arr=new Student[4];
		for(int i=0;i<arr.length;i++){
			int a=sc.nextInt();
			sc.nextLine();
			String b=sc.nextLine();
			String c=sc.nextLine();
			char d=sc.nextLine().charAt(0);
			String e=sc.nextLine();
			arr[i]=new Student(a,b,c,d,e);
		}
		char grade=sc.nextLine().charAt(0);
		int month=sc.nextInt();
		sc.nextLine();
		Student[] ans1=findStudentByGradeAndMonth(arr, grade, month);
		if(ans1!=null){
			for(int i=0;i<ans1.length;i++){
				System.out.println(ans1[i].getname());
				System.out.println(ans1[i].getsubject());
			}
			System.out.println(ans1.length);
		}else{
			System.out.println("No student found");
		}
	}
	public static Student[] findStudentByGradeAndMonth(Student[] arr,char grade,int month){
		Student[] ans=new Student[arr.length];
		int cnt=0;
		for(int i=0;i<arr.length;i++){
			String[] a=arr[i].getdate().split("/");
			if(arr[i].getgrade()==grade && Integer.parseInt(a[1])==month){
				ans[cnt++]=arr[i];
			}
		}
		ans=Arrays.copyOf(ans,cnt);
		for(int i=0;i<ans.length;i++){
			for(int j=i+1;j<ans.length;j++){
				if(ans[i].getrollNo()>ans[j].getrollNo()){
					Student temp=ans[i];
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
 * Create a class Student with below attributes:

rollNo - int
name - String
subject - String
grade - char
date - String [DD/MM/YYYY]



The above attributes should be private.Write Getter and Setter and parametrized constructor as required.


Create class Solution with main method.
****************************************************************************
Implement one static method: findStudentByGradeAndMonth Solution Class.


findStudentByGradeAndMonth Method:

This method will take an array of Student objects, char value as grade and int value as month 
for input parameters.The method will find out all Students from the given grade and month. 
This method will return array of Student object assending based on their rollNo if found. 
If there is no Student that matches then the method should return null.

for this method- main method should print Student name, subject and total student found [The 
length of the list], if the returned value is not null. If the returned value is null then 
main method should print "No student found".


NOTE:
	1. For Taking char as input use sc.nextLine().charAt(0)
	2. To match/check the month You havee to convert int month in the parameter to String.
	3. No need to count the Student array if return not null just print the array length.


****************************************************************************



Consider the below input and output:


input1:

111
Arijit
Math
B
22/09/2023
101
Priyanka
English
A
30/03/2022
107
Shreosi
History
C
13/05/2022
105
Tatan
Physics
A
27/03/2022
A
3


output1:

Priyanka
English
Tatan
Physics
2





input2:

111
Sohel
Math
B
22/09/2022
101
Priyanka
English
A
30/03/2022
107
Gopa
History
C
12/05/2022
105
Kamal
Physics
A
27/03/2022
A
7



output 2:

No student found
 */