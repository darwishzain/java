import java.util.Scanner;

public class celcius {
    
    public boolean Celcius()
    {
        double d1=0,d2=0; 
        Scanner s = new Scanner(System.in);//scanner

        System.out.println("Convert to:");
        String convertTo = s.nextLine();//scan convert choice

        System.out.println("Input [double] to be converted:");
        d1 = s.nextDouble();//double to be converted

        String buff =  s.nextLine();//read 'end of line' in d1 inputt

        String conv="";//initialize strinig conv
        String u="";//initialize string u

        switch (convertTo){

            case "f":
                d2=toF(d1);
                conv="Fahrenhite";
                u="F";
                break;
            case "k":
                d2=toK(d1);
                conv="Kelvin";
                u="K";
                break;
            default:
                break;
        }
        System.out.println("Celcius to " + conv);
        System.out.println(d1 + "C ="+ d2 + u);

        System.out.println("Continue with other conversion? [y:YES//n:NO]");
        String another = s.nextLine();
        s.close();
        switch(another)
        {
            case "y":
                return true;
            case "n":
                return false;
            default: 
                return false;
        }
    }

    public double toF(double c)
    {
        double f;
        f=(9/5)*c+32;
        return f;
    }
    public double toK(double c)
    {
        double k;
        k=c+273;
        return k;
    }
}
