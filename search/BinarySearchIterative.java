/*
 * Binary search using iterative approach
 * Author: Komal Soham Wadekar
 */
package search;

public class BinarySearchIterative {

	public int binarySearch(int arr[], int leftIndex, int rightIndex, int searchKey) {
		int middleIndex = 0;
		while (rightIndex >= leftIndex) {
			middleIndex = (rightIndex + leftIndex) / 2;
			if (searchKey == arr[middleIndex])
				return middleIndex;
			else if (searchKey > arr[middleIndex])
				leftIndex = middleIndex + 1;
			else
				rightIndex = middleIndex - 1;
		}
		return -1;
	}

	public static void main(String args[]) {
		BinarySearchIterative bs = new BinarySearchIterative();
		int arr[] = { 1, 3, 4, 4, 8, 9, 9, 10, 11 };
		int searchKey = 11;
		int result = bs.binarySearch(arr, 0, arr.length - 1, searchKey);
		if (result == -1)
			System.out.println("Element is not present in array.");
		else
			System.out.println("Element present at position: " + result);
	}
}
