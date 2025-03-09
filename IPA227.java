import java.util.*;
class Engine{
    private int engineId;
    private String engineName;
    private String engineType;
    private double enginePrice;
    Engine(int a,String b,String c,double d){
        this.engineId=a;
        this.engineName=b;
        this.engineType=c;
        this.enginePrice=d;
    }
    int getengineId(){
        return engineId;
    }
    String getengineName(){
        return engineName;
    }
    String getengineType(){
        return engineType;
    }
    double getenginePrice(){
        return enginePrice;
    }
}
class IPA227{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Engine[] engine=new Engine[4];
        for(int i=0;i<engine.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            engine[i]=new Engine(a,b,c,d);
        }
        String type=sc.nextLine();
        String name=sc.nextLine();
        int ans1=findAvgEnginePriceByType(engine, type);
        if(ans1>0){
            System.out.println(ans1);
        }else{
            System.out.println("There are no engine with given type");
        }
        Engine[] ans2=searchEngineByName(engine, name);
        if(ans2!=null){
            for(int i=0;i<ans2.length;i++){
                System.out.println(ans2[i].getengineId());
            }
        }else{
            System.out.println("There are no engine with the given name");
        }
    }
    public static int findAvgEnginePriceByType(Engine[] arr,String type){
        int sum=0,cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getengineType().equalsIgnoreCase(type)){
                cnt++;
                sum+=arr[i].getenginePrice();
            }
        }
        if(sum>0 && cnt>0){
            return sum/cnt;
        }
        return 0;
    }
    public static Engine[] searchEngineByName(Engine[] arr,String name){
        Engine[] ans=new Engine[arr.length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getengineName().equalsIgnoreCase(name)){
                ans[cnt++]=arr[i];
            }
        }
        ans=Arrays.copyOf(ans,cnt);
        for(int i=0;i<ans.length;i++){
            for(int j=i+1;j<ans.length;j++){
                if(ans[i].getengineId()>ans[j].getengineId()){
                    Engine temp=ans[i];
                    ans[i]=ans[j];
                    ans[j]=temp;
                }
            }
        }
        if(ans.length>0){
            return ans;
        }else{
            return null;
        }
    }
}
/*
 * Create a class Engine with the below attributes:

engineld – int

engineName – String

engine Type – String

enginePrice – double

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class MyClass with main method.

Implement two static methods – findAvgEnginePriceByType and searchEngineByName in MyClass class.

findAvgEnginePriceByType method: This method will take two input parameters Engine objects and String parameter. 
The method will return the average price of Engines from array of Engine objects for the given engine type 
(String parameter passed). If no Engine with the given type is present in the array of Engine objects, then the method 
should return 0.


searchEngineByName method: This method will take a String parameter and an array of Engine objects as the other parameter. 
The method will return Engine object array in an ascending order of their engine ids, from the array of Engine objects whose 
name attribute matches with the given engine name (String parameter passed). If no Engine with the given name is present in 
the array of Engine objects, then the method should return null.

Note: No two Engine object would have the same engine id.

All searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For findAvgEnginePriceByType method: The main method should print the average enginePrice of Engines as it is, if the returned 
value is greater than 0, or it should print “There are no engine with given type”.

For searchEngineByName method: The main method should print the engineld from the returned Engine object array if the returned 
value is not null. If the returned value is null, then it should print “There are no engine with the given name”. 

Before calling these static methods in main, use Scanner object to read the values of four Engine objects referring attributes 
in the above mentioned attribute sequence. next, read the value of two String parameters for capturing engine type and engine 
name respectively.

Input :

1001
Maruti
Diesel
20000
1002
Kia
Pertro
17000
1003
Hyundai
Diesel
24000
1000
Maruti
Petrol
27500
Petrol
Maruti

Output :

27500
1000
1001
 */