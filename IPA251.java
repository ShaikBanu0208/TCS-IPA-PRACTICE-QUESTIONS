import java.util.*;
class Rectangle{
    double length;
    double breadth;
    double area;
    double perimeter;
    Rectangle(double a,double b){
        this.length=a;
        this.breadth=b;
    }
    double getlength(){
        return length;
    }
    double getbreadth(){
        return breadth;
    }
    double getarea(){
        return area;
    }
    double getperimeter(){
        return perimeter;
    }
    void setarea(double area){
        this.area=area;
    }
    void setperimeter(double perimeter){
        this.perimeter=perimeter;
    }
}
public class IPA251 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Rectangle[] arr=new Rectangle[2];
        for(int i=0;i<arr.length;i++){
            double a=sc.nextDouble();
            sc.nextLine();
            double b=sc.nextDouble();
            sc.nextLine();
            arr[i]=new Rectangle(a, b);
        }
        double[] area=calculateArea(arr);
        double[] perimeter=calculatePerimeter(arr);
        if(area!=null && perimeter!=null){
            for(int i=0;i<arr.length;i++){
                System.out.println(area[i]);
                System.out.println(perimeter[i]);
            }
        }
    }
    public static double[] calculateArea(Rectangle[] arr){
        double[] ans=new double[arr.length];
        for(int i=0;i<arr.length;i++){
            double area=arr[i].getlength()*arr[i].getbreadth();
            ans[i]=area;
        }
        if(ans.length>0){
            return ans;
        }
        return null;
    }
    public static double[] calculatePerimeter(Rectangle[] arr){
        double[] ans=new double[arr.length];
        for(int i=0;i<arr.length;i++){
            double perimeter=2*(arr[i].getlength()+arr[i].getbreadth());
            ans[i]=perimeter;
        }
        if(ans.length>0){
            return ans;
        }
        return null;
    }
}
/*
 * Create a class Rectangle with the following attributes:

length - double
breadth - double

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create a class Solution with the main method.

Implement two static methods - calculateArea and calculatePerimeter in Solution class.

calculateArea method:
This method will take a Rectangle object as input.
The method will calculate the area of the rectangle and return it as a double.

calculatePerimeter method:
This method will take a Rectangle object as input.
The method will calculate the perimeter of the rectangle and return it as a double.

These above mentioned static methods should be called from the main method.

For calculateArea method - The main method should print the area returned by the method.

For calculatePerimeter method - The main method should print the perimeter returned by the method.

Before calling these static methods in main, use Scanner object to read the values of two Rectangle objects referring 
attributes in the above mentioned attribute sequence.

Example Input:
5.5
3.2
7.0
4.5

Example Output:
17.6
17.4
31.5
23.0
 */