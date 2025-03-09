import java.util.Random;
public class coins {
    public final static int heads=0;
    public final static int tails=1;
    private int faceup;
    public coins(){
        flip();
    } 
    public void flip(){
        Random rand=new Random();
        faceup=rand.nextInt(2);
    }
    public String getfaceup(){
        if(faceup==heads){
            return "heads";
        }else if(faceup==tails){
            return "tails";
        }else{
            return "InValid";
        }
    }
    public static void main(String args[]){
        coins c=new coins();
        System.out.println("Intaial:"+c.getfaceup());
        for(int i=0;i<10;i++){
            c.flip();
            System.out.println("After Flip"+c.getfaceup());
        }
    }
}
