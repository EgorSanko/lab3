public class SelectionSort extends SortingAlgorithm {
    @Override
    public void sortAsc(double[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < values[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = values[minIndex];
            values[minIndex] = values[i];
            values[i] = temp;
        }
    }

    @Override
    public void sortDesc(double[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] > values[maxIndex]) {
                    maxIndex = j;
                }
            }
            double temp = values[maxIndex];
            values[maxIndex] = values[i];
            values[i] = temp;
        }
    }
}
