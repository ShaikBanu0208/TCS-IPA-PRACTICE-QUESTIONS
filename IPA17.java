/*
 * Print number of spaces in a string
 * i/p-Hello What is your name
 * o/p-4
 * condition-If count is greater than or equals to 3 print the count else NA
 */
import java.util.*;
 class IPA17{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                count++;
            }
        }
        if(count>3){
            System.out.println(count);
        }else{
            System.out.println("NA");
        }
    }
}