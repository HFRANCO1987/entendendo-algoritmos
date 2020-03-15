package algoritmos;

/**
 * A ideia é quebrar um array grande em array menores e ordenar os menores.
 * É utilizado o conceito de recursão para implementação do mesmo, se
 * debugar o código abaixo irá perceber que o método é invocado recursivamente e
 * o array maior é quebrado em array menores.
 */
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
            int posicaoDoPivo = quebraNoPivo(numeros, de, ate); //faz a pivotagem, com isso o array pode ser quebrado em [] esquerdo e [] direito
            quickSort(numeros, de, posicaoDoPivo); //ordenando o array da esquerda, do inicio até o pivo
            quickSort(numeros, posicaoDoPivo + 1, ate); //ordenando o array da direita, do pivo até o final do array
        }
    }

    private static int quebraNoPivo(int[] numeros, int inicial, int termino){
        int pivo = numeros[termino -1];
        int menoresEncontrados = 0; //define a quantidade de valores menores, com isso a posição de troca já fica definida
        for (int analisando = 0; analisando < termino -1; analisando++) {
            int atual = numeros[analisando];
            if (atual <= pivo){ //posição atual do array é menor ou igual ao pivo
                troca(numeros, analisando, menoresEncontrados);
                menoresEncontrados++;
            }
        }
        troca(numeros, termino-1, menoresEncontrados); //troca deve ser feita
        return menoresEncontrados;
    }

    private static void troca(int[] numeros, int de, int para) {
        int valorDe = numeros[de];
        int valorPara = numeros[para];
        numeros[para] = valorDe;
        numeros[de] = valorPara;
    }


}
