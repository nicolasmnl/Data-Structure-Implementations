package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

				int pivot = partition(array, leftIndex, rightIndex);
				sort(array, leftIndex, pivot - 1);
				sort(array, pivot + 1, rightIndex);
		}

	}

	private int partition(T[] array, int leftIndex, int rightIndex){
		T pivot = array[pickMedianPivot(array,leftIndex,rightIndex)];
		Util.swap(array,leftIndex,pickMedianPivot(array,leftIndex,rightIndex));
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if(array[j].compareTo(pivot) <= 0){
				i+= 1;
				Util.swap(array, j, i);
			}
		}

		Util.swap(array,leftIndex,i);

		return i;


	}

	private int pickMedianPivot(T[] array, int leftIndex, int rightIndex){
		int middle = (leftIndex + rightIndex)/2;
		int pivotIndex = leftIndex;
		if(array[leftIndex].compareTo(array[middle]) >= 0 && array[leftIndex].compareTo(array[rightIndex]) >= 0){
			if(array[middle].compareTo(array[rightIndex]) >= 0){
				pivotIndex = middle;
			}else{
				pivotIndex = rightIndex;
			}
		}
		if(array[middle].compareTo(array[leftIndex]) >= 0 && array[middle].compareTo(array[rightIndex]) >= 0){
			if(array[leftIndex].compareTo(array[rightIndex]) >= 0){
				pivotIndex = leftIndex;
			}else{
				pivotIndex = rightIndex;
			}
		}
		if(array[rightIndex].compareTo(array[leftIndex]) >= 0 && array[rightIndex].compareTo(array[middle]) >= 0){
			if(array[leftIndex].compareTo(array[middle]) >= 0){
				pivotIndex = leftIndex;
			}else{
				pivotIndex = middle;
			}
		}
		return pivotIndex;

	}
}
