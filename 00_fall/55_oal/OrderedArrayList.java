
// dot_gitignore : David Chen, Jaylen Zeng, Yat Long Chan
// APCS pd7
// HW55 - Time complexities for oal methods
// 2022-01-12
// time spent:  0.4 hrs
/**
 * DISCO
 * Big-O is dependent on iterations
 * QCC
 * none
 **/

import java.util.ArrayList;

public class OrderedArrayList {
    private ArrayList<Integer> _list;

    public OrderedArrayList() {
        _list = new ArrayList<Integer>();
    }

    // return the string representation of the list
    public String toString() {
        return _list.toString();
    }

    // gets the value at the specified index
    // No best or worst case. 
    // O(1), it will always take the same amount of time to get the value at index regardless of array size.
    public Integer get(int index) {
        return _list.get(index);
    }

    // remove the value at the specified index
    // Best case : O(1), removed element is last element of OrderedArrayList because no shifts are required.
    // Worst case: O(n), removed element is first element of OrderedArrayList because n - 1 elements need to be shifted.
    public Integer remove(int index) {
        return _list.remove(index);
    }

    // returns the size of the list
    // no best or worst case.
    // O(1), method only makes one operation to return the size of OrderedArrayList.
    public int size() {
        return _list.size();
    }

    // If added element belongs at index 0 of OrderedArrayList. Only 1 comparison needs to be made but array need to be shifted.
    // If added element belongs at end of OrderedArrayList. Must iterate thru entire OrderedArrayList but only one element shifted. 
    // No best or worst case. Time complexity: O(n) 
    public boolean addLinear(Integer value) {
        int i = 0;
        while (i < _list.size()) {
            if (value.compareTo(_list.get(i)) < 0) {
                _list.add(i, value);
                return true;
            }
            i++;
        }
        _list.add(value);
        return true;
    }


    // use binary search to find the correct index and add newVal
    
    // Best case: O(n), element belongs at middle of OrderedArrayList. Only one comparison needs to be made but array needs to be shifted.
    // Worst case: O(n), element belongs at end or beginning of OrderedArrayList. log_2(n) searches must be made and all elements must be shifted right.   
    public boolean addBinary(Integer newVal) {
        int low = 0;
        int high = _list.size() - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            int compare = newVal.compareTo(_list.get(mid));
            if (compare == 0) {
                _list.add(mid, newVal);
                return true;
            } else if (compare < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        _list.add(low, newVal);
        return true;
    }

    public static void main(String[] args) {
        OrderedArrayList list = new OrderedArrayList();
        System.out.println("Printing empty OrderedArrayList: \n" + list);

        for (int i = 0; i < 10; i++) {
            list.addLinear((int) (Math.random() * 100));
        }

        // list.addBinary(76);

        System.out.println("Printing OrderedArrayList with 10 random values from 1 to 100: \n" + list);

        System.out.println("Removing value at index 3: \n" + list.remove(3));

        System.out.println("Printing OrderedArrayList after removing value at index 3: \n" + list);

        OrderedArrayList list2 = new OrderedArrayList();
        for (int i = 0; i < 10; i++) {
            list2.addBinary((int) (Math.random() * 100));
        }
        System.out.println("Printing OrderedArrayList with 10 random values from 1 to 100: \n" + list2);
    }
}