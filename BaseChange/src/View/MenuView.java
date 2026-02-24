/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author huydo
 */

import Manager.ConverterManager;
import Utils.Validation;

public class MenuView {

    private ConverterManager manager = new ConverterManager();

    public void display() {
        while (true) {
            System.out.println("\n===== CHANGE BASE NUMBER SYSTEM =====");
            System.out.println("1. Convert Base Number");
            System.out.println("2. Exit");
            System.out.print("Please choose an option: ");
            int option = Validation.checkIntLimit(1, 2);

            if (option == 2) {
                System.out.println("Exiting program...");
                break;
            }

            processConversion();
        }
    }

    private void processConversion() {
        // 1. Chọn hệ cơ số đầu vào
        System.out.println("\nChoose the base number INPUT:");
        System.out.println("1. Binary (Base 2)");
        System.out.println("2. Decimal (Base 10)");
        System.out.println("3. Hexadecimal (Base 16)");
        System.out.print("Your choice: ");
        int inChoice = Validation.checkIntLimit(1, 3);
        int inBase = getBaseValue(inChoice);

        // 2. Chọn hệ cơ số đầu ra
        System.out.println("\nChoose the base number OUTPUT:");
        System.out.println("1. Binary (Base 2)");
        System.out.println("2. Decimal (Base 10)");
        System.out.println("3. Hexadecimal (Base 16)");
        System.out.print("Your choice: ");
        int outChoice = Validation.checkIntLimit(1, 3);
        int outBase = getBaseValue(outChoice);

        // 3. Nhập giá trị
        System.out.print("\nEnter the input value: ");
        String inputValue = Validation.checkInputBase(inChoice);

        // 4. Xử lý và in kết quả
        String outputValue = manager.convertBase(inputValue, inBase, outBase);
        System.out.println("=> Output value: " + outputValue);
    }

    // Hàm phụ trợ đổi từ lựa chọn menu sang giá trị cơ số (base)
    private int getBaseValue(int choice) {
        switch (choice) {
            case 1: return 2;
            case 2: return 10;
            case 3: return 16;
            default: return 10;
        }
    }
}