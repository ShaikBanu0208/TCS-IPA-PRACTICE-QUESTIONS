/*
 * check three even digits or not for given input-If yes return true,Otherwise false
 */
import java.util.*;
 public class IPA114 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int cnt=0;
        for(int i=0;i<str.length();i++){
            int a=Integer.parseInt(String.valueOf(str.charAt(i)));
            if(a%2==0){
                cnt++;
            }
        }
        if(cnt>=3){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
    }
}
