public class MergeSort extends SortingAlgorithm {
    @Override
    public void sortAsc(double[] values) {
        mergeSort(values, 0, values.length - 1, true);
    }

    @Override
    public void sortDesc(double[] values) {
        mergeSort(values, 0, values.length - 1, false);
    }

    private void mergeSort(double[] array, int left, int right, boolean ascending) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(array, left, middle, ascending);
            mergeSort(array, middle + 1, right, ascending);
            merge(array, left, middle, right, ascending);
        }
    }

    private void merge(double[] array, int left, int middle, int right, boolean ascending) {
        double[] leftArray = new double[middle - left + 1];
        double[] rightArray = new double[right - middle];

        System.arraycopy(array, left, leftArray, 0, leftArray.length);
        System.arraycopy(array, middle + 1, rightArray, 0, rightArray.length);

        int i = 0, j = 0;
        int k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (ascending ? leftArray[i] <= rightArray[j] : leftArray[i] >= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
