import java.util.Scanner;

public class Out {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 / num2);
        System.out.println(num1 * num2);

        System.out.println("\nArithmetic operations :");
        System.out.println("Addition" + (num1+num2) + "Subtraction" + (num1-num2) + "Multiplication" + (num1*num2) + "Division" + (num1/num2));

        sc.close();

    }

}