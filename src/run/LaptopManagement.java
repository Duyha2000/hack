package run;

import business.LaptopBusiness;
import util.InputMethods;

public class LaptopManagement {
    public static final LaptopBusiness laptopBusiness = new LaptopBusiness();


    public static void showMenuLaptop() {
        while (true) {
            System.out.println("""
                    ************************LAPTOP TYPE MENU*************************
                    1. Hiển thị danh sách tất cả laptop có trạng thái chưa xóa
                    2. Thêm mới một laptop
                    3. Sửa thông tin laptop
                    4. Thay đổi trạng thái sản phẩm thành đã xóa
                    5. Thoát""");
            System.out.println("Chọn chức năng (1-5): ");
            byte choice = InputMethods.getByte();


            switch (choice) {
                case 1 -> laptopBusiness.showLaptop();
                case 2 -> laptopBusiness.addLaptop();
                case 3 -> laptopBusiness.updateLaptop();
                case 4 -> laptopBusiness.deleteLaptop();

                case 5 -> System.out.println("Thoát");
                default -> System.err.println("Lựa chọn ko chính xác , vui lòng nhập lại");
            }
            if (choice == 5) break;
        }
    }

}
