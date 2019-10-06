/*
 * Jump Search Algorithm
 * Jumps ahead by fixed steps to find a block which might contain given element
 * and then that block is searched linearly.
 * Works with the sorted arrays.
 * Author : Komal Soham Wadekar
 */
package search;

public class JumpSearch {

	public int jumpSearch(int arr[], int key) {

		int jumpStep = (int) Math.floor(Math.sqrt(arr.length));
		int leftIndex = 0, rightIndex = 0;

		while (leftIndex <= arr.length - 1 && arr[leftIndex] <= key) {
			rightIndex = Math.min(arr.length - 1, leftIndex + jumpStep);

			if (arr[leftIndex] <= key && arr[rightIndex] >= key)
				break;
			leftIndex += jumpStep;
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (arr[i] == key)
				return i;
		}
		return -1;

	}

	public static void main(String args[]) {
		int arr[] = { 1, 3, 5, 8, 9, 16, 20, 25, 30, 27, 42, 49, 50, 51,56 };
		JumpSearch js = new JumpSearch();
		int result = js.jumpSearch(arr, 51);
		if (result == -1)
			System.out.println("Element is not present in the array.");
		else
			System.out.println("Element is present at position: " + result);
	}
}
