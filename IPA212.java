import java.util.*;
class RRT{
     private int ticketNo;
     private String raisedBy;
     private String assignedTo;
     private int priority;
     private String project;
     RRT(int a,String b,String c,int d,String e){
          this.ticketNo=a;
          this.raisedBy=b;
          this.assignedTo=c;
          this.priority=d;
          this.project=e;
     }
     int getticketNo(){
          return ticketNo;
     }
     String getraisedBy(){
          return raisedBy;
     }
     String getassignedTo(){
          return assignedTo;
     }
     int getpriority(){
          return priority;
     }
     String getproject(){
          return project;
     }
}
class IPA212{
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          RRT[] arr=new RRT[4];
          for(int i=0;i<arr.length;i++){
               int a=sc.nextInt();
               sc.nextLine();
               String b=sc.nextLine();
               String c=sc.nextLine();
               int d=sc.nextInt();
               sc.nextLine();
               String e=sc.nextLine();
               arr[i]=new RRT(a, b, c, d, e);
          }
          String project=sc.nextLine();
          RRT ans=getHighestPriorityTicket(arr, project);
          if(ans!=null){
              System.out.println(ans.getticketNo());
              System.out.println(ans.getraisedBy());
              System.out.println(ans.getassignedTo());
          }else{
               System.out.println("No ticket found");
          }
     }
     public static RRT getHighestPriorityTicket(RRT[] arr,String project){
          RRT[] ans=new RRT[0];
          for(int i=0;i<arr.length;i++){
               if(arr[i].getproject().equalsIgnoreCase(project)){
                    ans=Arrays.copyOf(ans,ans.length+1);
                    ans[ans.length-1]=arr[i];
               }
          }
          int maxi=Integer.MAX_VALUE;
          for(int i=0;i<ans.length;i++){
               maxi=Math.min(maxi,ans[i].getpriority());
          }
          for(int i=0;i<ans.length;i++){
               if(ans[i].getpriority()==maxi){
                    return ans[i];
               }
          }
          return null;
     }
}
/*
 * Create the class RRT(Rapid response team) with the below attributes:

ticketNo-int

raisedBy-String 

assignedTo-String

priority-int

project-String



All attributes should be private,write getters and setters and 

parameterized constructor as required.



Create class MyClass with main method.



Implement a static method-getHighestPriorityTicket in MyClass class.



getHighestPriorityTicket method:

     This method will take an array of RRT objects ,and a String value as parameters.This method will return the RRT object with highest priority
ticket from the array of the RRT objects for the given project(String parameter passed).Highest priority is the one which has lesser value.

for example:1 is considered as high priority and 5 is considered as low priority.

If no RRT with the above condition is present in the array of the RRT objects,then the method should return null.

The main method should print the ticketNo,raisedBy and assignedTo from returned object if the returned object is not null.if the returned object is null then main method should print "No such Ticket". 





input1:
----------------------
123
Velantish
Mani
3
Xperience
234
Sathish
Akshaya
1
AIG
345
John
Jack
2
AIG
456
Bhuvi
Jack
5
AIG
AIG


output1:
------------------
234
Sathish
Akshaya

**************

Input2:
--------------
123
Velantish
Mani
3
Xperience
234
Sathish
Akshaya
1
AIG
345
John
Jack
2
AIG
456
Bhuvi
Jack
5
AIG
Xplore


output2:
--------------
No such ticket.
 */