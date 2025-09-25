package hw01;
import java.util.Arrays;
import java.util.Scanner;

public class Main { // Добавлен класс
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        //Ввод размера массива
        System.out.println("Введите размер массива: ");
        int arraySize = scanner.nextInt();

        if(arraySize<=0){
            System.out.println("Размер массива не должен быть меньше 0");
            scanner.close();
            return;
        }
        
        //Выбор типа массива
        System.out.println("Выберите тип массива (1 - целочисленный, 2 - дробный): ");
        int typeChoice = scanner.nextInt();

        //Ввод границ генерации
        System.out.println("Введите нижнюю границу генерации миссива: ");
        double lowerBound = scanner.nextDouble();
        System.out.println("Введите верхнюю границу генерации массива: ");
        double upperBound = scanner.nextDouble();

        if (lowerBound >= upperBound) {
            System.out.println("Ошибка: нижняя граница должна быть меньше верхней");
            scanner.close();
            return;
        }

        if (typeChoice == 1) {
            //Работа с целочисленным массивом
            int[] intArray = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                intArray[i] = (int)(Math.random() * (upperBound - lowerBound) + lowerBound);
            }
            System.out.println("\nСгенерированный массив: ");
            System.out.println(Arrays.toString(intArray));


            
        }


    }
}