
// dot_gitignore : David Chen, Jaylen Zeng, Yat Long Chan
// APCS pd7
// HW55 - Time complexities for oal methods
// 2022-01-12
// time spent:  0 hrs

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
    // It will always take the same amount of time to get the value at index regardless of array size.
    public Integer get(int index) {
        return _list.get(index);
    }

    // remove the value at the specified index
    // Best case is when index is the last index of the array because then, no elements need to be shifted.
    // Worst case is when index = 0 because then, size - 1 elements need to be shifted.
    public Integer remove(int index) {
        return _list.remove(index);
    }

    // returns the size of the list
    // no best or worst case.
    public int size() {
        return _list.size();
    }

    // Best case is when value is placed at index 0 or at index length - 1.
    // No worst case
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
    
    // Best case is when newVal can be inserted into the middle of the array. 
    // In this case binary search can just terminate after 1 iteration and only half of the elements need to be moved.
    
    // Worst case is when newVal needs to be placed at index 0. 
    // This is the worst case for both binary search and the ArrayList add method, making it the worst case for addBinary.

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