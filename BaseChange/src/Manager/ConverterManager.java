/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author huydo
 */
package Manager;

import java.math.BigInteger;

public class ConverterManager {

    // Hàm tổng quát điều phối việc chuyển đổi
    public String convertBase(String value, int inBase, int outBase) {
        if (inBase == outBase) {
            return value;
        }
        // Bước 1: Chuyển đầu vào sang Decimal (hệ 10)
        String decimalValue = otherToDecimal(value, inBase);

        // Bước 2: Chuyển từ Decimal sang cơ số đích (hệ 2 hoặc hệ 16)
        return decimalToOther(decimalValue, outBase);
    }

    // Chuyển cơ số bất kỳ (2, 16) sang Decimal (10)
    private String otherToDecimal(String value, int base) {
        if (base == 10) {
            return value;
        }

        BigInteger decValue = BigInteger.ZERO;
        BigInteger baseBig = BigInteger.valueOf(base);

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            int digit = Character.digit(c, base); // Lấy giá trị số của ký tự
            // decValue = decValue * base + digit
            decValue = decValue.multiply(baseBig).add(BigInteger.valueOf(digit));
        }
        return decValue.toString();
    }

    // Chuyển Decimal (10) sang cơ số bất kỳ (2, 16)
    private String decimalToOther(String decString, int base) {
        if (base == 10) {
            return decString;
        }
        if (decString.equals("0")) {
            return "0";
        }

        BigInteger decValue = new BigInteger(decString);
        BigInteger baseBig = BigInteger.valueOf(base);
        StringBuilder result = new StringBuilder();
        char[] hexChars = "0123456789ABCDEF".toCharArray();

        // Thuật toán chia lấy dư liên tục
        while (decValue.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divRem = decValue.divideAndRemainder(baseBig);
            int remainder = divRem[1].intValue(); // Lấy phần dư
            result.append(hexChars[remainder]);
            decValue = divRem[0]; // Cập nhật lại giá trị bằng phần nguyên
        }

        return result.reverse().toString(); // Đảo ngược chuỗi để có kết quả đúng
    }
}
