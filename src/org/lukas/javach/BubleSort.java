package org.lukas.javach;

import java.util.Random;

/**
 * @author Lukas
 * @version 0.1 Snapshot 
 * 
 */
public class BubleSort {
	
	public static void main(String[] args) {
		BubleSort buble = new BubleSort();
		int[] table = buble.genTable(10000, 100);
		buble.printTable(table);
		buble.sortTable(table);
		buble.printTable(table);
	}
	
	/**
	 * 
	 * @param table The input parameter is a array containing integer that is going to be sorted.
	 */
	public void sortTable(int[] table) {
		int count = 0;
		long time = System.currentTimeMillis();
		do {
			count = bubleElements(table);
		} while (count != 0);
		System.out.println(
				"The time spend on table sorting was : " + (System.currentTimeMillis() - time) + "[milliseconds]");
	}
	/**
	 * 
	 * @param table The array that is going to be printed.
	 */
	public void printTable(int[] table) {
		for (int i = 0; i < table.length; i++) {
			System.out.print(i == 0 ? table[i] : " | " + table[i]);
		}
		System.out.println("\n\n");
	}

	/**
	 * 
	 * @param size The size of the generated array.
	 * @param bound The bound of the generated elements. [0, bound)
	 * @return The generated array of integers.
	 */
	public int[] genTable(int size, int bound) {
		int[] result = new int[size];
		Random random = new Random();
		for (int i = 0; i < result.length; i++) {
			result[i] = random.nextInt(bound);
		}
		return result;
	}
	
	/**
	 * 
	 * @param table The table on witch the buble sorting operation is going to take place.
	 * @return  If no changes to the table take place the method returns 0.
	 */
	private int bubleElements(int[] table) {
		int count = 0;
		for (int i = table.length - 1; i > 0; i--) {
			if (table[i] < table[i - 1]) {
				int temp = table[i];
				table[i] = table[i - 1];
				table[i - 1] = temp;
				count++;
			}
		}
		return count;
	}

}
