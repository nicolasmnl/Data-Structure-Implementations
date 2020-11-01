package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import sorting.Sorting;
import util.Util;

import java.util.Arrays;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	public static int MERGESORT_APPLICATIONS = 0;
	public static int INSERTIONSORT_APPLICATIONS = 0;


	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		if(leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex){
			return;
		}else{
			hybridMergeSort(array,leftIndex,rightIndex);
		}


	}

	private void hybridMergeSort(T[] array, int leftIndex, int rightIndex) {
		if(rightIndex - leftIndex + 1 <= SIZE_LIMIT){
			insertion(array, leftIndex, rightIndex);
		}else{
			int middle = (leftIndex + rightIndex)/2;
			hybridMergeSort(array,leftIndex, middle);
			hybridMergeSort(array,middle + 1, rightIndex);

			merge(array,leftIndex,middle,rightIndex);

		}



	}



	private void insertion(T[] array, int leftIndex, int rightIndex){
		for (int i = leftIndex + 1; i <= rightIndex ; i++) {
			int pos = i;
			while(pos > leftIndex && array[pos].compareTo(array[pos - 1]) < 0){
				Util.swap(array,pos,pos-1);
				pos -= 1;
			}
		}
		INSERTIONSORT_APPLICATIONS += 1;
	}

	private void merge(T[] array, int leftIndex, int middle, int rightIndex){
		T[] aux = Arrays.copyOf(array, array.length);

		int i = leftIndex, j = middle + 1, k = leftIndex;

		while(i <= middle && j <= rightIndex){
			if(aux[i].compareTo(aux[j]) <= 0){
				array[k++] = aux[i++];
			}else{
				array[k++] = aux[j++];
			}
		}
		while(i <= middle){ array[k++] = aux[i++]; }
		while(j <= rightIndex){ array[k++] = aux[j++]; }

		MERGESORT_APPLICATIONS += 1;
	}

	


}
