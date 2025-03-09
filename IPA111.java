/* Find largest word in a sentence
 * input:TCS is the best company ever
 * ouput:company
 * if two words are same length return or print first one
 */
import java.util.*;
 class IPA111{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String[] words=input.split(" ");
        String largest="";
        for(String word:words){
            if(largest.length()<word.length()){
                largest=word;
            }
        }
        System.out.println(largest);
    }
}