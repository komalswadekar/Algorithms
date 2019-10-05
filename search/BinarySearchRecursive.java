/*
 * Binary search : To search a given element in an array repeatedly by dividing search interval in half.
 * Works only on sorted arrays
 * Worst case time complexity : O(log n)
 * Best case time complexity: O(1)
 * Worst case space complexity: O(1)
 */
package search;

public class BinarySearchRecursive {

	public int binarySearch(int arr[], int leftIndex, int rightIndex, int searchKey) {

		if (rightIndex >= leftIndex) {

			int middleIndex = (leftIndex + rightIndex) / 2;
			if (searchKey == arr[middleIndex])
				return middleIndex;
			else if (searchKey > arr[middleIndex])
				return binarySearch(arr, middleIndex + 1, rightIndex, searchKey);
			else
				return binarySearch(arr, leftIndex, middleIndex - 1, searchKey);
			
		}
		return -1;
	}

	public static void main(String args[]) {
		BinarySearchRecursive bs = new BinarySearchRecursive();
		int arr[] = { 1, 3, 4, 4, 8, 9, 9, 10, 11 };
		int searchKey = 9;

		int result = bs.binarySearch(arr, 0, arr.length - 1, searchKey);
		if (result == -1)
			System.out.println("Element not present in given array.");
		else
			System.out.println("Element found at position : " + result);
		// Here answer will be 6(second occurrence of 9)instead of 5(first
		// occurrence of 9).
		// This is because in second iteration 9 at 6th position is encountered
		// first in the process of finding middle element.
	}
}
