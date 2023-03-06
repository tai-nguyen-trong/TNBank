/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author vietm
 */
public class Handle {

    public static Double formatString(String strNumber) {
        try {
            String[] words = strNumber.split("\\,");
            String str = "";
            for (int i = 0; i < words.length; i++) {
                str = str + words[i];
            }
            return Double.valueOf(str);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static String formatDouble(Double number) {
        String number_double = String.format("%,.2f", number);
        return number_double.split("\\.")[0];
    }

    public static String formatSTK(String soTaiKhoan) {
        String str1 = soTaiKhoan.substring(0, 3);
        String str2 = soTaiKhoan.substring(6, 8);
        String str3 = soTaiKhoan.substring(9, 10);
        return str1 + "xxxx" + str2 + "x" + str3;
        //100xxx00x0
    }
}
