// This bubble sort implementation is made as a school assignment.

package array_sorting;

public class Main {

    /**
     * Takes size and max number and returns an array with random values
     * @param length The size of the desired array.
     * @param max_n Max value of random integers.
     * @return Array of given size with random int values between 1 and max_n
     */
    private static int[] CreateArray(int length, int max_n){
        int[] array = new int[length];
        for (int n = 0; n < length; n++){
            array[n] = (int)(Math.random()*(max_n+1));
        }
        return array;
    }

    /**
     * Prints an int array in a table
     * @param array Array to print out
     * @param tableWidth Optional argument defining table width
     */
    private static void PrintArray(int[] array, int ...tableWidth){
        int columns = 10;
        if(1==tableWidth.length) columns = tableWidth[0]; // Override columns if tableWidth is provided

        int rows = array.length / columns;                // Calculate amount of rows.

        // Print all whole lines
        for (int row = 0; row < rows; row++){
            for (int column = 0; column < columns; column++)
                System.out.printf("%02d ", array[row*columns+column]);
            System.out.println();
        }

        // Print the remaining elements after all whole lines has been printed.
        if (array.length % columns != 0){
            for (int n = 0; n < array.length % columns; n++){
                System.out.printf("%02d ", array[rows*columns+n]);
            }
        }
        System.out.println("\n");
    }

    /**
     * Prints statistics for an int array statistics includes:
     * Min value, max value, mean and spread of the data set
     * @param array int array to be printed stats about
     */
    private static void PrintStats(int[] array){
        // Print stats
        System.out.println("Array length: " + array.length);
        System.out.println("Min value: " + array[0]);
        System.out.println("Max value: " + array[array.length-1]);
        System.out.println("Median: " + array[array.length/2]);
        double mean = getMean(array);
        System.out.printf("Mean value of data-set: %.1f\n", mean);
        System.out.printf("Spread: %.1f\n", getSpread(array, mean));
    }

    /**
     * Takes an array and returns a bottom-up sorted array
     * @param array Array to be sorted
     * @return Sorted version of passed array
     */
    private static int[] BubbleSort(int[] array){
        Boolean swapped;
        do {
            swapped = false;
            // Look over all elements of the array 2 at a time, switching the smallest element to the left.
            for(int n = 0; n < array.length-1; n++){
                if(array[n] > array[n+1]){
                    int first = array[n];
                    array[n] = array[n+1];
                    array[n+1] = first;
                    swapped = true;
                }
            }
        } while (swapped); // If no element has been swapped it's safe to assume that the array has been sorted

        return array;
    }

    /**
     * Takes array of integers and returns the mean value of the dataset
     * @param array Array of integers
     * @return Mean value of integers
     */
    private static double getMean(int[] array){
        int sum = 0;
        for(int value: array) sum += value;
        return (double) sum / array.length;
    }

    /**
     * Takes an array of integers and the mean value of the integers and returns the spread value.
     * @param array An array of integer
     * @param mean The mean value of the array of integers
     * @return The spread of the values in the int array.
     */
    private static double getSpread(int[] array, double mean){
        double summation = 0;
        for (int value: array){
            summation += Math.pow((value - mean), 2);
        }
        return Math.sqrt(summation/array.length-1);

    }

    public static void main(String[] args) {
	// Create array
	int[] RandIntArray = CreateArray(103, 99);

	// Print array pre sorting
	System.out.println("Before sorting:");
	PrintArray(RandIntArray);

    // Sort and print out the array
	RandIntArray = BubbleSort(RandIntArray);
    System.out.println("After sorting:");
	PrintArray(RandIntArray);

	// print array stats.
    PrintStats(RandIntArray);
    }
}
