import javax.swing.JOptionPane;
import java.util.Arrays;
public class SortArray {
    public static void main(String[] args) {
        String nStr = JOptionPane.showInputDialog("Enter number of elements:");
        if (nStr == null) return;
        int n = Integer.parseInt(nStr);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            String elem = JOptionPane.showInputDialog("Enter element " + (i+1) + ":");
            if (elem == null) return;
            arr[i] = Integer.parseInt(elem);
        }
        InsertionSort(arr);
        int sum = 0;
        for (int x : arr) sum += x;
        double avg = (double) sum / n;

        JOptionPane.showMessageDialog(null,
                "Sorted array (Insertion Sort): " + Arrays.toString(arr) +
                "\nSum = " + sum +
                "\nAverage = " + avg);
    }
    public static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];      
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
