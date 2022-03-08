public class FastSelect {
    public static void swap(int x, int y, int[] o) {
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
    }

    public static int partition(int arr[], int lo, int hi, int pvtIndex) {
        int pvt = arr[pvtIndex];

        swap(pvtIndex, hi, arr);

        int swapIndex = lo;
        for (int i = lo; i < hi - 1; i++) {
            if (arr[i] < pvt) {
                swap(swapIndex, i, arr);
                swapIndex++;
            }
        }
        swap(hi, swapIndex, arr);

        return swapIndex;
    }

    public static int fastSelect(int[] arr, int y) {
        return 0;
    }

    public static void main(String[] args) {

    }
}