package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			int proximoUltimo = rightIndex;

			for (int j = leftIndex; j < rightIndex; j++) {
				boolean fezTroca = false;
				for (int i = leftIndex; i < proximoUltimo; i++) {
					if (array[i].compareTo(array[i + 1]) > 0) {
						Util.swap(array, i, i + 1);
						fezTroca = true;
					}
				}
				if(!fezTroca){
					break;
				}
				proximoUltimo -= 1;
			}

		}
	}



}
