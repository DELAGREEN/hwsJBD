package hw01;
import java.util.Arrays;
import java.util.Scanner;

public class Main { 

    // Функции для целочисленных массивов
    
    // Нахождение максимального значения (целочисленный массив)
    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    // Нахождение минимального значения (целочисленный массив)
    public static int findMin(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    
    // Нахождение среднего значения (целочисленный массив)
    public static double findAverage(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }
    
    // Сортировка по возрастанию (целочисленный массив)
    public static void sortAscending(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        // Используем алгоритм пузырьковой сортировки
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Обмен элементов
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    // Сортировка по убыванию (целочисленный массив)
    public static void sortDescending(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        // Используем алгоритм пузырьковой сортировки
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    // Обмен элементов
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    // Функции для дробных массивов
    
    // Нахождение максимального значения (дробный массив)
    public static double findMax(double[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    // Нахождение минимального значения (дробный массив)
    public static double findMin(double[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    
    // Нахождение среднего значения (дробный массив)
    public static double findAverage(double[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
    }
    
    // Сортировка по возрастанию (дробный массив)
    public static void sortAscending(double[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        // Используем алгоритм пузырьковой сортировки
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Обмен элементов
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    // Сортировка по убыванию (дробный массив)
    public static void sortDescending(double[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        // Используем алгоритм пузырьковой сортировки
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    // Обмен элементов
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    //Печать массивов int
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    //Печать массивов double

    public static void printArray(double[] array) {
        System.out.println(Arrays.toString(array));
    }


// Основная функция
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ввод размера массива
        System.out.print("Введите размер массива: ");
        int sizeArray = scanner.nextInt();
        
        if (sizeArray <= 0) {
            System.out.println("Ошибка: размер массива должен быть больше 0");
            scanner.close();
            return;
        }
        
        // Выбор типа массива
        System.out.print("Выберите тип массива (1 - целочисленный, 2 - дробный): ");
        int typeChoice = scanner.nextInt();
        
        // Ввод границ генерации
        System.out.print("Введите нижнюю границу генерации: ");
        double lowerBound = scanner.nextDouble();
        System.out.print("Введите верхнюю границу генерации: ");
        double upperBound = scanner.nextDouble();
        
        if (lowerBound >= upperBound) {
            System.out.println("Ошибка: нижняя граница должна быть меньше верхней");
            scanner.close();
            return;
        }
        
        if (typeChoice == 1) {
            // Работа с целочисленным массивом
            int[] intArray = new int[sizeArray];
            
            // Заполнение массива случайными числами
            for (int i = 0; i < sizeArray; i++) {
                intArray[i] = (int)(Math.random() * (upperBound - lowerBound) + lowerBound);
            }
            
            System.out.println("\nСгенерированный массив:");
            printArray(intArray);
            
            // Вычисление и вывод статистики
            System.out.println("Максимальное значение: " + findMax(intArray));
            System.out.println("Минимальное значение: " + findMin(intArray));
            System.out.println("Среднее значение: " + String.format("%.2f", findAverage(intArray)));
            
            // Сортировка по возрастанию
            int[] ascendingArray = intArray.clone();
            sortAscending(ascendingArray);
            System.out.println("Отсортированный по возрастанию:");
            printArray(ascendingArray);
            
            // Сортировка по убыванию
            int[] descendingArray = intArray.clone();
            sortDescending(descendingArray);
            System.out.println("Отсортированный по убыванию:");
            printArray(descendingArray);
            
        } else if (typeChoice == 2) {
            // Работа с дробным массивом
            double[] doubleArray = new double[sizeArray];
            
            // Заполнение массива случайными числами
            for (int i = 0; i < sizeArray; i++) {
                doubleArray[i] = Math.random() * (upperBound - lowerBound) + lowerBound;
            }
            
            System.out.println("\nСгенерированный массив:");
            printArray(doubleArray);
            
            // Вычисление и вывод статистики
            System.out.println("Максимальное значение: " + String.format("%.2f", findMax(doubleArray)));
            System.out.println("Минимальное значение: " + String.format("%.2f", findMin(doubleArray)));
            System.out.println("Среднее значение: " + String.format("%.2f", findAverage(doubleArray)));
            
            // Сортировка по возрастанию
            double[] ascendingArray = doubleArray.clone();
            sortAscending(ascendingArray);
            System.out.println("Отсортированный по возрастанию:");
            printArray(ascendingArray);
            
            // Сортировка по убыванию
            double[] descendingArray = doubleArray.clone();
            sortDescending(descendingArray);
            System.out.println("Отсортированный по убыванию:");
            printArray(descendingArray);
            
        } else {
            System.out.println("Ошибка: неверный выбор типа массива");
        }
        
        scanner.close();
    }
}