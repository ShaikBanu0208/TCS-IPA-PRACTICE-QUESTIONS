import java.util.*;
class Song{
    private int songId;
    private String title;
    private String artist;
    private double duration;
    Song(int a,String b,String c,double d){
        this.songId=a;
        this.title=b;
        this.artist=c;
        this.duration=d;
    }
    int getsongId(){
        return songId;
    }
    String gettitle(){
        return title;
    }
    String getartist(){
        return artist;
    }
    double getduration(){
        return duration;
    }
}
class IPA244{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Song[] arr=new Song[5];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            arr[i]=new Song(a,b,c,d);
        }
        String title=sc.nextLine();
        String artist=sc.nextLine();
        double ans1=findSongDurationForArtist(arr,artist);
        if(ans1!=0){
            System.out.println(ans1);
        }else{
            System.out.println("There are no songs with given artist");
        }
        Song[] ans2=getSongsInAscendingOrder(arr,artist);
        if(ans2!=null){
        for(int i=0;i<ans2.length;i++){
            System.out.println(ans2[i].getsongId());
            System.out.println(ans2[i].gettitle());
        }
        }else{
            System.out.println("There are no songs with given artist");
        }
    }
    public static double findSongDurationForArtist(Song[] arr,String artist){
        double sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getartist().equalsIgnoreCase(artist)){
                sum=sum+arr[i].getduration();
            }
        }
        return sum;
    }
    public static Song[] getSongsInAscendingOrder(Song[] arr,String artist){
        Song[] ans=new Song[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getartist().equalsIgnoreCase(artist)){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        //sort
        for(int i=0;i<ans.length-1;i++){
            for(int j=i+1;j<ans.length;j++){
                if(ans[i].getduration()>ans[j].getduration()){
                    Song temp=ans[i];
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
 * create the class Song with below attributes.

songId - int 
title - String
artist -  String
duration-double

The above attributes should be private, getters, setters and parameterized constructor as required. 

Create class MyClass with main method. Implement two static methods - findSongDurationForArtist and
getSongsInAscendingOrder in MyClass class.

findSongDurationForArtist method: 
----------------------------------------------------
This method will take two input parameters of Song objects and String parameter.
The method will return the sum of song duration from array of Song object for the given artist (String parameter passed).

If no Song with the given artist is present in the array of Song objects, then the method should return zero.

getSongsInAscendingOrder method: 
----------------------------------------------------
This method will take input parameters array, of Song objects and String parameter.The method will return Song objects array 
in an ascending order of their duration, from the array of Song objects whose artist attribute matches with the input String 
parameter. 

If no Song with the given artist is present in the array of Song objects, then the method should return null.

Note: 
----------
1. No two Song object would have the same songid.
2. Combination of artist and duration should be unique.
3. All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For getfindSongDuration ForArtist method - in method should print the sum of duration of artist as it is, if the returned 
value is greater than 0 or it should print "There are no songs with given artist".

For getSongsinAscendingOrder method - The main method should print the song id and title from the returned song object array 
if the returned value is not null. If the returned value is null then it should print "There are no songs with given artist".


For Example,

112
ABC

where 112 is song ld. ABC is song title.

Before calling these static methods in main, use. Scanner object to read the values of five Song objects referring attributes 
in the above mentioned attribute sequence. Next, read two String values for capturing artists.

*****************************************************************



Sample Input 1: 
------------------

2150
In time
Justin Timberlake
4
250
Cry Me
Justin Timberlake
3
1200
Mirrors
Justin Timberlake
5
1300
That's the way it is
celion dion
5
500
Ashes
celion dion
3
celion dion
Justin Timberlake


Sample output1:
------------------------

12.0
250
Cry Me
2150
In time
1200
Mirrors



Sample Input 2:
----------------------

2150
Cry Me
Justin Timberlake
3
1000
Why Not
Enrique Iglesius
5
1200
Mirrors
Justin Timberlake
5
1300
That's the way it is
Celion Dion
5
500
Ashes
celion Dion
3
Bryan Adams
Michael Larkson


Output 2:
-----------------------

There are no songs with given artist
There are no songs with given artist
 */