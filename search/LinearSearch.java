/*
 * Linear search to search element x in given array[] until the element is found
 * If x is present returns its position in array else returns -1
 * Works with sorted and unsorted arrays
 * author Komal Soham Wadekar
 */
package search;

public class LinearSearch {

	public int search(int arr[], int searchItem) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == searchItem)
				return i;
		}
		return -1;
	}

	public static void main(String args[]) {
		int arr[] = { 2, 7, 19, 8, 25, 8, 19, 0, 5 };
		int searchItem = 8;
		LinearSearch linear = new LinearSearch();
		int result = linear.search(arr, searchItem);
		if (result == -1)
			System.out.print("Element not present in given array.");
		else
			System.out.print("Element found at position: " + result);

	}
}
