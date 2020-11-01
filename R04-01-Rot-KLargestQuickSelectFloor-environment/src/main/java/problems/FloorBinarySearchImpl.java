package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if(array.length == 0){
			return null;
		}
		//Uma vez que ainda não sabemos qual o maior valor do array que é menor ao x, começamos com null, pois se não encontrarmos, essa deve ser a resposta
		return floorBinarySearch(array,x,0,array.length - 1, null);
	}



	private Integer floorBinarySearch(Integer[] array, Integer x, int leftIndex, int rightIndex,Integer menorAteAgora){
		quickSortMedianOfThree(array, leftIndex, rightIndex);
		int middle = (leftIndex + rightIndex)/2;
		if(leftIndex > rightIndex){
			return menorAteAgora;
		}
		if(x.equals(array[middle])){
			return array[middle];
		}else if(x < array[middle]){
			return floorBinarySearch(array,x,leftIndex,middle - 1,menorAteAgora);
		}else{
			menorAteAgora = array[middle];
			return floorBinarySearch(array,x,middle + 1,rightIndex,menorAteAgora);
		}
	}

	public void quickSortMedianOfThree(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			int pivot = partition(array, leftIndex, rightIndex);
			quickSortMedianOfThree(array, leftIndex, pivot - 1);
			quickSortMedianOfThree(array, pivot + 1, rightIndex);
		}

	}

	private int partition(Integer[] array, int leftIndex, int rightIndex){
		Integer pivot = array[pickMedianPivot(array,leftIndex,rightIndex)];
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

	private int pickMedianPivot(Integer[] array, int leftIndex, int rightIndex){
		int middle = (leftIndex + rightIndex)/2;
		int pivotIndex = leftIndex;
		if(array[leftIndex] >= array[middle] && array[leftIndex] >= array[rightIndex]){
			if(array[middle] >= array[rightIndex]){
				pivotIndex = middle;
			}else{
				pivotIndex = rightIndex;
			}
		}
		if(array[middle] >= array[leftIndex] && array[middle] > array[rightIndex]){
			if(array[leftIndex] >= array[rightIndex]){
				pivotIndex = leftIndex;
			}else{
				pivotIndex = rightIndex;
			}
		}
		if(array[rightIndex] >= array[leftIndex] && array[rightIndex] >= array[middle]){
			if(array[leftIndex] >= array[middle]){
				pivotIndex = leftIndex;
			}else{
				pivotIndex = middle;
			}
		}
		return pivotIndex;

	}





}
