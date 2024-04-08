import java.util.Scanner;
import java.util.regex.Pattern;

public class Partida {
    Lista monte = new Lista();
    Lista player = new Lista();
    Lista com = new Lista();
    Lista mesa = new Lista();

    int indicadorDeEmpate = 0;

    public void iniciarPartida() {
        monte.preencherListaPecas(monte);
        player = player.distribuirPecas(monte);
        com = com.distribuirPecas(monte);
    }

    public void fazerJogada() {
        boolean pecaValida;
        mesa.imprimirMesa();
        int tamanho = player.getTamanho();
        Output impressao = new Output();
        Input input = new Input();

        while(true) {
            impressao.imprimirOpcoesFazerJogada();
            player.imprimirLista();
            String opcao = input.digitarOpcoes();
            if (Pattern.matches("[a-zA-Z]+", opcao)) {
                impressao.imprimirSomenteNumeros();
            } else {
                int numero = Integer.parseInt(opcao);
                if (numero == 0) {
                    indicadorDeEmpate++;
                    if (indicadorDeEmpate < 2) {
                        jogadaCom();
                        break;
                    } else {
                        impressao.imprimirEmpate();
                        finalizarJogo();
                        break;
                    }
                } else if (numero > tamanho) {
                    impressao.imprimirOpcaoInvalida();
                    mesa.imprimirMesa();
                } else {
                    Peca p = player.buscarPeca(numero);
                    pecaValida = verificarPeca(p, numero);
                    if (!player.estaVazia() && pecaValida) {
                        indicadorDeEmpate = 0;
                        jogadaCom();
                        break;
                    } else if (!com.estaVazia() && !pecaValida) {
                        impressao.imprimirPecaInvalida();
                        mesa.imprimirMesa();
                    } else if (player.estaVazia()) {
                        impressao.imprimirVitoriaPlayer();
                        finalizarJogo();
                        break;
                    }
                }
            }
        }
    }

    public void jogadaCom() {
        int contador = 1;
        No noDaVez = com.getInicio();
        boolean pecaValida = false;
        Output impressao = new Output();

        while (!pecaValida) {
            Peca p = noDaVez.peca;
            if (noDaVez == com.getUltimo()) {
                pecaValida = verificarPecaCom(p, contador);
                break;
            } else {
                pecaValida = verificarPecaCom(p, contador);
            }
            noDaVez = noDaVez.proximo;
            contador++;
        }
        if (!com.estaVazia() && pecaValida) {
            indicadorDeEmpate = 0;
            fazerJogada();
        } else if (!com.estaVazia() && !pecaValida) {
            impressao.imprimirPassouVez();
            indicadorDeEmpate++;
            if (indicadorDeEmpate < 2) {
                indicadorDeEmpate = 0;
                fazerJogada();
            } else {
                impressao.imprimirEmpate();
                finalizarJogo();
            }
        } else if (com.estaVazia()) {
            mesa.imprimirMesa();
            impressao.imprimirVitoriaCOM();
            finalizarJogo();
        }
    }

    public boolean verificarPecaCom(Peca p, int opcao) {
        if (mesa.estaVazia()) {
            mesa.inserir(p);
            com.remover(opcao);
            return true;
        } else {
            if (mesa.getUltimo().peca.getNumero2() == p.getNumero1()) {
                mesa.inserir(p);
                com.remover(opcao);
                return true;
            } else if (mesa.getUltimo().peca.getNumero2() == p.getNumero2()) {
                int aux = p.getNumero1();
                p.setNumero1(p.getNumero2());
                p.setNumero2(aux);
                mesa.inserir(p);
                com.remover(opcao);
                return true;
            } else if (mesa.getInicio().peca.getNumero1() == p.getNumero2()) {
                mesa.inserirNoComeco(p);
                com.remover(opcao);
                return true;
            } else if (mesa.getInicio().peca.getNumero1() == p.getNumero1()) {
                int aux = p.getNumero1();
                p.setNumero1(p.getNumero2());
                p.setNumero2(aux);
                mesa.inserirNoComeco(p);
                com.remover(opcao);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean verificarPeca(Peca p, int opcao) {
        if (mesa.estaVazia()) {
            mesa.inserir(p);
            player.remover(opcao);
            return true;
        } else {
            if (mesa.getUltimo().peca.getNumero2() == p.getNumero1()) {
                mesa.inserir(p);
                player.remover(opcao);
                return true;
            } else if (mesa.getUltimo().peca.getNumero2() == p.getNumero2()) {
                int aux = p.getNumero1();
                p.setNumero1(p.getNumero2());
                p.setNumero2(aux);
                mesa.inserir(p);
                player.remover(opcao);
                return true;
            } else if (mesa.getInicio().peca.getNumero1() == p.getNumero2()) {
                mesa.inserirNoComeco(p);
                player.remover(opcao);
                return true;
            } else if (mesa.getInicio().peca.getNumero1() == p.getNumero1()) {
                int aux = p.getNumero1();
                p.setNumero1(p.getNumero2());
                p.setNumero2(aux);
                mesa.inserirNoComeco(p);
                player.remover(opcao);
                return true;
            } else {
                return false;
            }
        }
    }

    public void finalizarJogo() {
        mesa.setInicio(null);
        mesa.setUltimo(null);
        player.setInicio(null);
        player.setUltimo(null);
        com.setInicio(null);
        com.setUltimo(null);
    }
}
