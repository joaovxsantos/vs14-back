package task_01.imparpar;
import java.util.Scanner;


public class ImparPar {

    static Scanner scanner = new Scanner(System.in);

    public static void definirImparPar() {

            System.out.println("Verificando se o número é impar ou par");
            System.out.print("Digite um número: ");
            int num = scanner.nextInt();

            System.out.println("O número " + num + " é " + (num % 2 == 0? "PAR." : "IMPAR."));
    }
}
