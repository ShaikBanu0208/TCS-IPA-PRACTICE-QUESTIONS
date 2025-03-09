import java.util.*;
class Flowers{
    private int flowerId;
    private String flowerName;
    private int price;
    private int rating;
    private String type;
    Flowers(int a,String b,int c,int d,String e){
        this.flowerId=a;
        this.flowerName=b;
        this.price=c;
        this.rating=d;
        this.type=e;
    }
    int getflowerId(){
        return flowerId;
    }
    String getflowerName(){
        return flowerName;
    }
    int getprice(){
        return price;
    }
    int getrating(){
        return rating;
    }
    String gettype(){
        return type;
    }
}
class IPA226{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Flowers[] arr=new Flowers[4];
        for(int i=0;i<arr.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();
            String e=sc.nextLine();
            arr[i]=new Flowers(a,b,c,d,e);
        }
        String type=sc.nextLine();
        Flowers[] ans1=findMinPriceByType(arr, type);
        if(ans1==null){
            System.out.println("There is no flower with given type");
        }else{
            System.out.println(ans1[0].getflowerId());
        }
    }
    public static Flowers[] findMinPriceByType(Flowers[] flower,String type){
        Flowers[] ans=new Flowers[flower.length];
        int cnt=0;
        for(int i=0;i<flower.length;i++){
            if(flower[i].gettype().equalsIgnoreCase(type) && flower[i].getrating()>3){
                ans[cnt++]=flower[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        if(ans.length==1){
            return ans;
        }else if(ans.length>1){
            for(int i=0;i<ans.length;i++){
                for(int j=i+1;j<ans.length;j++){
                    if(ans[i].getprice()>ans[j].getprice()){
                        Flowers temp=ans[i];
                        ans[i]=ans[j];
                        ans[j]=temp;
                    }
                }
            }
            return ans;
        }else{
            return null;
        }
    }
}
/*
 *  Create the class Flowers with below attribute:

flowerId-int;
flowerName-String;
price-int;
rating-int;
type-String;

The above attributes must be private,write getters and setters and parametrized constructor as well.

Create class MyClass with main method.

Implement one static method:findMinPriceByType in MyClass class.

findMinPriceByType Method:

This method will take two input parameters:Array of Flower objects and String parameter.This method will return the minimum 
priced flower object from  array of Flower objects for the given type(String parameter),only if the rating is greater than 
3. If no Flowers with the above conditions are present in the array of the flower objects,then the method will return null.

For this method-The main method  should print the flowerId from the returned object if the returned value is not null.
else it should print "There is no flower with given type".

**********************************************************************

input1:

123
Yellow trout lilly
3000
5
ephemerals
345
snowdrop
2500
4
ephemerals
321
Yarrow
1000
4
perennials
213
red trillium
2250
4
ephemerals
ephemerals



output:

213





**********************

input2:

123

Yellow trout lilly

3000

5

ephemerals

345

snowdrop

2500

4

ephemerals

321

Yarrow

1000

4

perennials

213

red trillium

2250

4

ephemerals

Biennial


output2
There is no flower with given type.
 */