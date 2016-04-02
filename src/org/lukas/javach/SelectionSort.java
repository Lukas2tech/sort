package org.lukas.javach;

public class SelectionSort {
	private static final int SIZE = 10;
	private static final int BOUND = 100;
	
	public static void main(String[] args){
		BubleSort buble = new BubleSort();
		int[] array = buble.genTable(SIZE, BOUND);
		buble.printTable(array);
		SelectionSort select = new SelectionSort();
		select.sort(array);
		buble.printTable(array);
	}
	
	public void sort(int[] array){
		int temp,position;
		for(int i = 0; i < array.length; i++){
			position = findMin(array, i);
			temp = array[position];
			array[position] = array[i];
			array[i] = temp;
		}
	}
	
	private int findMin(int[] array, int start){
		int position = start;
		for(int i = start; i < array.length; i++){
			if(array[i] < array[position]){
				position = i;
			}
		}
		return position;
	}
}
