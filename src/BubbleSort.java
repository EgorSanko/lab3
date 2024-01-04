public class BubbleSort extends SortingAlgorithm {
    @Override
    public void sortAsc(double[] values) {
        // Реализация пузырьковой сортировки по возрастанию
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    double temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void sortDesc(double[] values) {
        // Реализация пузырьковой сортировки по убыванию
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] < values[j + 1]) {
                    double temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }
}

