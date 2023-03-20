
import java.util.Scanner;

public class App{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        fahrenhite f = new fahrenhite();
        celcius c=new celcius();
        kelvin k=new kelvin();
        
        System.out.println("Welcome");

        boolean repeat=true;

        while(repeat==true)
        {
            System.out.println("Choose conversion:");
            String choose = scan.nextLine();
            switch(choose)
            {
                case "f":
                    repeat=f.Fahrenhite();
                    break;
                case "c":
                    repeat=c.Celcius();
                    break;
                case "k":
                    repeat=k.Kelvin();
                    break;
                default:
                    break;
            }
        }
            
        
        

        scan.close();
    }
}
