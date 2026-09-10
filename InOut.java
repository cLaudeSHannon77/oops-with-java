import java.util.Scanner;


public class InOut {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your marks: ");
        int marks =  sc.nextInt();

        System.out.println("\nHello, " + name + "!");
        System.out.println("Your marks are :" + marks);

        if (marks >= 40) {
            System.out.println("Your result: pass");
        } else {
            System.out.println("Your result: fail");
        }

        sc.close();

    }


}
