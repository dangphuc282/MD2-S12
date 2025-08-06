import ra.entity.Product;
import java.util.*;

public class ProductBusiness {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Scanner scanner) {
        Product newProduct = new Product();
        newProduct.inputData(scanner, true, productList);
        productList.add(newProduct);
        System.out.println("Đã thêm sản phẩm.");
    }

    public void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            productList.forEach(System.out::println);
        }
    }

    public void updateProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        Optional<Product> opt = productList.stream().filter(p -> p.getProductId() == id).findFirst();
        if (opt.isPresent()) {
            Product product = opt.get();
            product.inputData(scanner, false, productList);
            System.out.println("Cập nhật thành công.");
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    public void deleteProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean removed = productList.removeIf(p -> p.getProductId() == id);
        System.out.println(removed ? "Đã xóa sản phẩm." : "Không tìm thấy sản phẩm.");
    }

    public void searchByName(Scanner scanner) {
        System.out.print("Nhập từ khóa tên sản phẩm: ");
        String keyword = scanner.nextLine().toLowerCase();
        List<Product> result = productList.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(keyword))
                .toList();
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm.");
        } else {
            result.forEach(System.out::println);
        }
    }

    public void sortByPriceAsc() {
        productList.sort(Comparator.comparing(Product::getPrice));
        displayProducts();
    }

    public void sortByQuantityDesc() {
        productList.sort((p1, p2) -> Integer.compare(p2.getQuantity(), p1.getQuantity()));
        displayProducts();
    }
}
