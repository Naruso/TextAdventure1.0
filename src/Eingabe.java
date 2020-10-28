import java.util.Scanner;

class Eingabe
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        System.out.println("You entered string "+s);
    }
}
