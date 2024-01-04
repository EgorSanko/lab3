import java.util.Arrays;
import java.util.Scanner;
public class RadixSort extends SortingAlgorithm {
    @Override
    public void sortAsc(double[] values) {
        int[] intValues = convertToIntegerArray(values);
        radixSort(intValues, true);
        convertBackToDoubleArray(intValues, values);
    }

    @Override
    public void sortDesc(double[] values) {
        int[] intValues = convertToIntegerArray(values);
        radixSort(intValues, false);
        convertBackToDoubleArray(intValues, values);
    }

    private void radixSort(int[] arr, boolean ascending) {
        // Находит максимальное число, чтобы узнать количество цифр
        int m = getMax(arr);

        // Выполняет подсчет для каждого разряда
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, exp, ascending);
        }
    }

    // Подсчет сортировки по разряду
    private void countSort(int[] arr, int exp, boolean ascending) {
        int n = arr.length;
        int[] output = new int[n]; // выходной массив
        int[] count = new int[10];

        Arrays.fill(count, 0);

        // Подсчет вхождений в arr[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Изменение count[], чтобы он содержал фактические позиции этих цифр в output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Построение выходного массива
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Копирование выходного массива в arr[], чтобы arr[] теперь содержал отсортированные числа
        for (int i = 0; i < n; i++) {
            arr[i] = ascending ? output[i] : output[n - 1 - i];
        }
    }
    private int[] convertToIntegerArray(double[] values) {
        int[] intValues = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            intValues[i] = (int) values[i];
        }
        return intValues;
    }

    private void convertBackToDoubleArray(int[] intValues, double[] values) {
        for (int i = 0; i < intValues.length; i++) {
            values[i] = intValues[i];
        }
    }

    private int getMax(int[] arr) {
        int mx = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }
}
