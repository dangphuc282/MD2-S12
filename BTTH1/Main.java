
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductBusiness productBusiness = new ProductBusiness();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n********** QUẢN LÝ SẢN PHẨM **********");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Danh sách sản phẩm");
            System.out.println("3. Cập nhật sản phẩm theo mã");
            System.out.println("4. Xóa sản phẩm theo mã");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp theo giá tăng dần");
            System.out.println("7. Sắp xếp theo số lượng giảm dần");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            switch (scanner.nextLine()) {
                case "1" -> productBusiness.addProduct(scanner);
                case "2" -> productBusiness.displayProducts();
                case "3" -> productBusiness.updateProduct(scanner);
                case "4" -> productBusiness.deleteProduct(scanner);
                case "5" -> productBusiness.searchByName(scanner);
                case "6" -> productBusiness.sortByPriceAsc();
                case "7" -> productBusiness.sortByQuantityDesc();
                case "8" -> {
                    System.out.println("👋 Thoát chương trình.");
                    exit = true;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
