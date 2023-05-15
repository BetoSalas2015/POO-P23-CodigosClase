import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dame tu nombre; ");
        String str = scanner.nextLine();

        System.out.println("Dame tu Edad; ");
        int edad = scanner.nextInt();

        System.out.println("Nombre: " + str + ", Edad: " + edad);
    }
}
