package kiemtra;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        int choice;
        do {
            System.out.printf("""
                    ========= PRODUCT MANAGEMENT SYSTEM =========
                    1. Thêm sản phẩm mới
                    2. Hiển thị danh sách sản phẩm
                    3. Cập nhật số lượng theo ID
                    4. Xóa sản phẩm đã hết hàng
                    5. Thoát chương trình
                    =============================================
                    Lựa chọn của bạn:
                    """);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nhập ID sản phẩm:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (products.stream().anyMatch(p -> p.getId() == id)) {
                        throw new invalidIdException("Id sản phẩm đã tồn tại: " + id);
                    }
                    System.out.println("Nhập tên sản phẩm:");
                    String name = sc.nextLine();
                    System.out.println("Nhập giá sản phẩm:");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Nhập số lượng sản phẩm:");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập danh mục sản phẩm:");
                    String category = sc.nextLine();
                    Product product = new Product(id, name, price, quantity, category);
                    products.add(product);
                    break;
                case 2:
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.println("Nhập ID sản phẩm cần cập nhật:");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    Optional<Product> productToUpdate = products.stream().filter(p-> p.getId() == updateId).findFirst();
                    if (productToUpdate.isEmpty()) {
                        throw new invalidIdException("ID sản phẩm không tồn tại: " + updateId);
                    }
                    System.out.println("Nhập số lượng mới:");
                    int newQuantity = sc.nextInt();
                    sc.nextLine();
                    productToUpdate.get().setQuantity(newQuantity);
                    break;
                case 4:
                    products.stream().filter(p -> p.getQuantity() == 0).forEach(p -> {
                        System.out.println("Đã xóa sản phẩm: " + p);
                        products.remove(p);
                    });
                    break;
                case 5:
                    System.out.println("Thoát chương trình. Hẹn gặp lại!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 5);
    }
}

