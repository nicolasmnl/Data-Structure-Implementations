package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		//Condições de parada
		if(leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex){
			return;
		}
		//Maior e Menor valor do array
		int k = max(array,leftIndex,rightIndex);
		int menor = min(array, leftIndex, rightIndex);
		//Criando um array de contagem do tamanho do maior valor
		int[] C = new int[k - menor + 1];
		//Contando as incidências de cada número do vetor original no vetor de contage,
		for (int i = leftIndex; i <= rightIndex; i++) {
			C[array[i] - menor] += 1;
		}
		//Calculando a soma acumulada
		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}
		//Criando um vetor do tamanho da quantidade de números que serão ordenados no array original, sejam todos ou uma parte deles
		Integer[] B = new Integer[rightIndex - leftIndex + 1];
		//Preenchendo o novo vetor de trás pra frente mantendo a estabilidade
		for (int i = rightIndex; i >= leftIndex; i--) {
			B[C[array[i] - menor] - 1] = array[i];
			C[array[i] - menor] -= 1;
		}
		//Copiando os valores pra o array original
		for (int i = leftIndex, j = 0; i <= rightIndex; i++,j++) {
			array[i] = B[j];
		}
	}

	private int max(Integer[] array,int leftIndex, int rightIndex){
		int max = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] > max){
				max = array[i];
			}
		}
		return max;
	}

	private int min(Integer[] array, int leftIndex, int rightIndex){
		int min = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] < min){
				min = array[i];
			}
		}
		return min;
	}

}
