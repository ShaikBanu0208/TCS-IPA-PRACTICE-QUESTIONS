import java.util.*;
class Document{
    int id;
    String title;
    String folderName;
    int pages;
    Document(int a,String b,String c,int d){
        this.id=a;
        this.title=b;
        this.folderName=c;
        this.pages=d;
    }
    int getid(){
        return id;
    }
    String gettitle(){
        return title;
    }
    String getfolderName(){
        return folderName;
    }
    int getpages(){
        return pages;
    }
}
class IPA237{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Document[] arr=new Document[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            arr[i]=new Document(a,b,c,d);
        }
        Document[] ans=docsWithOddPages(arr);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i].getid()+" "+ans[i].gettitle()+" "+ans[i].getfolderName()+" "+ans[i].getpages());
        }
    }
    public static Document[] docsWithOddPages(Document[] arr){
        Document[] ans=new Document[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getpages()%2==1){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        for(int i=0;i<ans.length;i++){
            for(int j=i+1;j<ans.length;j++){
                if(ans[i].getid()>ans[j].getid()){
                    Document temp=ans[i];
                    ans[i]=ans[j];
                    ans[j]=temp;
                }
            }
        }
        if(ans.length>0){
            return ans;
        }
        return null;
    }
}
/*
 * 
Create class Document with below attributes

id - int
title - String
folderName - String
pages - int

Write getters, setters and parameterized constructor as required. 

Create class Solution with main method. 

Implement static method - docsWithOddPages in Solution class.

This method will take array of Document objects and return another array with Document objects which has odd number of pages. 

This method should be called from main method and display values of returned objects as shared in the sample (in ascending 
order of id attribute). 

Before calling this method, use Scanner object to read values for four Document objects referring attributes in the above 
sequence. 

Next call the method and display the result. 

Consider below sample input and output:

Input:
1
resume
personal
50
2
question1
exams
55
3
question2
exams
45
4
India
misc
40


Output (each line has values separated by single space):
2 question1 exams 55
3 question2 exams 45



Note on using Scanner object:
Sometimes scanner does not read the new line character while invoking methods like nextInt(), nextDouble() etc. 
Usually, this is not an issue, but this may be visible while calling nextLine() immediately after those methods.

Consider below input values:
22
hello

Referring below code:

Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
String str = sc.nextLine(); -> here we expect str to have value hello. Instead it may be """".

If above issue is observed, then it is suggested to add one more explicit call to nextLine() after reading numeric value.

 */