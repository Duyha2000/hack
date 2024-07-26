package run;

import util.InputMethods;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("************************LAPTOP MANAGEMENT*************************\n" +
                    "1. Quản lý loại laptop\n" +
                    "2. Quản lý laptop\n" +
                    "3. Thoát");
            System.out.println("Nhập lựa chọn của bạn:");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    // Quản lý loại laptop
                    LaptopTypeManagement.showMenuLaptopType();
                    break;
                case 2:
                    // Quản lý laptop
                    LaptopManagement.showMenuLaptop();

                    break;
                case 3:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
            if (choice == 3) break;
        }
    }
}