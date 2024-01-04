import java.util.Random;

import java.util.Random;

public class PerformanceTester {
    private final int[] sizes = {100, 1000, 10000, 100000, 1000000}; // Размеры тестируемых массивов

    public void test(SortingAlgorithm... algorithms) {
        for (int size : sizes) {
            double[] array = new double[size];
            System.out.print(size); // Вывод размера тестируемого массива

            for (SortingAlgorithm algorithm : algorithms) {
                fillArrayWithRandomNumbers(array); // Заполнение массива случайными числами

                long startTime = System.nanoTime(); // Начало измерения времени
                algorithm.sortAsc(array); // Сортировка массива
                long endTime = System.nanoTime(); // Конец измерения времени

                long duration = (endTime - startTime) / 1000000; // Преобразование в миллисекунды
                System.out.print("\t" + duration); // Вывод времени сортировки
            }
            System.out.println(); // Новая строка для следующего размера массива
        }
    }

    private void fillArrayWithRandomNumbers(double[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextDouble() * 100000; // Заполнение массива случайными числами
        }
    }
}
