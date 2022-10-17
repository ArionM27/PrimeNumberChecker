//Arion Mercado
//10/16/22
//Queue Programming

//Importing scanner
import java.util.Scanner;

public class Main {
    //Having a main class to run the program
    public static void main(String [] args){
        System.out.println("Please Enter Upper Bound");
        Scanner input = new Scanner(System.in);
        
        int upper = input.nextInt();

        Sieve prime = new Sieve();
        
        try{
            prime.primesTo(upper);
        }

        catch(StringIndexOutOfBoundsException a){
            System.out.println("Error: Input must be a number greater than 2");
        }

        input.close();
    }
}
