/*Print characters at odd positions
 * input:Management
 * output:aaeet
 */
import java.util.*;
 class IPA19{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        for(int i=0;i<input.length();i++){
            if(i%2==1){
                System.out.print(input.charAt(i));
            }
        }
    }
}