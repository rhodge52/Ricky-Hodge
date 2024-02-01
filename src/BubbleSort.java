import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    public static int[] createRandomArray(int arrayLength) {
        int[] randomArray = new int[arrayLength];
        Random random = new Random();

        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = random.nextInt(101); 
        }

        return randomArray;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int num : array) {
                writer.println(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readFileToArray(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            int count = 0;
            while (scanner.hasNextInt()) {
                count++;
                scanner.nextInt();
            }

            int[] result = new int[count];

            
            try (Scanner newScanner = new Scanner(new File(filename))) {
                newScanner.useDelimiter("\\D");

                for (int i = 0; i < count; i++) {
                    result[i] = newScanner.nextInt();
                }
            }

            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Generate an array of random integers and store it in a file");
            System.out.println("2. Read an existing file containing a list of integers, sort it, and store the sorted array in another file");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the length of the random array:");
                    int length = scanner.nextInt();
                    int[] randomArray = createRandomArray(length);
                    writeArrayToFile(randomArray, "randomArray.txt");
                    System.out.println("Random array generated and stored in 'randomArray.txt'");
                    break;

                case 2:
                    System.out.println("Enter the filename of the array to be sorted:");
                    String inputFileName = scanner.next();
                    int[] arrayToSort = readFileToArray(inputFileName);

                    if (arrayToSort != null) {
                        bubbleSort(arrayToSort);
                        writeArrayToFile(arrayToSort, "sortedArray.txt");
                        System.out.println("Array sorted and stored in 'sortedArray.txt'");
                    }
                    break;

                case 3:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
