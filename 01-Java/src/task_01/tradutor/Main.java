package task_01.tradutor;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite a palavra que deseja traduzir: ");
        String palavra = scanner.nextLine();

        switch (palavra) {
            case "Cachorro" :
                System.out.print("Em inglês: Dog");
                break;
            case "Cidade" :
                System.out.print("Em inglês: City");
                break;
            case "Feliz" :
                System.out.print("Em inglês: Feliz");
                break;
            case "Triste" :
                System.out.print("Em inglês: Sad");
                break;

            case "Dog":
                System.out.print("Em Português: Cachorro");
                break;

            case "City":
                System.out.print("Em Português: Cidade");
                break;
            case "Sad":
                System.out.print("Em Português: Triste");

            default:
                System.out.print("Esse idioma não é válido;");
        }
    }
}
