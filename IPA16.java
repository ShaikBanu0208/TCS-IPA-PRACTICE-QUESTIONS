/*To print last character of every word of a string
 * Input:Hey3 Java Learners
 * output:as
 * Ignore digits and white spaces
 */
import java.util.*;
 class IPA16{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String[] words=input.split(" ");
        for(int i=0;i<words.length;i++){
            char ch=words[i].charAt(words[i].length()-1);
            if(!Character.isDigit(ch)){
            System.out.print(ch);
            }
        }
    }
}