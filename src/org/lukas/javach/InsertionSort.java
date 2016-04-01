package org.lukas.javach;

/**
 * @author Lukas
 *
 */

public class InsertionSort {
	private static final int SIZE = 10;
	private static final int BOUND = 100;
	
	/**
	 * 
	 * @param args Command line parameters
	 */
	public static void main(String[] args){
		BubleSort buble = new BubleSort();
		int[] array = buble.genTable(SIZE, BOUND);
		buble.printTable(array);
		InsertionSort insert = new InsertionSort();
		int[] result = insert.sort(array);
		buble.printTable(result);
	}
	
	/**
	 * 				
	 * @param array The array that is going to be sorted.
	 * @return Return the sorted array object.
	 */
	public int[] sort(int[] array){
		int[] result = new int[SIZE];
		int position = 0;
		result[0] = array[0];
		for(int i = 1; i < array.length; i++){
			position = findPosition(result, array[i], i);
			if(position == i){
				result[position] = array[i];
			} else{
				result = moveElements(position, result);
				result[position] = array[i];
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param clearPosition The position that is need to be cleared for element insertion.
	 * @param array The sorted result array.
	 * @return Returns the sorted array with free space for insert the searched element.
	 */
	private int[] moveElements(int clearPosition, int[] array){
		for(int i = array.length-1; i > clearPosition; i--){
			array[i] = array[i-1];
		}
		return array;
	}
	
	/**
	 * 
	 * @param array The sorted result array.
	 * @param element The element that is going to be inserted into the sorted array.
	 * @param count The number of elements that are already in the sorted array.
	 * @return Returns the position where the element is going to be inserted.
	 */
	private int findPosition(int[] array, int element, int count){
		for(int i = 0; i < count; i++){
			if(array[i] > element){
				return i;
			}
		}
		return count;
	}
	
}
