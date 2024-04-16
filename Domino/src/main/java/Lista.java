import java.util.Random;

public class Lista {

    private No inicio;
    private No ultimo;
    private int tamanho;

    public Lista() {
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public boolean contemPeca(int ladoA, int ladoB) {
        No noDaVez = inicio;
        while (noDaVez != null) {
            if ((noDaVez.peca.getNumero1() == ladoA && noDaVez.peca.getNumero2() == ladoB) ||
                    (noDaVez.peca.getNumero1() == ladoB && noDaVez.peca.getNumero2() == ladoA)) {
                return true;
            }
            noDaVez = noDaVez.proximo;
        }
        return false;
    }

    public static void preencherListaPecas(Lista lista) {
        Random random = new Random();
        while (lista.tamanho < 28) {
            int ladoA = random.nextInt(7);
            int ladoB = random.nextInt(7);

            if (!lista.contemPeca(ladoA, ladoB) && !lista.contemPeca(ladoB, ladoA)) {
                Peca novaPeca = new Peca(ladoA, ladoB);
                lista.inserir(novaPeca);
            }
        }
    }

    public Lista distribuirPecas(Lista monte) {
        No noDaVez = monte.inicio;
        Lista novaLista = new Lista();
        int contador = 1;
        while(noDaVez != null) {
            if(contador < 8) {
                novaLista.inserir(noDaVez.peca);
                monte.remover(1);
            }
            noDaVez = noDaVez.proximo;
            contador++;
        }
        return novaLista;
    }

    public void imprimirLista() {
        No noDaVez = inicio;
        int contador = 1;
        while(noDaVez != null) {
            Output impressao = new Output();
            impressao.imprimirLista(contador, noDaVez);
            noDaVez = noDaVez.proximo;
            contador++;
        }
    }

    public void imprimirMesa() {
        No noDaVez = inicio;
        Output impressao = new Output();
        while(noDaVez != null) {
            impressao.imprimirMesa(noDaVez);
            noDaVez = noDaVez.proximo;
        }
        impressao.pularLinha();
    }

    public void inserir(Peca peca) {
        No noDaVez = new No();
        noDaVez.peca = peca;
        if(inicio == null) {
            inicio = noDaVez;
            ultimo = noDaVez;
        } else {
            ultimo.proximo = noDaVez;
            noDaVez.anterior = ultimo;
            ultimo = noDaVez;
        }
        tamanho++;
    }

    public void inserirNoComeco(Peca peca) {
        No noDaVez = new No();
        noDaVez.peca = peca;
        if (inicio == null) {
            inicio = noDaVez;
            ultimo = noDaVez;
        } else {
            noDaVez.proximo = inicio;
            inicio.anterior = noDaVez;
            inicio = noDaVez;
        }
        tamanho++;
    }

    public Peca buscarPeca(int posicao) {
        int contador = 1;
        No noDaVez = inicio;
        while(noDaVez != null) {
            if(posicao == contador) {
                return noDaVez.peca;
            }
            contador++;
            noDaVez = noDaVez.proximo;
        }
        return null;
    }

    public Peca remover(int posicao) {
        int contador = 1;
        if (estaVazia()) {
            return null;
        }
        No noDaVez = inicio;
        No anterior = null;
        while(noDaVez != null) {
            if (posicao == contador) {
                break;
            }
            contador++;
            anterior = noDaVez;
            noDaVez = noDaVez.proximo;
        }
        if (noDaVez == null) {
            return null;
        }
        if (inicio == ultimo) {
            inicio = null;
            ultimo = null;
        } else {
            if (noDaVez == inicio) {
                inicio = inicio.proximo;
                inicio.anterior = null;
            } else if (noDaVez == ultimo) {
                ultimo = anterior;
                anterior.proximo = null;
            } else {
                anterior.proximo = noDaVez.proximo;
            }
        }
        tamanho--;
        return noDaVez.peca;
    }

    public void pegarDoMonte(Lista monte, Lista listaDaVez) {
        No noDaVez = monte.inicio;
        Output impressao = new Output();
        if (noDaVez != null) {
            listaDaVez.inserir(noDaVez.peca);
            monte.remover(1);
        } else {
            impressao.imprimirNaoHaPecaMonte(monte);
        }
    }
}
