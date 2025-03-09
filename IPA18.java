/*
 * Enter a string and print all the vowels as it is which is available on string in the 0 index
 * input:Hello I am a Student
 * output:Iaa
 */
import java.util.*;
class IPA18{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String[] words=input.split(" ");
        for(int i=0;i<words.length;i++){
            char ch=words[i].charAt(0);
            if(ch=='a' || ch=='A' || ch=='e' || ch=='E' || ch=='i' || ch=='I' || ch=='o' || ch=='O' || ch=='u' || ch=='U'){
                System.out.print(ch);
            }
        }
    }
}