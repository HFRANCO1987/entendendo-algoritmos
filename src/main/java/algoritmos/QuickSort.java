package algoritmos;

public class QuickSort {

    public static void main(String[] args) {
        int[] numeros = {8,20,1,9,7,2,4,3,6,5};
        quickSort(numeros, 0, numeros.length);
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }

    private static void quickSort(int[] numeros, int de, int ate) {
        int elementos = ate - de;
        if (elementos > 1){
            int posicaoDoPivo = quebraNoPivo(numeros, de, ate);
            quickSort(numeros, de, posicaoDoPivo); //ordenanando o array da esquerda
            quickSort(numeros, posicaoDoPivo + 1, ate); //ordernando o array da direita
        }
    }

    private static int quebraNoPivo(int[] numeros, int inicial, int termino){
        int pivo = numeros[termino -1];
        int menoresEncontrados = 0; //define a quantidade de valores menores, com isso a posição de troca já fica definida
        for (int analisando = 0; analisando < termino -1; analisando++) {
            int atual = numeros[analisando];
            if (atual <= pivo){
                troca(numeros, analisando, menoresEncontrados);
                menoresEncontrados++;
            }
        }
        troca(numeros, termino-1, menoresEncontrados);
        return menoresEncontrados;
    }

    private static void troca(int[] numeros, int de, int para) {
        int valorDe = numeros[de];
        int valorPara = numeros[para];
        numeros[para] = valorDe;
        numeros[de] = valorPara;
    }


}
