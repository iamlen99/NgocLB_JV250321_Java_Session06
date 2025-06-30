import java.util.Scanner;

public class Category {
    private String id;
    private String name;
    private String description;

    public Category(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Category[] categories = new Category[100];
        int currentIndex = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1. Thêm mới danh mục");
            System.out.println("2. Hiển thị danh sách danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm danh mục theo tên");
            System.out.println("6. Thoát");
            System.out.println("Nhập lựa chọn của bạn:");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhap ID danh muc: ");
                    String categoryID = sc.nextLine();
                    System.out.print("Nhap ten danh muc: ");
                    String categoryName = sc.nextLine();
                    System.out.print("Nhap mo ta danh muc: ");
                    String categoryDescription = sc.nextLine();

                    categories[currentIndex] = new Category(categoryID, categoryName, categoryDescription);
                    System.out.println("Danh muc da duoc them.");
                    currentIndex++;
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Danh sach danh muc: ");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("ID: %s, Ten: %s, Mo ta: %s\n", categories[i].getId(),
                                categories[i].getName(), categories[i].getDescription());
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Nhap id danh muc can cap nhat: ");
                    String updateCategoryID = sc.nextLine();
                    System.out.print("Nhap ten moi: ");
                    String updateCategoryName = sc.nextLine();
                    System.out.print("Nhap mo ta moi: ");
                    String updateCategoryDescription = sc.nextLine();

                    boolean isValidId = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (categories[i].getId().equals(updateCategoryID)) {
                            categories[i] = new Category(updateCategoryID, updateCategoryName, updateCategoryDescription);
                            System.out.println("Danh muc da duoc cap nhat");
                            isValidId = true;
                        }
                    }
                    if (!isValidId) {
                        System.out.println("Khong tim thay danh muc co ID vua nhap!");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Nhap ID danh muc can xoa: ");
                    String deleteCategoryID = sc.nextLine();
                    int deleteIndex = 0;

                    boolean isExistId = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (categories[i].getId().equals(deleteCategoryID)) {
                            deleteIndex = i;
                            isExistId = true;
                        }
                    }

                    if (!isExistId) {
                        System.out.println("Khong tim thay danh muc co ID vua nhap!");
                    } else {
                        for (int i = deleteIndex; i < currentIndex; i++) {
                            categories[i] = categories[i + 1];
                        }
                        categories[currentIndex - 1] = null;
                        currentIndex--;
                        System.out.println("Danh muc da duoc xoa.");
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Nhap ten danh muc can tim: ");
                    String searchCategoryName = sc.nextLine();
                    boolean isExistName = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (categories[i].getName().contains(searchCategoryName)) {
                            isExistName = true;
                        }
                    }

                    if (!isExistName) {
                        System.out.println("Khong tim thay danh muc co ten vua nhap!");
                    } else {
                        System.out.println("Danh sach danh muc khop ten:");
                        for (int i = 0; i < currentIndex; i++) {
                            if (categories[i].getName().contains(searchCategoryName)) {
                                System.out.printf("ID: %s, Ten: %s, Mo ta: %s\n", categories[i].getId(),
                                        categories[i].getName(), categories[i].getDescription());
                            }
                        }
                    }
                    break;

                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui long nhap so tu 1-5");
            }
        } while (true);
    }
}
