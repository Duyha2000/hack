package business;

import entity.Laptop;
import util.InputMethods;

public class LaptopBusiness {
    public static int size = 0;
    public static Laptop[] laptops = new Laptop[size];

    //    1. Hiển thị danh sách các laptop có trạng thái isDeleted là false
    public void showLaptop() {
        if (laptops.length == 0) {
            System.err.println("Chưa có laptop nào trong danh sách");
            return;
        }

        System.out.println("Danh sách các laptop có trạng thái isDeleted là false: ");
        for (Laptop laptop : laptops) {
            if (!laptop.isDeleted()) laptop.displayData();
        }
    }

    //    2. Thêm mới một laptop vào danh sách
    public void addLaptop() {
        System.out.println("Nhập thông tin laptop mới: ");

        Laptop[] newLaptops = new Laptop[size + 1];
        System.arraycopy(laptops, 0, newLaptops, 0, size);
        newLaptops[size] = new Laptop();
        newLaptops[size].inputData();
        laptops = newLaptops;
        size++;
        System.out.println("Thêm mới thành công");
    }

    //    3. Cập nhật thông tin một laptop
    public Laptop findLaptopById(String laptopId) {
        for (Laptop laptop : laptops) {
            if (laptop.getLaptopId().equalsIgnoreCase(laptopId)) return laptop;
        }
        return null;
    }

    public void updateLaptop() {
        System.out.println("Nhập mã loại laptop cần sửa: ");
        String laptopId = InputMethods.getString();

        // Tìm loại laptop theo mã
        Laptop laptop = findLaptopById(laptopId);
        if (laptop == null) {
            System.err.println("Không tìm thấy laptop có mã " + laptopId);
            return;
        }

        // Hiển thị thông tin hiện tại
        System.out.print("Thông tin hiện tại của loại laptop: ");
        laptop.displayData();

        // Nhập thông tin mới
        System.out.println("Nhập thông tin mới: ");
        laptop.inputData();

        System.out.println("Cập nhật thành công");
    }

    //    4. Xóa trạn thái laptop:
    public void deleteLaptop() {
        System.out.println("Nhập mã laptop cần xóa: ");
        String laptopId = InputMethods.getString();

        // Tìm loại laptop theo mã
        Laptop laptop = findLaptopById(laptopId);
        if (laptop == null) {
            System.err.println("Không tìm thấy laptop có mã " + laptopId);
            return;
        }

        laptop.setDeleted(true);
        System.out.println("Xóa thành công");
    }

    //    Thống kê số lượng laptop theo từng loại. Thông tin hiển thị bao gồm :
//    tên loại laptop và số lượng.
    public void countLaptopByType() {
        System.out.println("Thống kê số lượng laptop theo từng loại: ");
        for (Laptop laptop : laptops) {
            if (!laptop.isDeleted()) {
                System.out.println("Tên loại laptop: " + laptop.getLaptopName() + " - Số lượng: " + laptop.getTypeId());
            }
        }
    }
}
