package org.lukas.javach;

public class InsertionSort {
	private static final int SIZE = 10;
	private static final int BOUND = 100;
	
	public static void main(String[] args){
		BubleSort buble = new BubleSort();
		int[] array = buble.genTable(SIZE, BOUND);
		buble.printTable(array);
		InsertionSort insert = new InsertionSort();
		int[] result = insert.sort(array);
		buble.printTable(result);
	}
	
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
	
	private int[] moveElements(int clearPosition, int[] array){
		for(int i = array.length-1; i > clearPosition; i--){
			array[i] = array[i-1];
		}
		return array;
	}
	
	private int findPosition(int[] array, int element, int count){
		for(int i = 0; i < count; i++){
			if(array[i] > element){
				return i;
			}
		}
		return count;
	}
	
}
