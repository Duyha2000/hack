package entity;

import util.InputMethods;

import static business.LaptopTypeBusiness.laptopTypes;

public class LaptopType {
    private static int nextId = 0;
    private int typeId;
    private String typeName;
    private boolean isDeleted;
    private String description;

    public LaptopType(int typeId, String typeName, boolean isDeleted, String description) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.isDeleted = isDeleted;
        this.description = description;
    }

    public LaptopType() {
//      typeId auto increment:
        this.typeId = ++nextId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private boolean isTypeNameDuplicate(String typeName) {
        for (LaptopType laptopType : laptopTypes) {
            if (laptopType.getTypeName().equalsIgnoreCase(typeName)) return true;
        }
        return false;
    }

    //    Inputdata:
    public void inputData() {
        if (laptopTypes.length > 0) {
            System.out.println("Danh sách các loại laptop có trạng thái isDeleted là false: ");
            for (LaptopType laptopType : laptopTypes) {
                if (!laptopType.isDeleted()) laptopType.displayData();
            }
        }

        System.out.println("Nhập tên loại laptop - không để trống, không trùng lặp: ");
        this.typeName = InputMethods.getString();

        while (this.typeName.isEmpty() || isTypeNameDuplicate(this.typeName)) {
            if (this.typeName.isEmpty()) {
                System.err.println("Tên loại laptop không hợp lệ, vui lòng nhập lại: ");
            } else {
                System.err.println("Tên loại laptop đã tồn tại, vui lòng nhập lại: ");
            }
            this.typeName = InputMethods.getString();
        }

        System.out.println("Nhập mô tả loại laptop - không để trống: ");
        this.description = InputMethods.getString();
        while (this.description.isEmpty()) {
            System.err.println("Mô tả không hợp lệ, vui lòng nhập lại: ");
            this.description = InputMethods.getString();
        }
    }

    //    Display:
    public void displayData() {
        System.out.printf("|ID : %-4d | Name: %-6s | Deleted: %-6b | Description: %-6s |\n",
                this.typeId, this.typeName, this.isDeleted, this.description);
    }

}
