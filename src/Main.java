import java.util.Random;
public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Random random = new Random();

        System.out.println("Inserindo valores:");

        // gerar e inserir 5 números aleatórios de 1 a 100
        for (int i = 0; i < 5; i++) {
            int valor = random.nextInt(100) + 1;
            System.out.print(valor + " ");
            arvore.inserir(valor);
        }

        System.out.println("\n");

        System.out.print("Em ordem: ");
        arvore.inOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Pré-ordem: ");
        arvore.preOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Pós-ordem: ");
        arvore.posOrdem(arvore.raiz);
        System.out.println();
    }
}

class Node {
    int info;
    Node esquerda, direita;

    Node(int info) {
        this.info = info;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBinaria {
    Node raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        Node novo = new Node(valor);

        if (raiz == null) {
            raiz = novo;
            return;
        }

        Node atual = raiz;
        Node pai = null;

        while (atual != null) {
            pai = atual;
            if (valor < atual.info) {
                atual = atual.esquerda;
            } else if (valor > atual.info) {
                atual = atual.direita;
            } else {
                return; // sem duplicados
            }
        }

        if (valor < pai.info) {
            pai.esquerda = novo;
        }
        else {
            pai.direita = novo;
        }
    }
    public void removerMenor() {
        if (raiz == null) return;

        Node atual = raiz;
        Node pai = null;

        while (atual.esquerda != null) {
            pai = atual;
            atual = atual.esquerda;
        }
        if (pai == null) {
            raiz = raiz.direita;
        } else {
            pai.esquerda = atual.direita;
        }
    }

    public void removerMaior() {
        if (raiz == null) return;

        Node atual = raiz;
        Node pai = null;

        while (atual.direita != null) {
            pai = atual;
            atual = atual.direita;
        }
        if (pai == null) {
            raiz = raiz.esquerda;
        } else {
            pai.direita = atual.esquerda;
        }
    }

    public void remover(int valor) {
        Node atual = raiz;
        Node pai = null;

        while (atual != null && atual.info != valor) {
            pai = atual;
            if (valor < atual.info) atual = atual.esquerda;
            else atual = atual.direita;
        }

        if (atual == null) return; // não achou

        // Nó é folha
        if (atual.esquerda == null && atual.direita == null) {
            if (pai == null) raiz = null; // era raiz
            else if (pai.esquerda == atual) pai.esquerda = null;
            else pai.direita = null;
        }
        // Filho da direita
        else if (atual.esquerda == null) {
            if (pai == null) raiz = atual.direita;
            else if (pai.esquerda == atual) pai.esquerda = atual.direita;
            else pai.direita = atual.direita;
        }
        // Filho da esquerda
        else if (atual.direita == null) {
            if (pai == null) raiz = atual.esquerda;
            else if (pai.esquerda == atual) pai.esquerda = atual.esquerda;
            else pai.direita = atual.esquerda;
        }
        // Dois filhos
        else {
            Node sucessorPai = atual;
            Node sucessor = atual.direita;
            while (sucessor.esquerda != null) {
                sucessorPai = sucessor;
                sucessor = sucessor.esquerda;
            }
            atual.info = sucessor.info;

            if (sucessorPai.esquerda == sucessor) {
                sucessorPai.esquerda = sucessor.direita;
            } else {
                sucessorPai.direita = sucessor.direita;
            }
        }
    }


    public void inOrdem(Node no) {
        if (no != null) {
            inOrdem(no.esquerda);
            System.out.print(no.info + " ");
            inOrdem(no.direita);
        }
    }
    public void preOrdem(Node no) {
        if (no != null) {
            System.out.print(no.info + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }
    public void posOrdem(Node no) {
        if (no != null) {
            posOrdem(no.esquerda);
            posOrdem(no.direita);
            System.out.print(no.info + " ");
        }
    }
}


