package Btth;

import java.util.Scanner;
import java.util.Arrays;

public class Btth {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== MINI PROJECT SRS =====");
            System.out.println("1. Two Sum");
            System.out.println("2. Move Zeroes");
            System.out.println("3. Valid Palindrome");
            System.out.println("4. Reverse Words");
            System.out.println("5. Happy Number");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Nhập lại: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    twoSum();
                    break;
                case 2:
                    moveZeroes();
                    break;
                case 3:
                    validPalindrome();
                    break;
                case 4:
                    reverseWords();
                    break;
                case 5:
                    happyNumber();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

        } while (choice != 0);
    }

    static void twoSum() {
        System.out.print("Nhập số phần tử mảng: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Nhập target: ");
        int target = scanner.nextInt();

        boolean found = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(i + " " + j);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        if (!found) {
            System.out.println("Không tìm thấy");
        }
    }

    static void moveZeroes() {
        System.out.print("Nhập số phần tử mảng: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        for (int i = index; i < n; i++) {
            arr[i] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }

    static void validPalindrome() {
        System.out.print("Nhập chuỗi: ");
        String s = scanner.nextLine();

        s = s.replaceAll("[^a-zA-Z]", "");
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;
        boolean ok = true;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                ok = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println(ok);
    }

    static void reverseWords() {
        System.out.print("Nhập chuỗi: ");
        String s = scanner.nextLine();

        s = s.trim();
        if (s.length() == 0) {
            System.out.println("");
            return;
        }

        String[] words = s.split("\\s+");
        String result = "";

        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i];
            if (i != 0) result += " ";
        }

        System.out.println(result);
    }

    static void happyNumber() {
        System.out.print("Nhập n: ");
        int n = scanner.nextInt();

        int count = 0;

        while (n != 1 && count < 100) {
            int sum = 0;

            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
            count++;
        }

        if (n == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
