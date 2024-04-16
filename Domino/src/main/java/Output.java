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

    public void imprimirOpcoesFazerJogada(Lista monte) {
        System.out.println("Escolha sua peça ou passe a vez:");
        System.out.println("0 - passar a vez");
        System.out.println("100 - pegar peça do monte (peças disponíveis - " + monte.getTamanho() + ")");
    }

    public void imprimirSomenteNumeros() {
        System.out.println("Somente números são válidos!");
    }

    public void imprimirPecaJogadaCom(Peca peca) {
        System.out.println("Última peça que COM jogou: " + peca.getNumero1() + ":" + peca.getNumero2());
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

    public void imprimirNaoHaPecaMonte(Lista monte) {
        System.out.println("Não há peça no monte (peças disponíveis - " + monte.getTamanho() + ")");
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

    public void pularLinha() {
        System.out.println();
    }
}
