import java.util.regex.Pattern;

public class Menu {

    public void imprimirMenu() {
        Output impressao = new Output();
        Input input = new Input();
        while (true) {
            impressao.imprimirMenu();
            String opcao = input.digitarOpcoes();
            if (Pattern.matches("[a-zA-Z]+", opcao)) {
                impressao.imprimirSomenteNumeros();
            } else {
                int numero = Integer.parseInt(opcao);
                if (numero == 1) {
                    Partida jogo = new Partida();
                    jogo.iniciarPartida();
                    jogo.fazerJogada();
                } else if (numero == 2){
                    break;
                } else {
                    impressao.imprimirOpcaoInvalida();
                }
            }
        }
    }
}
