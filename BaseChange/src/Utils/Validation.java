/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author huydo
 */

import java.util.Scanner;

public class Validation {
    private static final Scanner sc = new Scanner(System.in);

    // Kiểm tra lựa chọn menu (giới hạn min - max)
    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.err.print("Invalid input! Please enter choice (" + min + " - " + max + "): ");
            }
        }
    }

    // Kiểm tra định dạng chuỗi số dựa trên cơ số đã chọn
    // choice: 1 (Binary), 2 (Decimal), 3 (Hexadecimal)
    public static String checkInputBase(int choice) {
        while (true) {
            String input = sc.nextLine().trim().toUpperCase();
            if (input.isEmpty()) {
                System.err.print("Input cannot be empty. Please enter again: ");
                continue;
            }

            boolean isValid = false;
            switch (choice) {
                case 1: // Binary
                    isValid = input.matches("^[01]+$");
                    break;
                case 2: // Decimal
                    isValid = input.matches("^[0-9]+$");
                    break;
                case 3: // Hexadecimal
                    isValid = input.matches("^[0-9A-F]+$");
                    break;
            }

            if (isValid) {
                return input;
            } else {
                System.err.print("Invalid format for the chosen base. Please enter again: ");
            }
        }
    }
}
