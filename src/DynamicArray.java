package src;

public class DynamicArray {

  private int[] array;
  private int capacity;
  private int size;

  public DynamicArray() {
    this.capacity = 1;
    this.size = 0;
    this.array = new int[capacity];
  }

  public DynamicArray(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.array = new int[capacity];
  }
  //necessary getters
  public int[] getArray() {
    return this.array;
  }

  public int getSize() {
    return this.size;
  }

  /**
  * Method to resize the capacity of the array
  * Twice the prev. capacity
  */
  public void resize() {
    capacity *= 2;
    int[] newArray = new int[capacity];

    for (int i = 0; i < size; i++) {
      newArray[i] = array[i];
    }
    array = newArray;
  }

  /**
  * Method to add Element in the array
  * @param value Value to be added in array
   */
  public void addElement(int value) {
    if (size == capacity) {
      resize();
    }
    array[size] = value;
    size++;
  }

 //Method to clear the contents of the array
  public void clear() {

    for (int i = 0; i < size; i++) {
      array[i] = 0;
    }
    size = 0;
  }

  /**
  * Method to find the sum of the highest even
  * and highest odd number of the array
  * @return Sum of two number
   */
  public int sum_of_highest_even_and_odd() {
    int max_even = Integer.MIN_VALUE;
    int max_odd = Integer.MIN_VALUE;

    for (int i = 0; i < size; i++) {
      if (array[i] % 2 == 0 && array[i] > max_even) {
        max_even = array[i];
      } else if (array[i] % 2 != 0 && array[i] > max_odd) {
        max_odd = array[i];
      }
    }

    System.out.println("Max even: " + max_even);
    System.out.println("Max odd: " + max_odd);

    return max_even + max_odd;
  }
/**
 * Method to find the indices of an Element
 * @param value Target element to find its indices
 */
  public void findIndices(int value) {

    System.out.printf("Element %d found at Indices: ", value);

    for (int i = 0; i < size; i++) {
      if (value == array[i]) {
        System.out.print(i + " ");
      }
    }
    System.out.println();
  }

    /**
     * Method to replace all occurrence of a target
     * @param value Original value
     * @param newValue new value to replace 'value'
     */
  public void replaceAllMatch(int value, int newValue) {

    for (int i = 0; i < size; i++) {
      if (array[i] == value) {
        array[i] = newValue;
      }
    }

  }
/**
* Method to find the second-largest number of array
 * @return Value of second-largest number
* */
  public int findNumberBeforeMax() {
    int max = Integer.MIN_VALUE;
    int beforeMax = Integer.MIN_VALUE;
    for (int i = 0; i < size; i++) {
      if (array[i] > max) {
        beforeMax = max;
        max = array[i];
      } else if (array[i] > beforeMax && array[i] != max) {
        beforeMax = array[i];
      }
    }
    return beforeMax;
  }

  /*
  * Method to remove all duplicate elements
  * in the array
  * */

  public void removeDuplicates() {

    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        if (array[i] == array[j]) {
          // Shift elements to the left
          for (int k = j; k < size - 1; k++) {
            array[k] = array[k + 1];
          }
          size--;
          j--; // Decrement j to check the new element at this position
        }
      }
    }
  }

}
