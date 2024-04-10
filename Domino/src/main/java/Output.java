public class Output {

    public void imprimirMenu() {
        System.out.println("---------------DOMINÓ---------------");
        System.out.println("1 - Iniciar jogo");
        System.out.println("2 - Sair");
    }

    public void imprimirLista(int contador, No noDaVez) {
        System.out.print(contador + " - " + noDaVez.peca.getNumero1() + ":");
        System.out.println(noDaVez.peca.getNumero2());
    }

    public void imprimirMesa(No noDaVez) {
        System.out.print(noDaVez.peca.getNumero1() + ":");
        System.out.print(noDaVez.peca.getNumero2() + " | ");
    }

    public void imprimirOpcoesFazerJogada() {
        System.out.println("Escolha sua peça ou passe a vez:");
        System.out.println("0 - passar a vez");
    }

    public void imprimirSomenteNumeros() {
        System.out.println("Somente números são válidos!");
    }

    public void imprimirPecaJogadaCom(Peca peca) {
        System.out.println("COM jogou: " + peca.getNumero1() + ":" + peca.getNumero2());
    }

    public void imprimirEmpate() {
        System.out.println("O jogo empatou");
    }

    public void imprimirOpcaoInvalida() {
        System.out.println("Opção inválida");
    }

    public void imprimirPecaInvalida() {
        System.out.println("Peça inválida");
    }

    public void imprimirVitoriaPlayer() {
        System.out.println("PLAYER ganhou");
    }

    public void imprimirPassouVez() {
        System.out.println("COM passou a vez");
    }

    public void imprimirVitoriaCOM() {
        System.out.println("COM ganhou");
    }
}
