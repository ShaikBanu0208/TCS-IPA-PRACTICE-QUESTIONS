import java.util.*;
class Course{
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;

    Course(int a,String b,String c,int d,int e){
        this.courseId=a;
        this.courseName=b;
        this.courseAdmin=c;
        this.quiz=d;
        this.handson=e;
    }
    int getcourseId(){
        return courseId;
    }
    String getcourseName(){
        return courseName;
    }
    String getcourseAdmin(){
        return courseAdmin;
    }
    int getquiz(){
        return quiz;
    }
    int gethandson(){
        return handson;
    }
}
class IPA1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Course[] arr=new Course[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            int e=sc.nextInt();
            sc.nextLine();
            arr[i]=new Course(a,b,c,d,e);
        }
        String name=sc.nextLine();
        int value=sc.nextInt();
        sc.nextLine();
        int avgQuiz=findAvgOfQuizByAdmin(arr, name);
        if(avgQuiz!=0){
            System.out.println(avgQuiz);
        }else{
            System.err.println("No Course found.");
        }
        Course[] res=sortCourseByHandsOn(arr, value);
        if(res!=null){
            for(int i=0;i<res.length;i++){
                System.out.println(res[i].getcourseName());
            }
        }else{
            System.out.println("No Course found with mentioned attribute.");
        }
    }
    public static int findAvgOfQuizByAdmin(Course[] arr,String admin){
        int sum=0,cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getcourseAdmin().equalsIgnoreCase(admin)){
                sum=sum+arr[i].getquiz();
                cnt++;
            }
        }
        if(cnt>0){
            int ans=sum/cnt;
            return ans;
        }else{
            return 0;
        }
    }
    public static Course[] sortCourseByHandsOn(Course[] arr,int value){
        // Course[] ans=new Course[arr.length];
        // int count=0;
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i].gethandson()<=value){
        //         ans[count++]=arr[i];
        //     }
        // }
        // ans=Arrays.copyOf(ans,count);
        // if(ans.length>0){
        //     return ans;
        // }else{
        //     return null;
        // }
        List<Course> list = new ArrayList<>();
        for (Course course : arr) {
            if (course.gethandson() <= value) {
                list.add(course);
            }
        }
        if (list.isEmpty()) {
            return null;
        }

        // Sorting using Comparator
        list.sort(Comparator.comparingInt(Course::gethandson));

        return list.toArray(new Course[0]);
    }
}
/*create the class Course with the below Attributes.

courseId- int
courseName- String
courseAdmin- String
quiz- int
handson -int

The above methods should be private ,write getter and
setter and parametrized constructor as required.

create class courseProgram with main method.

implement two static methods-
   findAvgOfQuizByAdmin method:this method will take array
of Course objects and a String  value as input parameters.
This method will find out Average (as int) of Quiz questions
for given Course Admin (String parametre passed)
This method will return Average if found.if there is no course
that matches then the method should return 0.

sortCourseByHandsOn method:
This method will take an Array of Course Objects and int
value as input parameters.
This methods should return an Array of Course objects in an
ascending order of their  handson which are less than the
given handson(int parameter passed) value. if there is no
such course then the method should return null.

The above mentioned static methods should be called from
main methods.

for findAvgOfQuizByAdmin method: The main method
should print the average if the returned value is not 0.
if the returned value is 0 then it should print "No Course
found."


for sortCourseByHandsOn method:
                        the  main method should print the name
of the Course from the returned Course object Array if the
returned value is not null.if the returned value is null then
it should print "No Course found with mentioned attribute."

input1:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Nisha
17

output1:
35
kubernetes
Apache Spark
cassandra

input2:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Shubhamk
5

output 2:
No Course found
No Course found with mentioned attributes.*/
