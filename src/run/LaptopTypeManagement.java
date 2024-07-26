package run;

import business.LaptopTypeBusiness;
import util.InputMethods;

public class LaptopTypeManagement {
    public static final LaptopTypeBusiness laptopTypeBusiness = new LaptopTypeBusiness();


    public static void showMenuLaptopType() {
        while (true) {
            System.out.println("""
                    ************************LAPTOP TYPE MENU*************************
                    1. Hiển thị danh sách các loại laptop có trạng thái isDeleted là false
                    2. Thêm mới một loại laptop
                    3. Sửa thông tin loại laptop
                    4. Thay đổi trạng thái sản phẩm thành đã xóa
                    5. Thoát""");
            System.out.println("Chọn chức năng (1-5): ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1 -> laptopTypeBusiness.showLaptopType();
                case 2 -> laptopTypeBusiness.addLaptopType();
                case 3 -> laptopTypeBusiness.updateLaptopType();
                case 4 -> laptopTypeBusiness.deleteLaptopType();

                case 5 -> System.out.println("Thoát");
                default -> System.err.println("Lựa chọn ko chính xác , vui lòng nhập lại");
            }
            if (choice == 5) break;
        }
    }

   
}