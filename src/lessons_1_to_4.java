
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class lessons_1_to_4 {
    private static Scanner read;
    private static Random random;

    public static void main(String[] args) {
        read = new Scanner(System.in);
        random = new Random();

        System.out.println("Выберите задание:");
        System.out.println("1. Задание 1 (a * b > 20)");
        System.out.println("2. Задание 2 (Нахождение D)");
        System.out.println("3. Задание 3 (Массив уникальных элементов)");
        System.out.println("4. Задание 4 (Матрица и вектор B)");
        int choice = read.nextInt();

        switch (choice) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            case 4:
                task4();
                break;
            default:
                System.out.println("Неверный выбор. Завершение программы.");
                break;
        }

        read.close();
    }

    // Метод для выполнения первого задания
    public static void task1() {
        System.out.println("Введите a и b:");
        int a = read.nextInt();
        int b = read.nextInt();

        if (a * b > 20) {
            System.out.println("a * b > 20, тогда находим cot(b)");
            double cotan = 1.0 / Math.tan(b);
            System.out.println("cot b = " + cotan);
        } else {
            System.out.println("a * b <= 20, тогда a / 3");
            int result = a / 3;
            System.out.println("Результат a / 3: " + result);
        }
    }

    // Метод для выполнения второго задания
    public static void task2() {
        System.out.println("Введите два числа (c и d):");
        int c = read.nextInt();
        int d = read.nextInt();

        // Находим минимум и максимум
        double max = Math.max(c, d);
        double min = Math.min(c, d);

        // Вычисляем D по формуле
        double xd = (min - 2 * Math.sqrt(max)) / (1 + (max / min));

        // Выводим результат
        System.out.println("D = " + xd);
    }

    // Метод для выполнения третьего задания
    public static void task3() {
        System.out.println("Введите размер массива:");
        int size = read.nextInt();

        // Создаём и заполняем массив случайными значениями
        int[] array = new int[size];
        System.out.println("Сгенерированный массив:");
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Случайные значения от 0 до 99
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Создаём список для хранения индексов уникальных элементов
        List<Integer> uniqueIndices = new ArrayList<>();

        // Используем HashMap для подсчёта количества вхождений каждого элемента
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            countMap.put(array[i], countMap.getOrDefault(array[i], 0) + 1);
        }

        // Проходим по массиву и добавляем индексы уникальных элементов в список
        for (int i = 0; i < size; i++) {
            if (countMap.get(array[i]) == 1) {
                uniqueIndices.add(i);
            }
        }

        // Выводим результат
        System.out.println("Индексы элементов, встречающихся один раз:");
        for (int index : uniqueIndices) {
            System.out.print(index + " ");
        }
        System.out.println();
    }

    // Метод для выполнения четвёртого задания
    public static void task4() {
        System.out.println("Введите количество строк матрицы:");
        int rows = read.nextInt();
        System.out.println("Введите количество столбцов матрицы:");
        int cols = read.nextInt();

        // Создаём и заполняем матрицу случайными значениями
        int[][] matrix = new int[rows][cols];
        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100); // Случайные значения от 0 до 99
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Создаём вектор B
        int[] vectorB = new int[rows];

        // Проверяем, упорядочены ли строки по возрастанию
        for (int i = 0; i < rows; i++) {
            boolean isSorted = true;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j - 1] > matrix[i][j]) {
                    isSorted = false;
                    break;
                }
            }
            vectorB[i] = isSorted ? 1 : 0; // 1, если строка упорядочена, иначе 0
        }

        // Выводим вектор B
        System.out.println("Вектор B:");
        for (int value : vectorB) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

