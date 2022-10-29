import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        int numbersAmount = intList.size();

        // здесь размещаем положительные числа
        ArrayList<Integer> positive = new ArrayList<>();

        // здесь размещаем четные положительные числа
        ArrayList<Integer> even = new ArrayList<>();

        // формируем массивы положительных и четных чисел
        for (Integer n : intList) {
            if (n > 0) {
                positive.add(n);
                if (n % 2 == 0) {
                    even.add(n);
                }
            }
        }

        System.out.println("Исходный массив целых чисел: " + intList.toString());
        System.out.println("Отфильтрованный массив положительных чисел: " + positive.toString());
        System.out.println("Массив четных положительных чисел: " + even.toString());

        // Применим адгоритьм быстрой сортировки (сортируем по возрастанию)
        quickSort(even, 0, even.size() - 1);
        System.out.println("Отсортированный массив четных положительных чисел: " + even.toString());
    }

    public static void quickSort(ArrayList<Integer> arr, int leftBorder, int rightBorder) {

        if (rightBorder - leftBorder > 1) {
            int border = pivoting(arr, leftBorder, rightBorder);
            quickSort(arr, leftBorder, border);
            quickSort(arr, border, rightBorder);
        }
    }

    public static int pivoting(ArrayList<Integer> arr, int leftBorder, int rightBorder) {

        int pi = (leftBorder + rightBorder) / 2;
        // if (pi == leftBorder || pi == rightBorder) return pi;

        int lft = leftBorder;
        int rgt = rightBorder;
        int pivot = arr.get(pi);

        while (true) {
            while (arr.get(lft) < pivot) lft++;
            while (arr.get(rgt) > pivot) rgt--;
            if (lft >= rgt) return lft;
            // if (pi <= lft || pi >= rgt) return lft;

            Integer rswp = arr.get(rgt);
            Integer lswp = arr.get(lft);
            arr.set(rgt, lswp);
            arr.set(lft, rswp);
            lft++;
            rgt--;
        }
    }
}
