package entity;

import business.LaptopTypeBusiness;
import util.InputMethods;

import java.time.LocalDate;

import static business.LaptopTypeBusiness.laptopTypes;

public class Laptop {
    private static int autoId = 0;
    //    Attribute:
    private String laptopId;
    private String laptopName;
    private String description;
    private int ram;
    private double weight;
    private double laptopPrice;
    private LocalDate createdAt;
    private int typeId;
    private boolean isDeleted;

    //    Constructor:
    public Laptop(String laptopId, String laptopName, String description, int ram, double weight, LocalDate createdAt, double laptopPrice, int typeId, boolean isDeleted) {
        this.laptopId = laptopId;
        this.laptopName = laptopName;
        this.description = description;
        this.ram = ram;
        this.weight = weight;
        this.createdAt = createdAt;
        this.laptopPrice = laptopPrice;
        this.typeId = typeId;
        this.isDeleted = isDeleted;
    }

    //    Constructor with no param:
    public Laptop() {
        this.laptopId = String.format("L%04d", ++autoId);
    }

    //    Getter:
    //    Setter:


    public String getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(String laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLaptopPrice() {
        return laptopPrice;
    }

    public void setLaptopPrice(double laptopPrice) {
        this.laptopPrice = laptopPrice;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    //    Method:
    public void inputData() {
        System.out.println("Nhập tên laptop - không để trống, không trùng lặp: ");
        this.laptopName = InputMethods.getString();
        while (this.laptopName.isEmpty()) {
            System.err.println("Tên sản phẩm không hợp lệ, vui lòng nhập lại: ");
            this.laptopName = InputMethods.getString();
        }

        System.out.println("Nhập mô tả - không để trống: ");
        this.description = InputMethods.getString();
        while (this.description.isEmpty()) {
            System.err.println("Mô tả không hợp lệ, vui lòng nhập lại: ");
            this.description = InputMethods.getString();
        }

        System.out.println("Nhập dung lượng RAM - >0: ");
        this.ram = InputMethods.getInteger();
        while (this.ram <= 0) {
            System.err.println("Dung lượng RAM không hợp lệ, vui lòng nhập lại: ");
            this.ram = InputMethods.getInteger();
        }

        System.out.println(" Nhập cân nặng máy - phải >0, format 2 dấu phẩy sau thập phân: ");
        this.weight = InputMethods.getDouble();
        while (this.weight <= 0) {
            System.err.println("Cân nặng không hợp lệ, vui lòng nhập lại: ");
            this.weight = Math.round(InputMethods.getDouble() * 100.0) / 100.0;
        }

        System.out.println(" Nhập - giá tiền - phải >0: ");
        this.laptopPrice = InputMethods.getDouble();
        while (this.weight <= 0) {
            System.err.println("Giá không hợp lệ, vui lòng nhập lại: ");
            this.laptopPrice = InputMethods.getDouble();
        }

        if (laptopTypes.length == 0) {
            System.err.println("Chưa có loại máy tính nào trong danh sách");
            System.err.println("Vui lòng thêm loại máy tính trước khi thêm máy tính");
            LaptopTypeBusiness laptopTypeBusiness = new LaptopTypeBusiness();
            laptopTypeBusiness.addLaptopType();
        }
        System.out.println("Các loại máy tính đã có: ");

        // Hiển thị danh sách các loại máy tính
        LaptopTypeBusiness laptopTypeBusiness = new LaptopTypeBusiness();
        laptopTypeBusiness.showLaptopType();

        System.out.println("Nhập mã loại máy tính: ");
        this.typeId = InputMethods.getInteger();
        while (laptopTypeBusiness.findLaptopTypeById(this.typeId) == null) {
            System.err.println("Mã loại máy tính không tồn tại, vui lòng nhập lại: ");
            this.typeId = InputMethods.getInteger();
        }

    }

    //    Display:
    public void displayData() {
        System.out.printf("|ID : %-4s | Name: %-6s | Description: %-6s | RAM: %-4d | Weight: %-4.2f | Price: %-4.2f | Created At: %-10s | Type ID: %-4d | Is Deleted: %-5b |\n",
                this.laptopId, this.laptopName, this.description, this.ram, this.weight, this.laptopPrice, this.createdAt, this.typeId, this.isDeleted);
    }
}

