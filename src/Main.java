package src;

import java.util.Scanner;

public class Main {

  public static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    labExam(); //main Application program
  }

  public static void labExam() {

      //creates an object of Dynamic array
    DynamicArray array = new DynamicArray();
    while (true) {
      String choice = readString(
          """
                1. Add Element
                2. Clear Array
                3. Find the Sum of Highest Even and Odd
                4. Display the indices of all occurence of Element
                5. Replace all occurence of Element
                6. Find the second largest element
                7. Remove Duplicates
                8. Exit
              """);

      switch (choice) {

        case "1" -> {
          int input = readInt("Enter an integer to add:", Integer.MIN_VALUE, Integer.MAX_VALUE);
          array.addElement(input);
        }
        case "2" -> array.clear();
        case "3" -> {
          int sum = array.sum_of_highest_even_and_odd();
          System.out.println("Sum of highest even and odd: " + sum);
        }
        case "4" -> {
          int target = readInt("Enter the element to find:", Integer.MIN_VALUE, Integer.MAX_VALUE);
          array.findIndices(target);
        }
        case "5" -> {
          int oldValue = readInt("Enter the element to replace:", Integer.MIN_VALUE, Integer.MAX_VALUE);
          int newValue = readInt("Enter the new value:", Integer.MIN_VALUE, Integer.MAX_VALUE);
          array.replaceAllMatch(oldValue, newValue);
          System.out.println("Array after replacement:");
          printArray(array.getArray(), array.getSize());
        }
        case "6" -> {
          int secondLargest = array.findNumberBeforeMax();
          if (secondLargest != Integer.MIN_VALUE) {
            System.out.println("Second largest element: " + secondLargest);
          } else {
            System.out.println("No second largest element found.");
          }
        }
        case "7" -> {
          array.removeDuplicates();
          System.out.println("Array after removing duplicates:");
          printArray(array.getArray(), array.getSize());
        }
        case "8" -> {
          System.out.println("Exiting program.");
          return; // Exit the method and terminate the program
        }

      }

    }

  }

    /**
     * Prints the content of the array
     * @param array The array to print
     * @param size The array number of elements
     */

  public static void printArray(int[] array, int size) {
    for (int i = 0; i < size; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  /**
   * Utility method for reading string input from user.
   *
   * Displays prompt, reads user input, and trims whitespace.
   * Provides consistent input handling across the application.
   *
   * @param prompt Message to display to user
   * @return User's input with leading/trailing whitespace removed
   */
  private static String readString(String prompt) {
    System.out.println(prompt);
    System.out.print(">> ");
    return scan.nextLine().trim(); // Remove leading/trailing spaces
  }

  /**
   * Utility method for reading and validating integer input.
   *
   * Provides input validation with range checking and error handling.
   * Continues prompting until valid input is received.
   *
   * @param prompt Message to display to user
   * @param min    Minimum acceptable value (inclusive)
   * @param max    Maximum acceptable value (inclusive)
   * @return Valid integer within specified range
   */
  private static int readInt(String prompt, int min, int max) {
    while (true) {
      System.out.println(prompt);
      System.out.print(">> ");
      try {
        int userInput = Integer.parseInt(scan.nextLine());

        // Validate input is within acceptable range
        if (userInput < min || userInput > max) {
          System.out.printf(
              "Enter a value between %d and %d.%n",
              min,
              max);
          continue; // Re-prompt for valid input
        }
        return userInput; // Valid input received
      } catch (NumberFormatException e) {
        System.out.println("Not a number. Try Again.");
        // Loop continues to re-prompt user
      }
    }
  }

}
