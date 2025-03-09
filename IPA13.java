/* find number lower letters in a string
 * input:DataBaSe
 * o/p-5
 */
import java.util.*;
 class IPA13{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        int cnt=0;
        for(char ch:input.toCharArray()){
            if(ch>='a' && ch<='z'){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}