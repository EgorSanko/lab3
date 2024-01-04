public class HeapSort extends SortingAlgorithm {
    @Override
    public void sortAsc(double[] values) {
        int n = values.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(values, n, i, true);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            double temp = values[0];
            values[0] = values[i];
            values[i] = temp;

            // вызываем процедуру heapify на уменьшенной куче
            heapify(values, i, 0, true);
        }
    }

    @Override
    public void sortDesc(double[] values) {
        int n = values.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(values, n, i, false);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            double temp = values[0];
            values[0] = values[i];
            values[i] = temp;

            // вызываем процедуру heapify на уменьшенной куче
            heapify(values, i, 0, false);
        }
    }

    void heapify(double[] arr, int n, int i, boolean ascending) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && (ascending ? arr[l] > arr[largest] : arr[l] < arr[largest]))
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент до сих пор
        if (r < n && (ascending ? arr[r] > arr[largest] : arr[r] < arr[largest]))
            largest = r;

        // Если самый большой элемент не корень
        if (largest != i) {
            double swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем затронутую подкучу
            heapify(arr, n, largest, ascending);
        }
    }
}
