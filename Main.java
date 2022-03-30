import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        Grafo grafo = new Grafo();

        do {
            menu();
            opcao = sc.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.print("Vertice de origem: ");
                    int v1 = sc.nextInt();
                    System.out.print("Vertice final: ");
                    int v2 = sc.nextInt();
                    System.out.print("Peso da aresta: ");
                    int peso = sc.nextInt();

                    Aresta aresta = new Aresta(v1, v2, peso);
                    try {
                        grafo.inserirAresta(aresta);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    grafo.mostrarMatriz();
                    break;
                case 3:
                    grafo.mostrarLista();
                    break;
                case 4:
                    System.out.println("Fim do programa");
                    break;
            }

            System.out.println();
            sc.nextLine();
        } while (opcao != 4);

        sc.close();
    }

    public static void menu() {
        System.out.println("--------ATIVIDADE2_GRAFOS--------");
        System.out.println("1 - Inserir aresta");
        System.out.println("2 - Mostrar matriz de adjacência");
        System.out.println("3 - Mostrar lista de adjacência");
        System.out.println("4 - Sair");
        System.out.print("Sua escolha: ");
    }

}
