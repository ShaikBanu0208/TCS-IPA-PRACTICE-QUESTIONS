/*
 * count number of vowels and consonants in a string
 * input:Welcome123
 * output:Number of vowels:3
 *        Number of consonants:4
 */
import java.util.*;
 class IPA113{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int v_count=0,c_count=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' || ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                v_count++;
            }else if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z' )){
                c_count++;
            }
        }
        System.out.println("Number of vowels:"+v_count);
        System.out.println("Number of constants:"+c_count);
    }
}