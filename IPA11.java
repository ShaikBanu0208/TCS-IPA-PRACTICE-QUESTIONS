import java.util.*;
class IPA11{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[5];
        for(int i=0;i<5;i++){
            arr[i]=sc.nextInt();
        }
        int limit1=sc.nextInt();
        int limit2=sc.nextInt();
        int sum=0,cnt=0;
        for(int i:arr){
            if(i>limit1 && i<limit2){
                sum+=i;
                cnt++;
            }
        }
        System.out.println(sum/cnt);
    }
}