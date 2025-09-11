class ArvoreBinaria {
    private Node raiz;

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
            if (valor < atual.getInfo()) {
                atual = atual.getEsquerda();
            } else if (valor > atual.getInfo()) {
                atual = atual.getDireita();
            } else {
                return; // sem duplicados
            }
        }

        if (valor < pai.getInfo()) {
            pai.setEsquerda(novo);
        } else {
            pai.setDireita(novo);
        }
    }

    public void removerMenor() {
        if (raiz == null) return;

        Node atual = raiz;
        Node pai = null;

        while (atual.getEsquerda() != null) {
            pai = atual;
            atual = atual.getEsquerda();
        }
        if (pai == null) {
            raiz = raiz.getDireita();
        } else {
            pai.setEsquerda(atual.getDireita());
        }
    }

    public void removerMaior() {
        if (raiz == null) return;

        Node atual = raiz;
        Node pai = null;

        while (atual.getDireita() != null) {
            pai = atual;
            atual = atual.getDireita();
        }
        if (pai == null) {
            raiz = raiz.getEsquerda();
        } else {
            pai.setDireita(atual.getEsquerda());
        }
    }

    public void remover(int valor) {
        Node atual = raiz;
        Node pai = null;

        while (atual != null && atual.getInfo() != valor) {
            pai = atual;
            if (valor < atual.getInfo()) atual = atual.getEsquerda();
            else atual = atual.getDireita();
        }

        if (atual == null) return; // não achou

        // Nó é folha
        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            if (pai == null) raiz = null; // era raiz
            else if (pai.getEsquerda() == atual) pai.setEsquerda(null);
            else pai.setDireita(null);
        }
        // Filho da direita
        else if (atual.getEsquerda() == null) {
            if (pai == null) raiz = atual.getDireita();
            else if (pai.getEsquerda() == atual) pai.setEsquerda(atual.getDireita());
            else pai.setDireita(atual.getDireita());
        }
        // Filho da esquerda
        else if (atual.getDireita() == null) {
            if (pai == null) raiz = atual.getEsquerda();
            else if (pai.getEsquerda() == atual) pai.setEsquerda(atual.getEsquerda());
            else pai.setDireita(atual.getEsquerda());
        }
        // Dois filhos
        else {
            Node sucessorPai = atual;
            Node sucessor = atual.getDireita();
            while (sucessor.getEsquerda() != null) {
                sucessorPai = sucessor;
                sucessor = sucessor.getEsquerda();
            }
            atual.setInfo(sucessor.getInfo());

            if (sucessorPai.getEsquerda() == sucessor) {
                sucessorPai.setEsquerda(sucessor.getDireita());
            } else {
                sucessorPai.setDireita(sucessor.getDireita());
            }
        }
    }

    public void inOrdem(Node no) {
        if (no != null) {
            inOrdem(no.getEsquerda());
            System.out.print(no.getInfo() + " ");
            inOrdem(no.getDireita());
        }
    }
    public void preOrdem(Node no) {
        if (no != null) {
            System.out.print(no.getInfo() + " ");
            preOrdem(no.getEsquerda());
            preOrdem(no.getDireita());
        }
    }
    public void posOrdem(Node no) {
        if (no != null) {
            posOrdem(no.getEsquerda());
            posOrdem(no.getDireita());
            System.out.print(no.getInfo() + " ");
        }
    }

    public Node getRaiz() {
        return raiz;
    }

}
