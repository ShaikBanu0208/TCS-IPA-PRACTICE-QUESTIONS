import java.util.Random;
public class Dice {
    Random rand;
    int p=-1;
    public Dice(){
        this.rand=new Random();
    }
    public int roll(){

        int currentroll=this.rand.nextInt(7);
        this.p=currentroll;
        return currentroll;
        
    }
    public static void main(String[] args) {
        Dice d=new Dice();
        System.out.println(d.p);
        System.out.println(d.roll());
        System.out.println(d.p);
        System.out.println(d.roll());
        System.out.println(d.p);
        System.out.println(d.roll());
    }
}
