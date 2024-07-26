package business;

import entity.LaptopType;
import util.InputMethods;

public class LaptopTypeBusiness {
    public static int size = 0;
    public static LaptopType[] laptopTypes = new LaptopType[size];

    //    1. Hiển thị danh sách các loại laptop có trạng thái isDeleted là false
    public void showLaptopType() {
        if (laptopTypes.length == 0) {
            System.err.println("Chưa có loại laptop nào trong danh sách");
            return;
        }

        System.out.println("Danh sách các loại laptop có trạng thái isDeleted là false: ");
        for (LaptopType laptopType : laptopTypes) {
            if (!laptopType.isDeleted()) laptopType.displayData();
        }
    }

    //   2. Thêm mới một loại laptop
    public void addLaptopType() {
        System.out.println("Nhập thông tin loại laptop mới: ");
        LaptopType[] newLaptopTypes = new LaptopType[size + 1];
        System.arraycopy(laptopTypes, 0, newLaptopTypes, 0, size);
        newLaptopTypes[size] = new LaptopType(); // Initialize the new element
        newLaptopTypes[size].inputData(); // Call inputData() on the new element
        laptopTypes = newLaptopTypes;
        size++;
        System.out.println("Thêm mới thành công");
    }

    //    Tìm kiếm loại laptop theo mã
    public LaptopType findLaptopTypeById(int typeId) {
        for (LaptopType laptopType : laptopTypes) {
            if (laptopType.getTypeId() == typeId) return laptopType;
        }
        return null;
    }

    // 3. Cập nhật thông tin loại laptop
    public void updateLaptopType() {
        System.out.println("Nhập mã loại laptop cần sửa: ");
        int typeId = InputMethods.getInteger();

        // Tìm loại laptop theo mã
        LaptopType laptopType = findLaptopTypeById(typeId);
        if (laptopType == null) {
            System.err.println("Không tìm thấy loại laptop có mã " + typeId);
            return;
        }

        // Hiển thị thông tin hiện tại
        System.out.println("Thông tin hiện tại của loại laptop: " + laptopType.getTypeName() + " - " + laptopType.getDescription());

        // Lựa chọn thông tin cần sửa
        String choice = "";
        boolean validChoice = true;
        while (validChoice) {
            System.out.println("Chọn thông tin cần sửa (name hoặc description):");
            choice = InputMethods.getString();
            if (choice.equalsIgnoreCase("name") || choice.equalsIgnoreCase("description")) validChoice = false;
            else System.err.println("Thông tin không hợp lệ, vui lòng nhập lại.");
        }

        // Nhập thông tin mới
        System.out.println("Nhập thông tin mới: ");
        String newInfo = InputMethods.getString();

        // Cập nhật thông tin loại laptop
        if (choice.equalsIgnoreCase("name")) laptopType.setTypeName(newInfo);
        else laptopType.setDescription(newInfo);

        System.out.println("Cập nhật thành công");
    }


    //    4. Xóa một loại laptop
    public void deleteLaptopType() {
        System.out.println("Nhập mã loại laptop cần xóa: ");
        int typeId = InputMethods.getInteger();
        LaptopType laptopType = findLaptopTypeById(typeId);
        if (laptopType == null) {
            System.err.println("Không tìm thấy loại laptop có mã " + typeId);
            return;
        }
        laptopType.setDeleted(true);
        System.out.println("Thay đổi trạng thái thành công");
    }

}
