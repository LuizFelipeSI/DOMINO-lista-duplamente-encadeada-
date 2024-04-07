import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {

    public void menu() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("---------------DOMINÓ---------------");
            System.out.println("1 - iniciar jogo");
            System.out.println("2 - sair");
            String opcao = scan.next();
            if (Pattern.matches("[a-zA-Z]+", opcao)) {
                System.out.println("Somente números são válidos!");
            } else {
                int numero = Integer.parseInt(opcao);
                if (numero == 1) {
                    Partida jogo = new Partida();
                    jogo.iniciarPartida();
                    jogo.fazerJogada();
                } else if (numero == 2){
                    break;
                } else {
                    System.out.println("opção inválida");
                }
            }
        }
    }
}
