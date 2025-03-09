/*
 * Take a integer as input and calculate the sum of digit
 * if sum is divisible by 3 print true Otherwise false
 * 
 * input:123
 * output:true
 * 
 * input:1234
 * output:false
 */
import java.util.*;
 class IPA110{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        while(n>0){
            int r=n%10;
            sum+=r;
            n=n/10;
        }
        if(sum%3==0){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}