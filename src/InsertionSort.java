public class InsertionSort extends SortingAlgorithm {
    @Override
    public void sortAsc(double[] values) {
        for (int i = 1; i < values.length; i++) {
            double key = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }
    }

    @Override
    public void sortDesc(double[] values) {
        for (int i = 1; i < values.length; i++) {
            double key = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] < key) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }
    }
}
