/*
 * Exponential Search Algorithm
 * Step 1 - Find the range in which the element might exist by repetitively doubling the range upper bound
 * Step 2 - Search the element using Binary Search in identified range
 * Worst case time complexity : O(log i) ; i= index of element to be searched.
 * Best case time complexity : O(1)
 * Space complexity : O(1) - Iterative binary search ; O(log n) - Recursive binary search
 * Author : Komal Soham Wadekar 
 */
package search;

import java.util.Scanner;

public class ExponentialSearch {

	public int exponentialSearch(int arr[], int key) {

		int rightIndex = 1;

		while (rightIndex <= arr.length - 1 && arr[rightIndex] < key) {
			rightIndex = Math.min(arr.length - 1, (rightIndex * 2));
		}

		if (arr[rightIndex] == key)
			return rightIndex;
		else
			return binarySearch(arr, rightIndex / 2, rightIndex, key);
	}

	public int binarySearch(int arr[], int leftIndex, int rightIndex, int key) {
		int middleIndex = 0;
		while (leftIndex <= rightIndex) {
			middleIndex = (leftIndex + rightIndex) / 2;
			if (arr[middleIndex] == key)
				return middleIndex;
			else if (arr[middleIndex] < key)
				leftIndex = middleIndex + 1;
			else
				rightIndex = middleIndex - 1;
		}
		return -1;
	}

	public static void main(String args[]) {
		ExponentialSearch es = new ExponentialSearch();
		Scanner sc = new Scanner(System.in);
		int arr[] = { 1, 3, 6, 8, 10, 14, 15, 17, 18, 40 };
		System.out.println("Enter the element to be serached: ");
		int key = sc.nextInt();
		sc.close();
		int result = es.exponentialSearch(arr, key);
		if (result == -1)
			System.out.println("Element is not present in the array.");
		else
			System.out.println("Element is present at position: " + result);
	}
}
