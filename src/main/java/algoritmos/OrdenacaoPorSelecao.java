package algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Henrique Santiago
 * 
 */
public class OrdenacaoPorSelecao {

    /**
     * menor - Armazena o menor valor encontrado no array
     * menor_indice - Armazena o indice do menor valor
     * @param listaNumeros
     *
     * Obs: Poderia retornar o número encontrado diretamente, fica para próxima refatoração
     * @return
     */
    private static int buscarMenor(List<Integer> listaNumeros){
        int menor = listaNumeros.get(0);
        int menor_indice = 0;
        for (int i = 0; i < listaNumeros.size(); i++) {
            if (listaNumeros.get(i) < menor){
                menor = listaNumeros.get(i);
                menor_indice = i;
            }
        }
        return menor_indice;
    }

    /**
     * Utiliza o método buscarMenor para encontrar o indice do menor valor, 
     * em seguida add na lista de numeros ordenados e remove da lista de numeros não ordenados
     * Importante gravar o tamanho do array em uma variavel para não term problema com o tamanho
     * no momento de percorrer o mesmo para ordenação
     *
     * @param listaNumerosNaoOrdenados
     * @return
     */
    private static List<Integer> ordenarArrayDeNumeroPorSelecao(List<Integer> listaNumerosNaoOrdenados){
        List<Integer> listaNumerosOrdenados = new ArrayList<Integer>(listaNumerosNaoOrdenados.size());
        int menor = 0;
        int tamanhoArray = listaNumerosNaoOrdenados.size();
        for (int i = 0; i < tamanhoArray; i++) {
            menor = buscarMenor(listaNumerosNaoOrdenados);
            listaNumerosOrdenados.add(listaNumerosNaoOrdenados.get(menor));
            listaNumerosNaoOrdenados.remove(menor);
        }
        return listaNumerosOrdenados;
    }

    /**
     * Executa o método passando um array de número qualquer para ordenação
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> arrDeNumerosQualquer = new ArrayList<Integer>(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(ordenarArrayDeNumeroPorSelecao(arrDeNumerosQualquer));
    }
}
