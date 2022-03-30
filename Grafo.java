import java.util.Arrays;

public class Grafo {
    private int numVertices = 21; // uma linha e coluna a mais para os índices do vertices
    private int[][] matriz; // matriz de adjacência

    public Grafo() {
        this.matriz = new int[this.numVertices][this.numVertices]; // 21x21, sendo que o índice 0 não é usado

        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.matriz[i][j] = 0; // inicializa todos os elementos da matriz com 0
            }
        }

        for (int i = 0; i < this.numVertices; i++) {
            this.matriz[0][i] = i; // Adiciona os índices dos vértices válidos (1 - 20)
        }
        for (int i = 0; i < this.numVertices; i++) {
            this.matriz[i][0] = i; // Adiciona os índices dos vértices válidos (1 - 20)
        }
    }

    public void inserirAresta(Aresta aresta) {
        int v1 = aresta.getV1();
        int v2 = aresta.getV2();
        int peso = aresta.getPeso();

        boolean valido = v1 < this.numVertices && v2 < this.numVertices && v1 > 0 && v2 > 0;

        if (valido) {
            this.matriz[v1][v2] = peso;
            this.matriz[v2][v1] = peso;

        } else {
            throw new IllegalArgumentException("Um dos vértices está fora do limite (Vertices válidos: 1-20)");
        }

    }

    public void mostrarMatriz() {
        int digitosMaior = getNumDigitos(matriz);  // num de dígitos do maior elemento da matriz

        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                String digitosAtual = matriz[i][j] + "";                // string do elemento atual para verificar num de dígitos   
                int numZeros = digitosMaior - digitosAtual.length();    // num de zeros a ser adicionado a esquerda
                String zeros[] = new String[numZeros];                  // array de zeros
                Arrays.fill(zeros, "0");                                // preenche o array com zeros

                System.out.print(String.join("", zeros));      // imprime os zeros
                System.out.print(matriz[i][j] + " ");          // imprime o elemento atual
            }
            System.out.println();
        }
    }

    public void mostrarLista() {
        for (int i = 1; i < this.numVertices; i++) {
            System.out.print("Vertice " + i + "-> ");
            for (int j = 1; j < this.numVertices; j++) {
                if (this.matriz[i][j] != 0)
                    System.out.print(j + "(" + this.matriz[i][j] + ")  ");
            }
            System.out.println();
        }
    }

    private int getNumDigitos(int[][] matriz) {
        int maior = 0;
        for(int i[] : matriz) {
            for (int j : i) {
               maior = (j > maior) ? j : maior;
            }
        }

        String array = maior + "";
        return array.length();
    }

}
