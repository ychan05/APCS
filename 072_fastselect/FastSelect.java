//Under Pressure: Yat Long Chan, Anjini Katari, Julia Kozak
//apcs
// HW72 -- So So Fast
// 2022-03-08t
//time spent: 0.5 hr 

/**
 * ALGO
 * Modify the partition method to return the final index at which the correctly placed value is swapped to. 
 * The ythSmallestHelper method will take an array with hi and lo indices, 
 * then call partition and store the value returned, pos. 
 * If the returned value is our target (position y-1) or hi crosses lo, 
 * it will return the value at that position. Otherwise, it will call itself again depending on the returned value, 
 * calling again on the values below the partition for pos less than the target, and the values above otherwise.
 * 
 * 
 * BEST CASE
 * O(n) 
 * Element at original pivot index is the yth smallest value. 
 * Only one partition needs to be run.
 * 
 * WORST CASE
 * O(n*n)
 * When pivot index isn't the yth smallest value.
 * Element at original pivot index is one of the extremes if the array were sorted.
 * In this case, the partitions will be uneven, with a majority of the elements on one side of the partition.
 * Then, partitions will have to be run for each smaller array.
 * 
 * DISCO
 * Best and Worst cases significantly alter time complexity.
 * Splitting the array is similar to binary search.
 * Average case is O(n).
 * 
 * QCC
 * What would be the optimal starting pivot? 
 * In the case that 2 functions do the same task, would the recursive flavored function have a different time complexity than iterative one? 
 * We always test the worst and best case scenarios, but do we care about the average ones?
 */

public class FastSelect {


    public static void swap(int x, int y, int[] o) {
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
    }

    public static int partition(int arr[], int lo, int hi, int pvtIndex) {
        int pvt = arr[pvtIndex];

        swap(pvtIndex, hi, arr);

        int storIndex = lo;
        for (int i = lo; i < hi - 1; i++) {
            if (arr[i] < pvt) {
                swap(storIndex, i, arr);
                storIndex++;
            }
        }
        swap(hi, storIndex, arr);

        return storIndex;
    }

    public static int ythSmallestHelper(int[] arr, int lo, int hi, int y) {
        //primary base case: 1 element array 
        if (lo == hi) {return arr[lo];} 

        //partition the array.
        int pos = partition(arr, lo, hi, y-1);

        //other base case: final index of pivot after partition is == to pos of y  
        if (pos == y - 1) {return arr[pos];}

        //final pivot index > y pos, yth smallest is at lower partition.
        if (pos > y - 1) {return ythSmallestHelper(arr, lo, pos, y);}

        //final pivot index < y pos, yth smallest is at upper partition.
        return ythSmallestHelper(arr, pos + 1, hi, y);

    }

    public static int ythSmallest(int[] arr, int y) {
        return ythSmallestHelper(arr, 0, arr.length - 1, y);
    }

    public static void main(String[] args) {
        int[] a1 = {1,7,3,12,5};

        System.out.println(ythSmallest(a1, 1)); // best case
        System.out.println(ythSmallest(a1, 4)); // worst case.
        
    }
}