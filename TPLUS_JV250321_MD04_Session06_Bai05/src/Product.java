import java.util.Scanner;

public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] productArr = new Product[100];
        int currentIndex = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("Nhập lựa chọn của bạn:");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhap ID san pham: ");
                    String productID = sc.nextLine();
                    System.out.print("Nhap ten san pham: ");
                    String productName = sc.nextLine();
                    System.out.print("Nhap gia san pham: ");
                    Double productPrice = Double.parseDouble(sc.nextLine());

                    productArr[currentIndex] = new Product(productID, productName, productPrice);
                    System.out.println("San pham da duoc them.");
                    currentIndex++;
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Danh sach san pham: ");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("ID: %s, Ten: %s, Gia: %.1f\n", productArr[i].getId(),
                                productArr[i].getName(), productArr[i].getPrice());
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Nhap id san pham can cap nhat: ");
                    String updateProductID = sc.nextLine();
                    System.out.print("Nhap ten moi: ");
                    String updateProductName = sc.nextLine();
                    System.out.print("Nhap gia moi ");
                    Double updateProductPrice = Double.parseDouble(sc.nextLine());

                    boolean isValidId = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (productArr[i].getId().equals(updateProductID)) {
                            productArr[i] = new Product(updateProductID, updateProductName, updateProductPrice);
                            System.out.println("San pham da duoc cap nhat");
                            isValidId = true;
                        }
                    }
                    if (!isValidId) {
                        System.out.println("Khong tim thay san pham co ID vua nhap!");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Nhap ID san pham can xoa: ");
                    String deleteProductID = sc.nextLine();
                    int deleteIndex = 0;

                    boolean isExistId = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (productArr[i].getId().equals(deleteProductID)) {
                            deleteIndex = i;
                            isExistId = true;
                        }
                    }

                    if (!isExistId) {
                        System.out.println("Khong tim thay san pham co ID vua nhap!");
                    } else {
                        for (int i = deleteIndex; i < currentIndex; i++) {
                                productArr[i] = productArr[i + 1];
                        }
                        productArr[currentIndex - 1] = null;
                        currentIndex--;
                        System.out.println("San pham da duoc xoa.");
                    }
                    System.out.println();
                    break;

                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui long nhap so tu 1-5");
            }
        } while (true);
    }
}
