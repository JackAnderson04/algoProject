import java.util.ArrayList;

public class mergeSort {

    void merge(int arr[], int left, int mid, int right)
    {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;
 
        // Create temp arrays
        int Left[] = new int[n1];
        int Right[] = new int[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            Left[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            Right[j] = arr[mid + 1 + j];
 
        // Merge the temp arrays
 
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                arr[k] = Left[i];
                i++;
            }
            else {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = Left[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int left, int right)
    {
        if (left < right) {
 
            // Find the middle point
            int mid = left + (right - left) / 2;
 
            // Sort first and second halves
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
 
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = { 6, 5, 5, 12, 5};
        int n = arr.length;
        ArrayList<String> name2 = new ArrayList<String>(n);
        String names[] = {"kevin", "max", "Phil", "James", "Mark"};
        ArrayList<Integer> temp = new ArrayList<Integer>(n);
        for (int i = 0; i < n; ++i) {
    	    temp.add(arr[i]);
    	    name2.add(names[i]);
        }
        
        mergeSort object = new mergeSort();
        object.sort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        ArrayList<String> final2 = new ArrayList<String>(n);
        
        for (int i = 0; i < n; ++i) {
           //System.out.print(arr[i] + " ");
           int index = temp.indexOf(arr[i]);
           //System.out.print(name2.get(index) + " ");
           final2.add(name2.get(index));
           temp.remove(index);
           name2.remove(index);
        //System.out.println();
        }
        System.out.print(final2);
     }
}
