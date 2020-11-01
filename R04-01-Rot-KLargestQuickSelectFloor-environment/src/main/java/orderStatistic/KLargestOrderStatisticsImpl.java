package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Voce pode modificar o array original
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		//este metodo deve obrigatoriamente usar o orderStatistics abaixo.
		T[] kLargest;
		if(k < 1 || k > array.length){
			kLargest = (T[]) new Comparable[0];
		}
		else{
			kLargest = (T[]) new Comparable[k];
			int largestNumbers = array.length - k;
			int j = 0;
			for (int i = largestNumbers + 1; i <= array.length; i++) {
				kLargest[j] = orderStatistics(array,i);
				j++;
			}
		}
		return kLargest;

	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		if(k < 1 || k > array.length){
			return null;
		}
		return bubbleSortKLargest(array,0,array.length - 1,k);
	}

	private T bubbleSortKLargest(T[] array, int leftIndex, int rightIndex, int k) {
		if(leftIndex < 0 && rightIndex >= array.length){
			return null;
		}
		for (int i = leftIndex; i < k; i++) {
			for (int j = rightIndex; j >= leftIndex + 1; j--) {
				if(array[j].compareTo(array[j - 1]) < 0){
					Util.swap(array,j,j-1);
				}
			}
		}
		return array[k - 1];
	}
}
