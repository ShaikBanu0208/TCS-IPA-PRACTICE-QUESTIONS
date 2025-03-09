/*
 * Remove duplicates from a string
 * Input:experience
 * outout:experinc
 */
import java.util.*;
 class IPA14{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String temp="";
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(temp.indexOf(ch)==-1){
                temp+=ch;
            }
        }
        System.out.println(temp);
    }
}