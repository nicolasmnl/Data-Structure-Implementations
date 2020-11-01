package sorting.divideAndConquer;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);

			merge(array, leftIndex, middle, rightIndex);

		}


	}

	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {

		T[] auxiliar = Arrays.copyOf(array, array.length);

		int i = leftIndex, j = middle + 1, k = leftIndex;
		while(i <= middle && j <= rightIndex){
			if(auxiliar[i].compareTo(auxiliar[j]) <= 0){
				array[k++] = auxiliar[i++];
			}else{
				array[k++] = auxiliar[j++];
			}
		}

		while (i <= middle){
			array[k++] = auxiliar[i++];
		}
		while (j <= rightIndex){
			array[k++] = auxiliar[j++];
		}


	}
}
