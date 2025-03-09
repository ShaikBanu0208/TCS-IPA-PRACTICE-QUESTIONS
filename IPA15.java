/*Number of spaces and characters in a string
 * input:Hi I am a Student
 * output:4 13
 */
import java.util.*;
 class IPA15{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        int s_count=0,c_count=0;
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if((ch>='a' && ch<='z')||(ch>='A' && ch<='Z')){
                c_count++;
            }else{
                s_count++;
            }
        }
        System.out.println(s_count+" "+c_count);
    }
}