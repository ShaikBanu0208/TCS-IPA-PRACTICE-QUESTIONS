import java.awt.*;
class car {
    double averageMilesPerGallon;
    String licensePlate;
    boolean areTailingWorking;
    Color paintColor;
    //Constructor
    car(double averageMilesPerGallon,String licensePlate,boolean areTailingWorking,Color paintColor){
        this.averageMilesPerGallon=averageMilesPerGallon;
        this.licensePlate=licensePlate;
        this.areTailingWorking=areTailingWorking;
        this.paintColor=paintColor;
    }
    public static void main(String args[]){
        car mycar=new car(30.5,"12A34B",true,Color.BLUE);
        System.out.println(mycar.licensePlate);
        System.out.println(mycar.paintColor);
    }

}

