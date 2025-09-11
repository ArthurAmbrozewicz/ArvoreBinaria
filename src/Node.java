public class Node {
    private int info;
    private Node esquerda;
    private Node direita;

    Node(int info) {
        this.info = info;
    }

    public int getInfo() { return info; }
    public void setInfo(int info) { this.info = info; }

    public Node getEsquerda() { return esquerda; }
    public void setEsquerda(Node esquerda) { this.esquerda = esquerda; }

    public Node getDireita() { return direita; }
    public void setDireita(Node direita) { this.direita = direita; }
}
