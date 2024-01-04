public class QuickSort extends SortingAlgorithm {
    @Override
    public void sortAsc(double[] values) {
        quickSort(values, 0, values.length - 1, true);
    }

    @Override
    public void sortDesc(double[] values) {
        quickSort(values, 0, values.length - 1, false);
    }

    private void quickSort(double[] values, int low, int high, boolean ascending) {
        if (low < high) {
            int pivotIndex = partition(values, low, high, ascending);
            quickSort(values, low, pivotIndex - 1, ascending);
            quickSort(values, pivotIndex + 1, high, ascending);
        }
    }

    private int partition(double[] values, int low, int high, boolean ascending) {
        double pivot = values[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (ascending ? values[j] < pivot : values[j] > pivot) {
                i++;
                double temp = values[i];
                values[i] = values[j];
                values[j] = temp;
            }
        }

        double temp = values[i + 1];
        values[i + 1] = values[high];
        values[high] = temp;

        return i + 1;
    }
}
