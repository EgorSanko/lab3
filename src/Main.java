import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        final int[] sizes = {100, 1000, 10000, 100000}; // Для примера возьмем массивы меньшего размера

        // Создаем экземпляры всех алгоритмов сортировки
        SortingAlgorithm[] sortingAlgorithms = {
                new QuickSort(),
                new MergeSort(),
                new InsertionSort(),
                new SelectionSort(),
                new HeapSort(),
                new RadixSort(),
                new BubbleSort()
        };

        // Запускаем тестирование для каждого размера массива
        for (int size : sizes) {
            System.out.println("Размер массива: " + size);
            double[] array = new double[size];

            // Тестируем каждый алгоритм сортировки
            for (SortingAlgorithm sortingAlgorithm : sortingAlgorithms) {
                // Заполняем массив случайными числами
                for (int i = 0; i < size; i++) {
                    array[i] = Math.round(random.nextDouble() * 100.0 * 100.0) / 100.0;
                }

                // Измеряем время сортировки по возрастанию
                long startTimeAsc = System.nanoTime();
                sortingAlgorithm.sortAsc(array);
                long durationAsc = System.nanoTime() - startTimeAsc;

                // Измеряем время сортировки по убыванию
                for (int i = 0; i < size; i++) {
                    array[i] = Math.round(random.nextDouble() * 100.0 * 100.0) / 100.0;
                }
                long startTimeDesc = System.nanoTime();
                sortingAlgorithm.sortDesc(array);
                long durationDesc = System.nanoTime() - startTimeDesc;

                // Выводим результаты
                String algorithmName = sortingAlgorithm.getClass().getSimpleName();
                System.out.println(algorithmName + ": По возрастанию - " + durationAsc / 1e6 + " мс, По убыванию - " + durationDesc / 1e6 + " мс");
            }
        }
    }
}


