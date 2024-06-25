package task_01.temperatura;
import java.util.Scanner;

public class Temperatura {
    static Scanner scanner = new Scanner(System.in);

    public static void conveterTemperatura() {
        System.out.println("Digite a temperatura em Celsius: ");
        float temperatura = scanner.nextFloat();
        double resultado = (temperatura * 1.8) + 32;

        System.out.print("Temperatura em Celsius: " + temperatura + "\nTemperatura em Fahrenheit: " + resultado);
    }
}
