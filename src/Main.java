public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        // inserindo valores manualmente
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.print("Em ordem inicial: ");
        arvore.inOrdem(arvore.getRaiz());
        System.out.println();

        arvore.removerMenor(); // remove 20
        System.out.print("Após remover menor: ");
        arvore.inOrdem(arvore.getRaiz());
        System.out.println();

        arvore.removerMaior(); // remove 80
        System.out.print("Após remover maior: ");
        arvore.inOrdem(arvore.getRaiz());
        System.out.println();

        arvore.remover(50); // remove raiz (50)
        System.out.print("Após remover 50: ");
        arvore.inOrdem(arvore.getRaiz());
        System.out.println();
    }
}
