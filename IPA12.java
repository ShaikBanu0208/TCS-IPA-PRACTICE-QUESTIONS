/*
Enter Input:Xplore
character Input:r
output:4
*/ 
import java.util.*;
public class IPA12{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        char ch=sc.next().charAt(0);
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==ch){
                System.out.println(i);
                break;
            }
        }
    }
}